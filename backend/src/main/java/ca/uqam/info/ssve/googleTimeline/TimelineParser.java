package ca.uqam.info.ssve.googleTimeline;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ca.uqam.info.ssve.model.PointGeo;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;


public class TimelineParser {

    private static final ArrayList<TimelineData> tripList = new ArrayList<>();
    private static final ArrayList<TimelineData> uniqueTripList = new ArrayList<>();

    private static int idCounter = 0;

    /**
     * Default constructor
     */
    public TimelineParser() {
    }

    /**
     * Runs the program, parsing the input file, extracting and storing relevant data
     *
     * @param args args[1] = Google org.Timeline input file (.JSON)
     * @return
     */
    public TimelineParser(JSONObject jsonObject) {
        runParser(jsonObject);
    }

    /**
     * This function parses the JSON object in input and extracts the data
     *
     * @param jsonObject jsonObject from user submitted json file
     * @return list of trips
     */
    private ArrayList<TimelineData> runParser(JSONObject jsonObject) {
        JSONArray timeLineList = (JSONArray) jsonObject.get("timelineObjects");
        Iterator<JSONObject> iterator = timeLineList.iterator();
        do {
            collectTripData(iterator);
        } while (iterator.hasNext());
        calculateFrequency(tripList);
        //printData();
        return tripList;
    }

    /**
     * This function prints all trip data
     */
    public static void printData() {
        for (int i = 0; i < tripList.size(); i++) {
            tripList.get(i).printTripData();
        }
        System.out.println("Number of trips: " + tripList.size());
    }

    /**
     * This function extracts the start coordinates of a trip from the JSON segment
     *
     * @param activitySegment part of JSON file that describes the type of trip (walk/vehicule/etc)
     * @return the coordinates of the start location of a trip in a org.PointGeo object.
     */
    private static PointGeo extractStart(JSONObject activitySegment) {
        JSONObject coordinates = (JSONObject) activitySegment.get("startLocation");
        double startLocationLatitude = Double.parseDouble(coordinates.get("latitudeE7").toString());
        double startLocationLongitude = Double.parseDouble(coordinates.get("longitudeE7").toString());
        PointGeo start = new PointGeo(startLocationLatitude, startLocationLongitude);
        return start;
    }

    /**
     * This function extracts the end coordinates of a trip from the JSON segment
     *
     * @param activitySegment: part of JSON file that describes the type of trip (walk/vehicule/etc)
     * @return the coordinates of the end location of a trip in a org.PointGeo object.
     */
    private static PointGeo extractEnd(JSONObject activitySegment) {
        JSONObject coordinates = (JSONObject) activitySegment.get("endLocation");
        double startLocationLatitude = Double.parseDouble(coordinates.get("latitudeE7").toString());
        double startLocationLongitude = Double.parseDouble(coordinates.get("longitudeE7").toString());
        PointGeo end = new PointGeo(startLocationLatitude, startLocationLongitude);
        return end;
    }

    /**
     * This function extracts the placeID of a trip from the JSON segment
     *
     * @param placeVisit: part of JSON file that describes the location of travel of a trip
     * @return String of the identification (ID) of the visited location
     */
    private static String extractId(JSONObject placeVisit) {

        JSONObject location = (JSONObject) placeVisit.get("location");
        String Id = location.get("placeId").toString();
        return Id;
    }

    private static long setTripID() {
        long result = idCounter++;
        return result;
    }

    /**
     * This function extracts the type of activity from the JSON segment
     *
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
     *
     * @param iterator iterates through the different JSON segments
     */
    public static void collectTripData(Iterator<JSONObject> iterator) {
        JSONObject activitySegment;
        long ID;
        PointGeo start;
        PointGeo end;
        try {
            activitySegment = (JSONObject) iterator.next().get("activitySegment");
            if (extractActivityType(activitySegment).equals("IN_PASSENGER_VEHICLE") || (extractActivityType(activitySegment).equals("IN_VEHICLE"))) {
                start = extractStart(activitySegment);
                end = extractEnd(activitySegment);
                JSONObject placeVisit = (JSONObject) iterator.next().get("placeVisit");
                ID = setTripID();
                tripList.add(new TimelineData(ID, start, end));
            } else {
                JSONObject placeVisit = (JSONObject) iterator.next();
            }
        } catch (NullPointerException npe) {
            //lets the program continue running
        }
    }

    /**
     * This function calculates the frequency of each trip,
     * deletes all duplicate and sets the frequency of trips of that location
     *
     * @param timelineData the JSON of the whole file that encapsulates all the information
     */
    private static void calculateFrequency(ArrayList<TimelineData> timelineData) {
        TimelineParser temp = new TimelineParser();
        long newIdCounter = 0;
        for (int i = 0; i < timelineData.size(); i++) {
            long ID = timelineData.get(i).getID();
            int frequency = 0;
            for (int j = 0; j < timelineData.size(); j++) {
                if (temp.isSameTrip(timelineData.get(i), timelineData.get(j))) {
                    timelineData.get(j).setID(ID);
                    frequency++;
                    if (i != j) {
                        timelineData.remove(j);
                    }
                }
            }
            timelineData.get(i).setFrequency(frequency * 12);
            timelineData.get(i).setID(newIdCounter++);
            if (timelineData.get(i).getFrequency() == 0) {
                timelineData.get(i).setFrequency(12);
            }
        }
    }

    /**
     * This function calculates the distance between
     * the two start coordinates
     *
     * @param start1 (PointGeo) first start coordinate
     * @param start2 (PointGeo) second start coordinate
     * @return distance as double
     */
    private double calculateDistanceStart(PointGeo start1, PointGeo start2) {
        double theta = start1.getLgt() - start2.getLgt();
        double dist = Math.sin(Math.toRadians(start1.getLat())) * Math.sin(Math.toRadians(start2.getLat())) + Math.cos(Math.toRadians(start1.getLat())) * Math.cos(Math.toRadians(start2.getLat())) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }

    /**
     * This function calculates the distance between
     * the two start coordinates
     *
     * @param start1 (PointGeo) first start coordinate
     * @param start2 (PointGeo) second start coordinate
     * @return distance as double
     */
    private double calculateDistanceEnd(PointGeo end1, PointGeo end2) {
        double theta = end1.getLgt() - end2.getLgt();
        double dist = Math.sin(Math.toRadians(end1.getLat())) * Math.sin(Math.toRadians(end2.getLat())) + Math.cos(Math.toRadians(end1.getLat())) * Math.cos(Math.toRadians(end2.getLat())) * Math.cos(Math.toRadians(theta));
        dist = Math.acos(dist);
        dist = Math.toDegrees(dist);
        dist = dist * 60 * 1.1515;
        return dist;
    }

    /**
     * This function verifies if two trips have the same start and destination
     * to determine the frequency of each trip
     *
     * @param first  trip
     * @param second trip
     * @return true if trip is same
     */
    private Boolean isSameTrip(TimelineData first, TimelineData second) {
        Boolean isSameTrip = false;
        if ((calculateDistanceStart(first.getStart(), second.getStart()) < 3000) && (calculateDistanceEnd(first.getEnd(), second.getEnd()) < 3000)) {
            isSameTrip = true;
        }
        return isSameTrip;
    }

    /**
     * Function used to retrieve timelineData and convert to TripNeeds
     *
     * @return timelineData
     */
    public ArrayList<TimelineData> getTimelineData() {
        return tripList;
    }
}