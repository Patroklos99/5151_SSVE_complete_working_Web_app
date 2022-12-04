package java.ca.uqam.info.ssve.controller;

import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.ca.uqam.info.ssve.model.Deplacement;
import java.ca.uqam.info.ssve.model.Evaluation;
import java.ca.uqam.info.ssve.model.Vehicle;
import java.ca.uqam.info.ssve.service.VehicleService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = { "http://localhost:3000/" })
@RequestMapping("api/vehicle")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    /**
     * Retourne la voiture avec l'ID demandé ou toutes les voitures
     *
     * @param id: ID de la voiture
     * @return Vehicle: voiture ayant l'ID spécifié ou toutes les voitures
     */
    @GetMapping("")
    public @ResponseBody List<Vehicle> getVehicle(Optional<Long> id) {
        if (id.isPresent()) {
            List<Vehicle> list = new ArrayList<>();
            list.add(vehicleService.getVehicle(id.get()));
            return list;
        } else {
            return vehicleService.getAllVehicle();
        }
    }

    /**
     * Crée et ajoute une voiture dans la base de données
     * 
     * @param vehicle: voiture à ajouter
     * @return Vehicle: retourne la voiture ajouté
     */
    @PostMapping("")
    public @ResponseBody Vehicle addVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    /**
     * Modifie une voiture dans la base de donnée
     *
     * @param vehicle: nouvelle voiture modifié
     * @return Vehicle: retourne un body avec la voiture modifié
     */
    @PutMapping("")
    public @ResponseBody Vehicle modifyVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.modifyVehicle(vehicle);
    }

    @GetMapping("evaluate")
    public @ResponseBody List<Evaluation> evaluateVehicle(@RequestBody List<Deplacement> listCoord)
            throws IOException, JSchException, InterruptedException {
        return vehicleService.evaluateVehicle(listCoord);
    }

    @GetMapping("evaluateTest")
    public @ResponseBody List<Evaluation> evaluateVehicleTest()
            throws IOException, JSchException, InterruptedException {
        return vehicleService.evaluateVehicleTest();
    }

    @GetMapping("tempDummy")
    public @ResponseBody List<Evaluation> tempDummy() throws IOException {
        return vehicleService.dummyScore();
    }

}
