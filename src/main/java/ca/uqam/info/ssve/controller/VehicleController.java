package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.Evaluation;
import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping("vehicle")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	/**
	 * Retourne la voiture avec l'ID demandé ou toutes les voitures
	 * @param id: ID de la voiture
	 * @return Vehicle: voiture ayant l'ID spécifié ou toutes les voitures
	 */
	@GetMapping("")
	public @ResponseBody
	List<Vehicle> getVehicle(Optional<Long> id) {
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
	 * @param brand: Marque de la voiture
	 * @param modelName: Modèle de la voiture
	 * @param nbDoors: nombre de portes
	 * @param type: type de voiture
	 * @param price: Prix de la voiture
	 * @param range: Autonomie de la voiture
	 * @param batteryCapacity: Capacité de la batteri de la voiture
	 * @param safetyScore: Note de sécurité de la voiture
	 * @param refLink: Lien de référence
	 * @param imgLink: Lien vers un image de la voiture
	 * @return Vehicle: retourne la voiture ajouté
	 */
	@PostMapping("")
	public @ResponseBody
	Vehicle addVehicle(String brand,
					   String modelName,
					   int nbDoors,
					   String type,
					   int price,
					   int range,
					   int batteryCapacity,
					   int safetyScore,
					   String refLink,
					   String imgLink) {
		return vehicleService.addVehicle(brand, modelName, nbDoors, type, price, range, batteryCapacity, safetyScore, refLink, imgLink);
	}




	/**
	 * Modifie une voiture dans la base de donnée
	 * @param vehicle: nouvelle voiture modifié
	 * @return Vehicle: retourne un body avec la voiture modifié
	 */
	@PutMapping("")
	public @ResponseBody
	Vehicle modifyVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.modifyVehicle(vehicle);
	}

	//todo
	@GetMapping("evaluateVehicle")
	public @ResponseBody
	List<Evaluation> evaluateVehicle() {
		return vehicleService.evaluateVehicle();
	}
}
