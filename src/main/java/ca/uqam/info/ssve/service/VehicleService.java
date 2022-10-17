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
        return vehicleRepository.findById(id).get();
    }

    public Vehicle saveVehicle(Vehicle auto) {
        return vehicleRepository.save(auto);
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

    public void modifyVehicule(Long id, Vehicle vehicle) {
        deleteVehicle(id);
        saveVehicle(vehicle);
    }


    public void evaluateVehicle() {
        //algorithme ici
    }
}
