package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000/"})
@RequestMapping("api/vehicule")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@GetMapping("/{id}")
	public @ResponseBody
	Vehicle getVehicle(@PathVariable Long id) {
		return vehicleService.getVehicle(id);
	}

	@PostMapping("/postVehicle")
	public @ResponseBody
	Vehicle postVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}

	@GetMapping("/getAll")
	public @ResponseBody
	List<Vehicle> getAll() {
		return vehicleService.getAllVehicle();
	}

	@DeleteMapping("/deleteVehicle")
	public @ResponseBody
	void deleteVehicle (Long id) {
		vehicleService.deleteVehicle(id);
	}

	@DeleteMapping("/deleteAllVehicle")
	public @ResponseBody
	void deleteAllVehicle () {
		vehicleService.deleteAllVehicle();
	}

	@PostMapping("/modifyVehicle")
	public @ResponseBody
	void modifyVehicle(Long id, @RequestBody Vehicle vehicle) {
		vehicleService.modifyVehicule(id, vehicle);
	}


	//todo
	@GetMapping("evaluateVehicle")
	public @ResponseBody
	void evaluateVehicle() {
		vehicleService.evaluateVehicle();
	}

}
