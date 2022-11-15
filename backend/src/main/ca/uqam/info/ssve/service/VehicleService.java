package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.*;
import ca.uqam.info.ssve.repository.VehicleRepository;
import ca.uqam.info.ssve.server.ADVEConnection;
import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;
    private ADVEConnection adveConnection = new ADVEConnection();

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).get();
    }

    /**
     * @param vehicle
     * @return
     */
    public Vehicle addVehicle(Vehicle vehicle) {
        if (
                validateBrand(vehicle.getBrand())
                        && validateModelName(vehicle.getModelName())
                        && validatePrice(vehicle.getPrice())
                        && validateNbDoors(vehicle.getNbDoors())
                        && validateType(vehicle.getType())
                        && validateRange(vehicle.getRange())
                        && validateBatteryCapacity(vehicle.getBatteryCapacity())
                        && validateSafetyScore(vehicle.getSafetyScore())
                        && validateRefLink(vehicle.getRefLink())
                        && validateImgLink(vehicle.getImgLink())
        ) {
            long size = vehicleRepository.count();
            vehicleRepository.save(vehicle);
            Optional<Vehicle> voiture = vehicleRepository.findById(size + 1);
            if (voiture.isPresent()) {
                return voiture.get();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    public Vehicle modifyVehicle(Vehicle vehicle) {
        if (
                validateBrand(vehicle.getBrand())
                        && validateModelName(vehicle.getModelName())
                        && validatePrice(vehicle.getPrice())
                        && validateNbDoors(vehicle.getNbDoors())
                        && validateType(vehicle.getType())
                        && validateRange(vehicle.getRange())
                        && validateBatteryCapacity(vehicle.getBatteryCapacity())
                        && validateSafetyScore(vehicle.getSafetyScore())
                        && validateRefLink(vehicle.getRefLink())
                        && validateImgLink(vehicle.getImgLink())
                        && vehicleRepository.findById(vehicle.getId()).isPresent()
        ) {
            vehicleRepository.save(vehicle);
            return vehicleRepository.findById(vehicle.getId()).get();
        }
        throw new IllegalArgumentException();
    }


    // ----------------------------------------------------   ----------------------------------------
    private boolean validateBrand(String brand) {
        return brand.matches("[a-zA-Z]+");
    }

    private boolean validateModelName(String modelName) {
        return modelName.matches("[A-Za-z\s0-9]+");
    }

    private boolean validateNbDoors(int nbDoors) {
        return nbDoors > 0 && nbDoors < 10;
    }

    private boolean validateType(String type) {
        return type.matches("[a-zA-Z]+");
    }

    private boolean validatePrice(int price) {
        return price > 0 && price < Integer.MAX_VALUE;
    }

    private boolean validateRange(int range) {
        return range > 0 && range < 2000;
    }

    private boolean validateBatteryCapacity(int batteryCapacity) {
        return batteryCapacity > 0 && batteryCapacity < Integer.MAX_VALUE;
    }

    private boolean validateSafetyScore(int safetyScore) {
        return safetyScore >= 0 && safetyScore <= 5;
    }

    private boolean validateRefLink(String refLink) {
        return refLink.matches("(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
    }


    private boolean validateImgLink(String imgLink) {
        return imgLink.matches("(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
    }

    //--------------------------------- ---------------------------------------
    private boolean validateId(Long id) {
        return id > 0 && id < Integer.MAX_VALUE;
    }


    private boolean validateScore(double score) {
        return score >= 0.0 && score <= 15.0;
    }


    public List<Evaluation> evaluateVehicle(List<Deplacement> coordinateList) throws IOException, JSchException, InterruptedException {
        //-------- DÉBUT ALGO RÉEL---------
        adveConnection.connectServer();
        ArrayList<Route> routeList = new ArrayList<>();
        ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();
        int frequenceTotale = 0;

        //--------Détermination de la fréquence total et du poid de chaque route
        for (Deplacement x : coordinateList) {
            Route route = new Route();
            route.setFrequence(x.getFd().getNb_days());
            route.setDeplacement(x);
            frequenceTotale += route.getFrequence();
            routeList.add(route);
        }
        for (Route route : routeList){
            route.setWeight(getPercentage(route.getFrequence(), frequenceTotale));
        }

        //--------Évaluation de chaque route pour chaque voiture et calcule de la note final
        List<Vehicle> allVehicle = getAllVehicle();
        allVehicle.sort(Comparator.comparing(Vehicle::getRange));
        for (int i = 0; i < allVehicle.size(); i++) {
            double score = 0;
            for (Route route : routeList) {
                //--------Obtien les infos du déplacement avec la boite noir
                String data = adveConnection.doRequest(requeteString(route) + allVehicle.get(i).getRange()*100);
                stringToRoute(route, data);
                //--------Donne une note au déplacement pour la voiture i
                evaluateRoute(route, allVehicle, i);
            }
            //-------- Calcule la note final de la voiture selon la note de chaque déplacement
            for (Route route : routeList)
                score = score + (route.getWeight() * route.getScore());

            //--------Ajoute le score final a la voiture et l'ajoute dans la liste a retourné
            Evaluation evaluation = new Evaluation(allVehicle.get(i));
            evaluation.setScore(score);
            vehicleFinalScore.add(evaluation);
        }
        adveConnection.closeServer();

        //--------Sort les voitures par score
        vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
        return vehicleFinalScore;
    }

    private String requeteString(Route route) {
        String start =
                "(" + route.getDeplacement().getStart().getLat() + "," + route.getDeplacement().getStart().getLgt() + ")";
        String end =
                "(" + route.getDeplacement().getEnd().getLat() + "," + route.getDeplacement().getEnd().getLgt() + ")";
        return start + " " + end + " ";
    }


    private void evaluateRoute(Route route, List<Vehicle> vehicle, int i) {
        double poid1 = 0.75;
        double poid2 = 0.25;
        double note1 = getPercentage(vehicle.get(i).getRange(), route.getDistance());
        if (note1 > 100)
            note1 = 100;
        int rangeMax = vehicle.get(0).getRange();
        double note2 = getPercentage((vehicle.get(i).getRange()- route.getDistance()),(rangeMax- route.getDistance()));
        if (note2 > 100) {
            note2 = 100;
        }
        route.setScore(poid1 * note1 + poid2 * note2);
    }

    public static double getPercentage(double part, double whole) {
        return new BigDecimal(part * 100 / whole).doubleValue();
    }

    private void stringToRoute(Route route, String data) {
        int valueNum = 0;
        int space1 = 0;
        int space2 = 0;
        int space3 = 0;
        String[] splited = data.split(" ");
        route.setDistance(Double.parseDouble(splited[0]));
        route.setTripTime(Double.parseDouble(splited[1]));
        route.setWaitingTime(Double.parseDouble(splited[2]));
        route.setChargingTime(Double.parseDouble(splited[3]));
    }

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }



//--------------------------------- MÉTHODE TEMPORAIRE POUR TESTER L'ALGORITHME ---------------------------------

    /**
     * Méthode pour retourné une note aléatoire a chaque véhicule afin de tester le frontend. Temporaire
     * @return List de voiture avec une note aléatoire.
     */
    public List<Evaluation> dummyScore() {
        List<Vehicle> list = getAllVehicle();
        List<Evaluation> list2 = new ArrayList<>();
        for (Vehicle vehicle : list) {
            Evaluation eval = new Evaluation();
            eval.setId(vehicle.getId());
            eval.setBrand(vehicle.getBrand());
            eval.setModelName(vehicle.getModelName());
            eval.setNbDoors(vehicle.getNbDoors());
            eval.setType(vehicle.getType());
            eval.setPrice(vehicle.getPrice());
            eval.setRange(vehicle.getRange());
            eval.setBatteryCapacity(vehicle.getBatteryCapacity());
            eval.setSafetyScore(vehicle.getSafetyScore());
            eval.setRefLink(vehicle.getRefLink());
            eval.setImgLink(vehicle.getImgLink());
            list2.add(eval);
        }

        return list2;
    }

    /**
     * Méthode pour testé l'algorithme avec un input de déplacement controllé. Temporaire.
     * @return
     * @throws IOException
     * @throws JSchException
     * @throws InterruptedException
     */
    public List<Evaluation> evaluateVehicleTest() throws IOException, JSchException, InterruptedException {
        List<Deplacement> coordinateList = createDeplacementList(); //DummyList erase when real ones comes
        adveConnection.connectServer();
        //-------- DÉBUT ALGO RÉEL---------
        ArrayList<Route> routeList = new ArrayList<>();
        ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();
        int frequenceTotale = 0;
        //--------Détermination de la fréquence total et du poid de chaque route
        for (Deplacement x : coordinateList) {
            Route route = new Route();
            route.setFrequence(x.getFd().getNb_days());
            route.setDeplacement(x);
            frequenceTotale += route.getFrequence();
            routeList.add(route);
        }
        for (Route route : routeList) {
            route.setWeight(getPercentage(route.getFrequence(), frequenceTotale));
        }

        //--------Évaluation de chaque route pour chaque voiture et calcule de la note final
        List<Vehicle> allVehicle = getAllVehicle();
        allVehicle.sort(Comparator.comparing(Vehicle::getRange));
        for (int i = 0; i < allVehicle.size(); i++) {
            double score = 0;
            for (Route route : routeList) {
                //--------Obtien les infos du déplacement avec la boite noir
                System.out.println("call:");
                String data = adveConnection.doRequest(requeteString(route) + allVehicle.get(i).getRange()*1000);
                System.out.println("data: " + data);
                //--------Donne une note au déplacement pour la voiture i
                if (data.contains("Impossible")){
                    route.setScore(0);
                }else {
                    stringToRoute(route, data);
                    evaluateRoute(route, allVehicle, i);
                }
            }
            //-------- Calcule la note final de la voiture selon la note de chaque déplacement
            for (Route route : routeList)
                score = score + ((route.getWeight()/100) * route.getScore());
            //--------Ajoute le score final a la voiture et l'ajoute dans la liste a retourné
            Evaluation evaluation = new Evaluation(allVehicle.get(i));
            evaluation.setScore(round(score, 2));
            vehicleFinalScore.add(evaluation);
        }
        adveConnection.closeServer();

        //--------Sort les voitures par score
        vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
        return vehicleFinalScore;
    }

    private List<Deplacement> createDeplacementList() {
        List<Deplacement> deplacementList = new ArrayList<>();
        /*//normal
        deplacementList.add(new Deplacement(1, new PointGeo(45.1138, -72.3623), new PointGeo(45.5382, -73.9159), FrequenceDeplacement.TWICE_A_YEAR));
        deplacementList.add(new Deplacement(1, new PointGeo(48.0293, -71.7262), new PointGeo(45.0393, -72.5376), FrequenceDeplacement.ONCE_A_YEAR));
        deplacementList.add(new Deplacement(1, new PointGeo(47.6861, -70.3343), new PointGeo(48.2191, -68.9323), FrequenceDeplacement.ONCE_A_YEAR));
        //Min
        deplacementList.add(new Deplacement(1, new PointGeo(45.51963513223519, -73.64121842695846), new PointGeo(45.51934642873574, -73.64017685359295), FrequenceDeplacement.ONCE_A_YEAR));
        deplacementList.add(new Deplacement(1, new PointGeo(45.568363215529445, -73.57952489894289), new PointGeo(45.56722615890229, -73.57574873076257), FrequenceDeplacement.ONCE_A_YEAR));
        //Max
        deplacementList.add(new Deplacement(1, new PointGeo(45.404567768292274, -73.9545708308814), new PointGeo(45.7016485378072, -73.47982044062513), FrequenceDeplacement.TWICE_A_YEAR));
        deplacementList.add(new Deplacement(1, new PointGeo(45.701810104949196, -73.47925907001209), new PointGeo(45.40608420341184, -73.93127599467023), FrequenceDeplacement.ONCE_A_YEAR));
        //Max Quebec 48.829245888782516, -64.48377519433731 -> 45.461830145587854, -75.69938395612203
        deplacementList.add(new Deplacement(1, new PointGeo(45.406849308752534, -73.95165370074388), new PointGeo(48.416104487551735, -71.070981205327), FrequenceDeplacement.TWICE_A_YEAR));
        deplacementList.add(new Deplacement(1, new PointGeo(48.829245888782516, -64.48377519433731), new PointGeo(45.461830145587854, -75.69938395612203), FrequenceDeplacement.ONCE_A_WEEK));
        //Impossible pour tous 61.59780702431485, -71.9571001824064 -> 45.461830145587854, -75.69938395612203
        deplacementList.add(new Deplacement(1, new PointGeo(61.59780702431485, -71.9571001824064), new PointGeo(45.461830145587854, -75.69938395612203), FrequenceDeplacement.ONCE_A_WEEK));
        *///Impossible pour le minimum seulement 48.098557266958686, -77.77749506611988 -> 46.55002722055268, -75.5000386258611
        deplacementList.add(new Deplacement(1, new PointGeo(48.098557266958686, -77.77749506611988), new PointGeo(46.55002722055268, -75.5000386258611), FrequenceDeplacement.ONCE_A_WEEK));

        return deplacementList;
    }
}
