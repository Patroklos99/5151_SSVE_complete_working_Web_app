package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

public class TimelineParser {

    private static final ArrayList<TimelineData> tripList = new ArrayList<>();
    private static final ArrayList<TimelineData> uniqueTripList = new ArrayList<>();


    /**
     * Runs the program, parsing the input file, extracting and storing relevant data
     * @param args args[1] = Google org.Timeline input file (.JSON)
     */
    public static void main(String[] args){
        JSONParser parser = new JSONParser();
        Object timelineInput;
        try{
            try {
                timelineInput = parser.parse(new FileReader(args[1]));
            } catch (IndexOutOfBoundsException e) {
                timelineInput = parser.parse(new FileReader("src/test/java/timelineExample.json"));
            }
            JSONObject jsonOBject = (JSONObject) timelineInput;
            JSONArray timeLineList =  (JSONArray) jsonOBject.get("timelineObjects");
            Iterator<JSONObject> iterator = timeLineList.iterator();
            do {
                collectTripData(iterator);
            } while (iterator.hasNext());
            calculateFrequency(tripList);
            printData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printData(){
        for (int i = 0; i < uniqueTripList.size(); i++) {
            uniqueTripList.get(i).printTripData();
        }
    }

    /**
     * This function extracts the start coordinates of a trip from the JSON segment
     * @param activitySegment part of JSON file that describes the type of trip (walk/vehicule/etc)
     * @return the coordinates of the start location of a trip in a org.PointGeo object.
     */
    private static PointGeo extractStart(JSONObject activitySegment) {
        JSONObject coordinates = (JSONObject) activitySegment.get("startLocation");
        double startLocationLatitude = Double.parseDouble(coordinates.get("latitudeE7").toString());
        double startLocationLongitude = Double.parseDouble(coordinates.get("longitudeE7").toString());
        PointGeo start = new PointGeo(startLocationLatitude,startLocationLongitude);
        return start;
    }


    /**
     * This function extracts the end coordinates of a trip from the JSON segment
     * @param activitySegment: part of JSON file that describes the type of trip (walk/vehicule/etc)
     * @return the coordinates of the end location of a trip in a org.PointGeo object.
     */
    private static PointGeo extractEnd(JSONObject activitySegment) {
        JSONObject coordinates = (JSONObject) activitySegment.get("endLocation");
        double startLocationLatitude = Double.parseDouble(coordinates.get("latitudeE7").toString());
        double startLocationLongitude = Double.parseDouble(coordinates.get("longitudeE7").toString());
        PointGeo end = new PointGeo(startLocationLatitude,startLocationLongitude);
        return end;
    }

    /**
     * This function extracts the placeID of a trip from the JSON segment
     * @param placeVisit: part of JSON file that describes the location of travel of a trip
     * @return String of the identification (ID) of the visited location
     */
    private static String extractId(JSONObject placeVisit) {

        JSONObject location = (JSONObject) placeVisit.get("location");
        String Id =  location.get("placeId").toString();
        return Id;
    }

    /**
     * This function extracts the type of activity from the JSON segment
     * @param activitySegment: part of JSON file that describes the type of trip (walk/vehicule/etc)
     * @return String of the type of trip that was taken
     */
    private static String extractActivityType(JSONObject activitySegment) {
        String activityType = activitySegment.get("activityType").toString();
        return activityType;
    }

    /**
     * This function collects all the relevant data from a particular trip and
     * adds them to the list of trips
     * @param iterator iterates through the different JSON segments
     */
    public static void collectTripData(Iterator<JSONObject> iterator) {
        JSONObject activitySegment;
        String ID;
        PointGeo start;
        PointGeo end;
        try {
            activitySegment = (JSONObject) iterator.next().get("activitySegment");
            if (extractActivityType(activitySegment).equals("IN_PASSENGER_VEHICLE")) {
                start = extractStart(activitySegment);
                end = extractEnd(activitySegment);
                JSONObject placeVisit = (JSONObject) iterator.next().get("placeVisit");
                ID = extractId(placeVisit);
                tripList.add(new TimelineData(ID, start, end));
            } else {
                JSONObject placeVisit = (JSONObject) iterator.next();
            }
        } catch (NullPointerException npe){
            //System.out.println("FFFFF");
            // iterator.next();
        }
    }

    /**
     * This function calculates the frequency of each trip and stores them in a
     * new list containing only unique trips and the amount of trips to that location
     * @param timelineData the JSON of the whole file that encapsulates all the information
     */
    private static void calculateFrequency(ArrayList<TimelineData> timelineData){
        for (int i = 0; i < timelineData.size(); i++) {
            String ID = timelineData.get(i).getID();
            int frequency = 0;
            for (int j = 0; j < timelineData.size(); j++) {
                if (timelineData.get(j).getID().equals(ID)){
                    frequency++;
                }
            }
            timelineData.get(i).setFrequency(frequency);
            boolean contains = false;
            for (int k = 0; k < uniqueTripList.size(); k++) {
                if (uniqueTripList.get(k).getID().equals(ID)){
                    contains = true;
                }
            }
            if (!contains){
                uniqueTripList.add(timelineData.get(i));
            }
        }

    }
}

