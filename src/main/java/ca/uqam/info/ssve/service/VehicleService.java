package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.Deplacement;
import ca.uqam.info.ssve.model.Evaluation;
import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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


    public List<Evaluation> evaluateVehicle() {
        //algorithme ici
        ArrayList<Integer> coordinateList = new ArrayList<>(); ///Dummy à effacer une fois ListCoordinate definie.
        ArrayList<Deplacement> tripsList = new ArrayList<>();
        ArrayList<Vehicle> vehicleFinalScore = new ArrayList<>();
        int frequenceTotale = 0;
        for (int x : coordinateList) {
            //algo utilisation boite noite (serveur)
            Deplacement dep = new Deplacement(); //creation avec les donnes retournees de la boite noir
            tripsList.add(dep);
            frequenceTotale += dep.getFrequence();
        }
        double poidsDeplacement;
        for (Deplacement trip : tripsList) {
            poidsDeplacement = trip.getFrequence() / frequenceTotale;
        }
        for (Vehicle vehicle : getAllVehicle()) {
            for (Deplacement trip : tripsList)
                donnerNoteDeplacementSelonAutonomieVoiture(trip, vehicle);
            //vehicle.setScore = sum(notedeplacement(poidsDeplacement));
            vehicleFinalScore.add(vehicle);
        }
        Collections.sort(vehicleFinalScore); //a modifier









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

    private void donnerNoteDeplacementSelonAutonomieVoiture(Deplacement trip, Vehicle vehicle) {
        //to do
    }
}
