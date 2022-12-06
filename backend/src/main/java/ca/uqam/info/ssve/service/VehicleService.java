package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.*;
import ca.uqam.info.ssve.repository.VehicleRepository;
import ca.uqam.info.ssve.server.ADVEConnection;
import ca.uqam.info.ssve.model.Evaluation;
import ca.uqam.info.ssve.model.Vehicle;
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
        if (validateBrand(vehicle.getBrand())
                && validateModelName(vehicle.getModelName())
                && validatePrice(vehicle.getPrice())
                && validateNbPlaces(vehicle.getNbPlaces())
                && validateType(vehicle.getType())
                && validateMaintainCosts(vehicle.getMaintainCosts())
                && validateElectricalCapacity(vehicle.getElectricalCapacity())
                && validateElectricalConsumption(vehicle.getElectricalStreetConsumption())
                && validateElectricalConsumption(vehicle.getElectricalHighwayConsumption())
                && validateGasCapacity(vehicle.getGasCapacity())
                && validateGasConsumption(vehicle.getGasStreetConsumption())
                && validateGasConsumption(vehicle.getGasHighwayConsumption())
                && validateLoadCapacity(vehicle.getLoadCapacity())
                && validateSafetyScore(vehicle.getSafetyScore())
                && validateRefLink(vehicle.getRefLink())
                && validateImgLink(vehicle.getImgLink())
                && validateDescription(vehicle.getDescription())) {
            return vehicleRepository.save(vehicle);
        }
        throw new IllegalArgumentException();
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    public Vehicle modifyVehicle(Vehicle vehicle) {
        if (validateBrand(vehicle.getBrand())
                && validateModelName(vehicle.getModelName())
                && validatePrice(vehicle.getPrice())
                && validateNbPlaces(vehicle.getNbPlaces())
                && validateType(vehicle.getType())
                && validateMaintainCosts(vehicle.getMaintainCosts())
                && validateElectricalCapacity(vehicle.getElectricalCapacity())
                && validateElectricalConsumption(vehicle.getElectricalStreetConsumption())
                && validateElectricalConsumption(vehicle.getElectricalHighwayConsumption())
                && validateGasCapacity(vehicle.getGasCapacity())
                && validateGasConsumption(vehicle.getGasStreetConsumption())
                && validateGasConsumption(vehicle.getGasHighwayConsumption())
                && validateLoadCapacity(vehicle.getLoadCapacity())
                && validateSafetyScore(vehicle.getSafetyScore())
                && validateRefLink(vehicle.getRefLink())
                && validateImgLink(vehicle.getImgLink())
                && validateDescription(vehicle.getDescription())
                && vehicleRepository.findById(vehicle.getId()).isPresent()) {
            return vehicleRepository.save(vehicle);
        }
        throw new IllegalArgumentException();
    }

    // ----------------------------------------------------
    private boolean validateBrand(String brand) {
        return brand.matches("[a-zA-Z]+");
    }

    private boolean validateModelName(String modelName) {
        return modelName.matches("[A-Za-z\s0-9]+");
    }

    private boolean validateNbPlaces(int nbDoors) {
        return nbDoors > 0 && nbDoors < 10;
    }

    private boolean validateElectricalCapacity(int electricalCapacity) {
        return electricalCapacity > 0 && electricalCapacity < 500;
    }

    private boolean validateElectricalConsumption(double electricalConsumption) {
        return electricalConsumption > 0 && electricalConsumption < 100;
    }

    private boolean validateGasCapacity(int gasCapacity) {
        return gasCapacity > 0 && gasCapacity < 500;
    }

    private boolean validateGasConsumption(double gasConsumption) {
        return gasConsumption > 0 && gasConsumption < 100;
    }

    private boolean validateLoadCapacity(int loadCapacity) {
        return loadCapacity > 0 && loadCapacity < 500;
    }

    private boolean validateType(String type) {
        return type.matches("[a-zA-Z]+");
    }

    private boolean validatePrice(int price) {
        return price > 0 && price < Integer.MAX_VALUE;
    }

    private boolean validateMaintainCosts(double maintainCosts) {
        return maintainCosts > 0 && maintainCosts < 1000;
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

    private boolean validateDescription(String description) {
        return description.length() >= 0 && description.length() < 1000;
    }

    // --------------------------------- ---------------------------------------

    public List<Evaluation> evaluateVehicle(TripNeeds tripNeeds) throws IOException, JSchException, InterruptedException {
         adveConnection.connectServer();
         ArrayList<Route> routeList = new ArrayList<>();
         ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();
         int frequenceTotale = 0;

         // --------Détermination de la fréquence total et du poid de chaque route
         for (Trip x : tripNeeds.getTrips()) {
             Route route = new Route();
             route.setFrequence(x.getFreq());
             route.setTrip(x);
             frequenceTotale += route.getFrequence();
             routeList.add(route);
         }

         for (Route route : routeList) {
            route.setWeight(getPercentage(route.getFrequence(), frequenceTotale));
         }

         // --------Évaluation de chaque route pour chaque voiture et calcule de la
         //note
         List<Vehicle> allVehicle = getAllVehicle();
         allVehicle.sort(Comparator.comparing(Vehicle::getElectricalCapacity));

         int nbTrajetSansRecharge = 0;

         for (int i = 0; i < allVehicle.size(); i++) {
             double score = 0;
             boolean routeATempsDeRecharge = false;
             for (Route route : routeList) {
                 // --------Obtient les infos du déplacement avec la boite noire
                 for (int indexStop = 0; indexStop < route.getTrip().getStops().size(); indexStop++){
                     if(indexStop + 1 >= route.getTrip().getStops().size())
                         break;

                     String data = adveConnection.doRequest(requeteString(route, indexStop) + allVehicle.get(i).getElectricalCapacity() *
                             100);
                     stringToRoute(route, data);

                     if (route.getChargingTime() != 0)
                         routeATempsDeRecharge = true;
                 }

                 if(!routeATempsDeRecharge)
                    nbTrajetSansRecharge++;

                 evaluateRoute(route, allVehicle, i);
                 score = score + (route.getWeight() * route.getScore());
             }

             // --------Ajoute le score final a la voiture et l'ajoute dans la liste a retourner
             Evaluation evaluation = new Evaluation(allVehicle.get(i));
             evaluation.setScore(score);
             evaluation.setNbTrajetSansRecharge(nbTrajetSansRecharge);
             evaluation.setTrajetTotal(routeList.size());
             vehicleFinalScore.add(evaluation);
         }
         adveConnection.closeServer();
         vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
         Collections.reverse(vehicleFinalScore);
         return vehicleFinalScore;
    }

    public static double getPercentage(double part, double whole) {
        return new BigDecimal(part * 100 / whole).doubleValue();
    }

    /**
     * Méthode pour arrondire un nombre
     * 
     * @param value:  valeur a arrondire
     * @param places: nombre de chiffre après la virgule
     * @return
     */
    public static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();

        long factor = (long) Math.pow(10, places);
        value = value * factor;
        long tmp = Math.round(value);
        return (double) tmp / factor;
    }

    /**
     * Méthode pour traduire un string et ajouter ses valeurs dans un objet Route
     *
     * @param route: Objet Route à modifier
     * @param data:  String à traduire
     */
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

    private String requeteString(Route route, int index) {
        String start = "(" + route.getTrip().getStops().get(index).getLat() + ","
                + route.getTrip().getStops().get(index).getLgt() + ")";
        String end = "(" + route.getTrip().getStops().get(index+1).getLat() + "," + route.getTrip().getStops().get(index+1).getLgt()
                + ")";
        return start + " " + end + " ";
    }

    private void evaluateRoute(Route route, List<Vehicle> vehicle, int i) {
        double poid1 = 0.75;
        double poid2 = 0.25;
        double note1 = getPercentage(vehicle.get(i).getElectricalCapacity(), route.getDistance());
        if (note1 > 100)
            note1 = 100;
        int rangeMax = 0;
        for (int j = 0; j < vehicle.size(); j++) {
            if (vehicle.get(j).getElectricalCapacity() > rangeMax) {
                rangeMax = vehicle.get(j).getElectricalCapacity();
            }
        }
        double note2 = getPercentage((vehicle.get(i).getElectricalCapacity() - route.getDistance()),
                (rangeMax - route.getDistance()));
        if (note2 > 100) {
            note2 = 100;
        } else if (note2 < 0) {
            note2 = 0;
        }
        route.setScore(poid1 * note1 + poid2 * note2);
    }


    //------------------------------TEMPORAIRE--------------------------------------------------------------------------


    public List<Evaluation> evaluateVehicleTest() throws IOException, JSchException, InterruptedException {
        TripNeeds tripNeeds = newTripNeed();
        adveConnection.connectServer();
        ArrayList<Route> routeList = new ArrayList<>();
        ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();
        int frequenceTotale = 0;

        // --------Détermination de la fréquence total et du poid de chaque route
        for (Trip x : tripNeeds.getTrips()) {
            Route route = new Route();
            route.setFrequence(x.getFreq());
            route.setTrip(x);
            frequenceTotale += route.getFrequence();
            routeList.add(route);
        }

        for (Route route : routeList) {
            route.setWeight(getPercentage(route.getFrequence(), frequenceTotale));
        }

        // --------Évaluation de chaque route pour chaque voiture et calcule de la
        //note
        List<Vehicle> allVehicle = getAllVehicle();
        allVehicle.sort(Comparator.comparing(Vehicle::getElectricalCapacity));

        int nbTrajetSansRecharge = 0;

        for (int i = 0; i < allVehicle.size(); i++) {
            double score = 0;
            boolean routeATempsDeRecharge = false;
            for (Route route : routeList) {
                // --------Obtient les infos du déplacement avec la boite noire
                for (int indexStop = 0; indexStop < route.getTrip().getStops().size(); indexStop++){
                    if(indexStop + 1 >= route.getTrip().getStops().size())
                        break;
                    String data = adveConnection.doRequest(requeteString(route, indexStop) + allVehicle.get(i).getElectricalCapacity() *
                            1000);
                    System.out.println("data --> " + data);
                    stringToRoute(route, data);

                    if (route.getChargingTime() != 0)
                        routeATempsDeRecharge = true;
                }

                if(!routeATempsDeRecharge)
                    nbTrajetSansRecharge++;

                evaluateRoute(route, allVehicle, i);
                score = score + ((route.getWeight()/100) * route.getScore());
                score = round(score, 2);
            }

            // --------Ajoute le score final a la voiture et l'ajoute dans la liste a retourner
            Evaluation evaluation = new Evaluation(allVehicle.get(i));
            evaluation.setScore(score);
            evaluation.setNbTrajetSansRecharge(nbTrajetSansRecharge);
            evaluation.setTrajetTotal(routeList.size());
            vehicleFinalScore.add(evaluation);
        }
        adveConnection.closeServer();
        vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
        Collections.reverse(vehicleFinalScore);
        return vehicleFinalScore;
    }

    private TripNeeds newTripNeed() {
        /*//---------MIN------------------
        GeoPoint minGeo1 = new GeoPoint("min1", 45.51963513223519, -73.64121842695846);
        GeoPoint minGeo2 = new GeoPoint("min2", 45.51934642873574, -73.64017685359295);
        List<GeoPoint> geoPointMinList = new ArrayList<>();
        geoPointMinList.add(minGeo1);
        geoPointMinList.add(minGeo2);
        Trip trip = new Trip("Min", geoPointMinList, 2);
        TripNeeds tripNeeds = new TripNeeds();
        tripNeeds.trips.add(trip);
        return tripNeeds;


        //---------MAX------------------
        GeoPoint maxGeo1 = new GeoPoint("max1", 48.829245888782516, -64.48377519433731);
        GeoPoint maxGeo2 = new GeoPoint("max2", 45.461830145587854, -75.69938395612203);
        List<GeoPoint> geoPointMaxList = new ArrayList<>();
        geoPointMaxList.add(maxGeo1);
        geoPointMaxList.add(maxGeo2);
        Trip trip = new Trip("Max", geoPointMaxList, 2);
        TripNeeds tripNeeds = new TripNeeds();
        tripNeeds.trips.add(trip);
        return tripNeeds;

        //---------Impossible------------------
        GeoPoint impGeo1 = new GeoPoint("imp1", 61.59780702431485, -71.9571001824064);
        GeoPoint impGeo2 = new GeoPoint("imp2", 45.461830145587854, -75.69938395612203);
        List<GeoPoint> geoPointImpList = new ArrayList<>();
        geoPointMinList.add(impGeo1);
        geoPointMinList.add(impGeo2);
        Trip trip = new Trip("Impossible", geoPointImpList, 2);
        TripNeeds tripNeeds = new TripNeeds();
        tripNeeds.trips.add(trip);
        return tripNeeds*/

        //---------MOYEN------------------
        GeoPoint maxGeo1 = new GeoPoint("max1", 45.5382, -73.9159);
        GeoPoint maxGeo2 = new GeoPoint("max2", 45.1138, -72.3623);
        List<GeoPoint> geoPointMaxList = new ArrayList<>();
        geoPointMaxList.add(maxGeo1);
        geoPointMaxList.add(maxGeo2);
        Trip trip = new Trip("Max", geoPointMaxList, 2);
        TripNeeds tripNeeds = new TripNeeds();
        tripNeeds.trips.add(trip);
        return tripNeeds;

    }
}
