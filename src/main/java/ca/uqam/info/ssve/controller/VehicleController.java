package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.Vehicle;
import ca.uqam.info.ssve.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vehicule")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;

	@GetMapping("/{id}")
	public @ResponseBody
	Vehicle getVehicle(@PathVariable Long id) {
		return vehicleService.getVehicle(id);
	}

	@PostMapping("")
	public @ResponseBody
	Vehicle postVehicle(@RequestBody Vehicle vehicle) {
		return vehicleService.saveVehicle(vehicle);
	}
}
