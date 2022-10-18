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


	@GetMapping("findVehicleById")
	public @ResponseBody
	Vehicle getVehicle(Long id) {
		return vehicleService.getVehicle(id);
	}

	@PostMapping("addVehicle")
	public @ResponseBody
	Vehicle addVehicle(String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, int safetyScore, String refLink, String imgLink) {

		return vehicleService.addVehicle(brand, modelName, nbDoors, type, price, range, batteryCapacity, safetyScore, refLink, imgLink);
	}

	@GetMapping("getAllVehicle")
	public @ResponseBody
	List<Vehicle> getAll() {
		return vehicleService.getAllVehicle();
	}


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
