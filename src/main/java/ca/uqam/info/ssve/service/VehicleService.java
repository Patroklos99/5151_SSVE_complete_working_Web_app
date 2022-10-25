package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicle(Long id) {
        if (vehicleRepository.findById(id).isPresent()){
            return vehicleRepository.findById(id).get();
        }
        return new Vehicle();
    }

    public Vehicle addVehicle(String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, int safetyScore, String refLink, String imgLink) {
        Vehicle vehicle = new Vehicle(brand, modelName, nbDoors, type, price, range, batteryCapacity, safetyScore, refLink, imgLink);
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    /* Ne pas ajouté pour le moment
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public void deleteAllVehicle() {
        vehicleRepository.deleteAll();
    }
    */

    public Vehicle modifyVehicule(Long id, String column, String change) {
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
    }

    // ----------------------------------------------------   ----------------------------------------
    private boolean validateBrand(String brand) {
        return brand.matches("[a-zA-Z]+");
    }

    private boolean validateModelName(String modelName) {
        return modelName.matches("[A-Za-z\s0-9]]");
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


    public void evaluateVehicle() {
        //algorithme ici
    }
}
