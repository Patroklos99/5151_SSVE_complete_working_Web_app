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
            case "brand" -> vehicle.setBrand(change);
            case "batterycapacity" -> vehicle.setBatteryCapacity(Integer.parseInt(change));
            case "imglink" -> vehicle.setImgLink(change);
            case "modelname" -> vehicle.setModelName(change);
            case "nbdoors" -> vehicle.setNbDoors(Integer.parseInt(change));
            case "price" -> vehicle.setPrice(Integer.parseInt(change));
            case "range" -> vehicle.setRange(Integer.parseInt(change));
            case "reflink" -> vehicle.setRefLink(change);
            case "safetyscore" -> vehicle.setSafetyScore(Integer.parseInt(change));
            case "type" -> vehicle.setType(change);
        }
       vehicleRepository.save(vehicle);
       return vehicle;
    }

    public void evaluateVehicle() {
        //algorithme ici
    }
}
