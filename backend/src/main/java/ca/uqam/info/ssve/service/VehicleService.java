package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.*;
import ca.uqam.info.ssve.repository.VehicleRepository;
import ca.uqam.info.ssve.server.ADVEConnection;
import ca.uqam.info.ssve.model.Evaluation;
import ca.uqam.info.ssve.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Evaluation> evaluateVehicle(TripNeeds tripNeeds) {
        List<Vehicle> vehicles = getAllVehicle();
        ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();

        for (Vehicle v : vehicles) {
            Evaluation e = new Evaluation(v);
            e.setNbTrajetSansRecharge((int) (Math.random() * 10));
            e.setScore((int) (Math.random() * 100));
            e.setTrajetTotal((int) (Math.random() * 10));
            vehicleFinalScore.add(e);
        }

        vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
        Collections.reverse(vehicleFinalScore);

        return vehicleFinalScore;

        // adveConnection.connectServer();
        // ArrayList<Route> routeList = new ArrayList<>();
        // ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();
        // int frequenceTotale = 0;

        // // --------Détermination de la fréquence total et du poid de chaque route
        // for (Trip x : tripNeeds.getTrips()) {
        // Route route = new Route();
        // // route.setFrequence(x.getFd().getFreq());
        // // route.setDeplacement(x);
        // // frequenceTotale += route.getFrequence();
        // // routeList.add(route);
        // }
        // for (Route route : routeList) {
        // route.setWeight(getPercentage(route.getFrequence(), frequenceTotale));
        // }

        // // --------Évaluation de chaque route pour chaque voiture et calcule de la
        // note
        // List<Vehicle> allVehicle = getAllVehicle();
        // allVehicle.sort(Comparator.comparing(Vehicle::getElectricalCapacity));

        // int nbTrajetSansRecharge = 0;

        // for (int i = 0; i < allVehicle.size(); i++) {
        // double score = 0;
        // for (Route route : routeList) {
        // // --------Obtient les infos du déplacement avec la boite noire
        // String data = adveConnection
        // .doRequest(requeteString(route) + allVehicle.get(i).getElectricalCapacity() *
        // 100);
        // stringToRoute(route, data);

        // if (route.getChargingTime() == 0)
        // nbTrajetSansRecharge++;

        // evaluateRoute(route, allVehicle, i);
        // score = score + (route.getWeight() * route.getScore());
        // }

        // // --------Ajoute le score final a la voiture et l'ajoute dans la liste a
        // // retourner
        // Evaluation evaluation = new Evaluation(allVehicle.get(i));
        // evaluation.setScore(score);
        // evaluation.setNbTrajetSansRecharge(nbTrajetSansRecharge);
        // evaluation.setTrajetTotal(routeList.size());
        // vehicleFinalScore.add(evaluation);
        // }
        // adveConnection.closeServer();
        // vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
        // Collections.reverse(vehicleFinalScore);
        // return vehicleFinalScore;
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
}
