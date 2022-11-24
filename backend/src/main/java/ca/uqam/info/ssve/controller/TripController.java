/**
 * The TripController class uses a Rest Api to retrieve a request
 * with a set of trip data sent by the front end
 *
 */
package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.TripNeeds;
import ca.uqam.info.ssve.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/tripneeds")
public class TripController {

	@Autowired
	TripService tripService;

	@GetMapping("/{id}")
	public @ResponseBody
	TripNeeds getTrip(@PathVariable Long id) {
		return tripService.getTrip(id);
	}

	@PostMapping("")
	public @ResponseBody
	TripNeeds postTrip(@RequestBody TripNeeds tripNeeds) {
		TripNeeds bd = tripService.saveTripNeeds(tripNeeds);
		System.out.println(bd.toString());
		return bd;
	}
}