package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping("api/vehicle")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	/**
	 * Retourne la voiture avec l'ID demandé
	 * @param id: ID de la voiture
	 * @return Vehicle: voiture ayant l'ID spécifié
	 */
	@GetMapping("findVehicleById")
	public @ResponseBody
	Vehicle getVehicle(Long id) {
		return vehicleService.getVehicle(id);
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
	@PostMapping("addVehicle")
	public @ResponseBody
	Vehicle addVehicle(String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, int safetyScore, String refLink, String imgLink) {
		return vehicleService.addVehicle(brand, modelName, nbDoors, type, price, range, batteryCapacity, safetyScore, refLink, imgLink);
	}

	/**
	 * Retourne une liste de tous les voitures enregistré dans la base de données
	 * @return List<Vehicle>: Liste contenant tous les voitures de la base de données
	 */
	@GetMapping("getAllVehicle")
	public @ResponseBody
	List<Vehicle> getAll() {
		return vehicleService.getAllVehicle();
	}


	/* Ne pas ajouté pour le moment
	@DeleteMapping("deleteVehicle")
	public @ResponseBody
	void deleteVehicle (Long id) {
		vehicleService.deleteVehicle(id);
	}

	@DeleteMapping("deleteAllVehicle")
	public @ResponseBody
	void deleteAllVehicle () {
		vehicleService.deleteAllVehicle();
	}
	*/

	/**
	 * Modifie une voiture dans la base de donnée
	 * @param id: ID de la voiture a modifié
	 * @param column: Variable de la voiture a modifié
	 * @param change: La nouvelle variable a ajouté a la voiture
	 * @return Vehicle: retourne un body avec la voiture modifié
	 */
	@PutMapping("modifyVehicle")
	public @ResponseBody
	Vehicle modifyVehicle(Long id, String column, String change) {
		return vehicleService.modifyVehicule(id, column, change);
	}

	//todo
	@GetMapping("evaluateVehicle")
	public @ResponseBody
	void evaluateVehicle() {
		vehicleService.evaluateVehicle();
	}
}
