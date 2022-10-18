package ca.uqam.info.ssve.service;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    public Vehicle getVehicle(Long id) {
        return vehicleRepository.findById(id).get();
    }

    public Vehicle addVehicle(String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, int safetyScore, String refLink, String imgLink) {
        Vehicle vehicle = new Vehicle(brand, modelName, nbDoors, type, price, range, batteryCapacity, safetyScore, refLink, imgLink);
        return vehicleRepository.save(vehicle);
    }

    public List<Vehicle> getAllVehicle() {
        return vehicleRepository.findAll();
    }

    public void deleteVehicle(Long id) {
        vehicleRepository.deleteById(id);
    }

    public void deleteAllVehicle() {
        vehicleRepository.deleteAll();
    }

    public Vehicle modifyVehicule(Long id, String column, String change) {
       Vehicle vehicle = vehicleRepository.findById(id).get();
       if (column.toLowerCase().equals("brand")){
           vehicle.setBrand(change);
       } else if (column.toLowerCase().equals("batterycapacity")) {
           vehicle.setBatteryCapacity(Integer.parseInt(change));
       } else if (column.toLowerCase().equals("imglink")) {
           vehicle.setImgLink(change);
       } else if (column.toLowerCase().equals("modelname")) {
           vehicle.setModelName(change);
       } else if (column.toLowerCase().equals("nbdoors")) {
           vehicle.setNbDoors(Integer.parseInt(change));
       } else if (column.toLowerCase().equals("price")) {
           vehicle.setPrice(Integer.parseInt(change));
       } else if (column.toLowerCase().equals("range")) {
           vehicle.setRange(Integer.parseInt(change));
       } else if (column.toLowerCase().equals("reflink")) {
           vehicle.setRefLink(change);
       } else if (column.toLowerCase().equals("safetyscore")) {
           vehicle.setSafetyScore(Integer.parseInt(change));
       } else if (column.toLowerCase().equals("type")) {
           vehicle.setType(change);
       }
       vehicleRepository.save(vehicle);
       return vehicle;
    }

    public void evaluateVehicle() {
        //algorithme ici
    }
}
