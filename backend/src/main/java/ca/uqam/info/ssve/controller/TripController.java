/**
 * The TripController class uses a Rest Api to retrieve a request
 * with a set of trip data sent by the front end
 *
 */
package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.Trip;
import ca.uqam.info.ssve.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/trip")
public class TripController {

	@Autowired
	TripService tripService;

	@GetMapping("/{id}")
	public @ResponseBody
	Trip getTrip(@PathVariable Long id) {
		return tripService.getTrip(id);
	}

	@PostMapping("")
	public @ResponseBody
	Trip postTrip(@RequestBody Trip trip) {
		return tripService.saveTrip(trip);
	}
}