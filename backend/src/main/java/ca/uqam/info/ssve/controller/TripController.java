/**
 * The TripController class uses a Rest Api to retrieve a request
 * with a set of trip data sent by the front end
 *
 */
package ca.uqam.info.ssve.controller;

import ca.uqam.info.ssve.model.TripNeeds;
import ca.uqam.info.ssve.googleTimeline.TimelineParser;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.List;
import java.util.Map;



@RestController
@RequestMapping("api/tripneeds")
@CrossOrigin
public class TripController {
    private int autonomy;
    private int chargeTime;


     @PostMapping("")
     public @ResponseBody
     TripNeeds postTrip(@RequestBody TripNeeds tripNeeds) {
     	System.out.println(tripNeeds.toString());
     	return tripNeeds;
     }




    @PostMapping("/timelineNeeds")
    public @ResponseBody
        void postTimelineNeeds(@RequestBody HttpEntity<JSONObject> needsInput) throws Exception {
         TimelineParser timelineParser = new TimelineParser();
        JSONObject jsonObject = new JSONObject(needsInput.getBody());
        String autonomyInput = jsonObject.get("autonomy").toString();
        int autonomy = Integer.valueOf(autonomyInput);
        this.autonomy = autonomy;
        String chargeTimeInput = jsonObject.get("chargeTime").toString();
        int chargeTime = Integer.valueOf(chargeTimeInput);
        this.chargeTime = chargeTime;
    }


    @PostMapping("/timelineTrips")
    public @ResponseBody
    TripNeeds postTimelineTrips(@RequestBody HttpEntity<String> s) throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject result = (JSONObject) parser.parse(s.getBody());
        TimelineParser timelineParser = new TimelineParser(result);
        TripNeeds timelineTripNeeds = new TripNeeds(this.chargeTime, this.autonomy, timelineParser.getTimelineData());
        System.out.println(timelineTripNeeds.toString());
        return timelineTripNeeds;
    }
}
