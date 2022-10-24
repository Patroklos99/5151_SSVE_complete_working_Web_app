/**
 * The TripController class uses a Rest Api to retrieve a request
 * with a set of trip data sent by the front end
 *
 */
package java.ca.uqam.info.ssve.controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class TripController {
    private List<TripHandler> userTrips;

    @RequestMapping(
            value = "/api/trip",
            method = RequestMethod.POST)
    public void setTripData(@RequestBody Map<String, Object> tripData)
        throws Exception{
        userTrips.add(new TripHandler(tripData));
        System.out.println(tripData);
    }
}