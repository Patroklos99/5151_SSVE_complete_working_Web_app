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
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    public Vehicle modifyVehicle(Vehicle vehicle) {
        if (vehicleRepository.findById(vehicle.getId()).isPresent())
            return vehicleRepository.save(vehicle);
        throw new IllegalArgumentException();
    }

    private boolean validateImgLink(String imgLink) {
        return imgLink.matches("(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
    }

    // --------------------------------- ---------------------------------------

    public List<Evaluation> evaluateVehicle(TripNeeds tripNeeds)
            throws IOException, JSchException, InterruptedException {
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

        // --------Évaluation de chaque route pour chaque voiture et calcule de la note
        List<Vehicle> allVehicle = getAllVehicle();
        allVehicle.sort(Comparator.comparing(Vehicle::getElectricalCapacity));

        int nbTrajetSansRecharge = 0;

        for (int i = 0; i < allVehicle.size(); i++) {
            double score = 0;
            boolean routeATempsDeRecharge = false;
            for (Route route : routeList) {
                // --------Obtient les infos du déplacement avec la boite noire
                for (int indexStop = 0; indexStop < route.getTrip().getStops().size(); indexStop++) {
                    if (indexStop + 1 >= route.getTrip().getStops().size())
                        break;

                    String data = adveConnection.doRequest(requeteString(route, indexStop) + allVehicle.get(i).getElectricalCapacity() * 1000);
                    System.out.println("data --> " + data);
                    stringToRoute(route, data);

                    if (route.getChargingTime() != 0)
                        routeATempsDeRecharge = true;
                }

                if (!routeATempsDeRecharge)
                    nbTrajetSansRecharge++;

                evaluateRoute(route, allVehicle, i);
                score = score +((route.getWeight()/100) * route.getScore());
                score = round(score, 2);
            }

            // --------Ajoute le score final a la voiture et l'ajoute dans la liste a retourner
            Evaluation evaluation = new Evaluation(allVehicle.get(i));
            evaluation.setScore(score / 100);
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
        if (whole != 0) {
            return new BigDecimal(part * 100 / whole).doubleValue();
        } else {
            return 0;
        }

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
        String[] splited = data.split(" ");
        route.setDistance(Double.parseDouble(splited[0]));
        route.setTripTime(Double.parseDouble(splited[1]));
        route.setWaitingTime(Double.parseDouble(splited[2]));
        route.setChargingTime(Double.parseDouble(splited[3]));
    }

    private String requeteString(Route route, int index) {
        String start = "(" + route.getTrip().getStops().get(index).getLat() + ","
                + route.getTrip().getStops().get(index).getLgt() + ")";
        String end = "(" + route.getTrip().getStops().get(index + 1).getLat() + ","
                + route.getTrip().getStops().get(index + 1).getLgt()
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
}
