package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.Deplacement;
import ca.uqam.info.ssve.model.Route;
import ca.uqam.info.ssve.model.Evaluation;
import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
import ca.uqam.info.ssve.server.ADVEConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).get();
    }

    public Vehicle addVehicle(String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, int safetyScore, String refLink, String imgLink) {
        Vehicle vehicle = new Vehicle();
        if (
                validateBrand(brand)
                        && validateModelName(modelName)
                        && validatePrice(price)
                        && validateNbDoors(nbDoors)
                        && validateType(type)
                        && validateRange(range)
                        && validateSafetyScore(safetyScore)
                        && validateRefLink(refLink)
                        && validateImgLink(imgLink)
        ) {
            vehicle.setBrand(brand);
            vehicle.setModelName(modelName);
            vehicle.setNbDoors(nbDoors);
            vehicle.setType(type);
            vehicle.setPrice(price);
            vehicle.setRange(range);
            vehicle.setBatteryCapacity(batteryCapacity);
            vehicle.setSafetyScore(safetyScore);
            vehicle.setRefLink(refLink);
            vehicle.setImgLink(imgLink);
            vehicleRepository.save(vehicle);
            return vehicle;
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


    /*
    public Vehicle modifyVehicle(Long id, String column, String change) {
        Vehicle vehicle;
        if (vehicleRepository.findById(id).isPresent()) {
            vehicle = vehicleRepository.findById(id).get();
        } else {
            return new Vehicle();
        }
        switch (column.toLowerCase()) {
            case "brand" -> {
                if (validateBrand(change))  vehicle.setBrand(change);
            }
            case "modelname" -> {
                if (validateModelName(change))  vehicle.setModelName(change);
            }
            case "nbdoors" -> {
                if (validateNbDoors(Integer.parseInt(change)))  vehicle.setNbDoors(Integer.parseInt(change));
            }
            case "type" -> {
                if (validateType(change))   vehicle.setType(change);
            }
            case "price" -> {
                if (validatePrice(Integer.parseInt(change)))   vehicle.setPrice(Integer.parseInt(change));
            }
            case "range" -> {
                if (validateRange(Integer.parseInt(change)))   vehicle.setRange(Integer.parseInt(change));
            }
            case "batterycapacity" -> {
                if (validateBatteryCapacity(Integer.parseInt(change)))   vehicle.setBatteryCapacity(Integer.parseInt(change));
            }
            case "safetyscore" -> {
                if (validateSafetyScore(Integer.parseInt(change)))   vehicle.setSafetyScore(Integer.parseInt(change));
            }
            case "reflink" -> {
                if (validateRefLink(change))   vehicle.setRefLink(change);
            }
            case "imglink" -> {
                if (validateImgLink(change))   vehicle.setImgLink(change);
            }
        }
       vehicleRepository.save(vehicle);
       return vehicle;
    }*/

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


    public List<Evaluation> evaluateVehicle(List<Deplacement> coordinateList) throws IOException {
        /*
        //algorithme ici
        ArrayList<Route> routeList = new ArrayList<>();
        ArrayList<Evaluation> vehicleFinalScore = new ArrayList<>();
        int frequenceTotale = 0;
        ADVEConnection adveConnection = new ADVEConnection("https://adve.info.uqam.ca");
        for (Deplacement x : coordinateList) {
            //algo utilisation boite noite (serveur)
            String info = adveConnection.call(x); //Résultat boite noir voir si String ou JSON
            Route route = new Route();
            route.setFrequence(x.getFd().getNb_days());
            /*
            route.setDistance();
            route.setTripTime();          A ajusté selon le type de retour de la boite noire
            route.setWaitingTime();
            route.setChargingTime();
            *//*
            routeList.add(route);
            frequenceTotale += route.getFrequence();
        }
        for (Route route : routeList) {
            route.setWeight((route.getFrequence() / frequenceTotale) + (route.getFrequence() % frequenceTotale));
        }

        List <Vehicle> allVehicle = getAllVehicle();
        allVehicle.sort(Comparator.comparing(Vehicle::getRange));
        for (int i = 0; i < allVehicle.size(); i++) {
            double score = 0;
            for (Route route : routeList) {
                evaluateRoute(route, allVehicle, i);
            }
            for (Route route : routeList) {
                score = score+(route.getWeight()* route.getScore());
            }
            Evaluation evaluation = new Evaluation(allVehicle.get(i));
            evaluation.setScore(score);
            vehicleFinalScore.add(evaluation);
        }
        vehicleFinalScore.sort(Comparator.comparing(Evaluation::getScore));
        return vehicleFinalScore;
        */








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

    private void evaluateRoute(Route route, List<Vehicle> vehicle, int i) {
        double poid1 = 0.75;
        double poid2 = 0.25;
        double note1 = (vehicle.get(i).getRange() / route.getDistance()) + (vehicle.get(i).getRange() % route.getDistance()) * 100;
        if (note1 > 100) {
            note1 = 100;
        }
        int rangeMax = vehicle.get(0).getRange();
        double note2 = ((vehicle.get(i).getRange()- route.getDistance()) / rangeMax) + (vehicle.get(i).getRange() % rangeMax) * 100;

        route.setScore(poid1*note1 + poid2*note2);
    }


}
