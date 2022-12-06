/**
 * The TripController class uses a Rest Api to retrieve a request
 * with a set of trip data sent by the front end
 *
 */
package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.TripNeeds;
import ca.uqam.info.ssve.service.VehicleService;
import ca.uqam.info.ssve.model.Evaluation;

import java.io.IOException;
import java.util.List;

import com.jcraft.jsch.JSchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tripneeds")
public class TripController {

	@Autowired
	VehicleService vehicleService;

	@PostMapping("")
	public @ResponseBody List<Evaluation> postTrip(@RequestBody TripNeeds tripNeeds) throws IOException, JSchException, InterruptedException {
		return vehicleService.evaluateVehicle(tripNeeds);
	}
}