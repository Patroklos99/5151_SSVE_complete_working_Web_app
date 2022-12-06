package ca.uqam.info.ssve.googleTimeline;

import ca.uqam.info.ssve.model.PointGeo;
import ca.uqam.info.ssve.model.GeoPoint;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.*;
//import java.ca.uqam.info.ssve.model.PointGeo;

/**
 * This class stores relevant data from a trip(Deplacement) received by
 * a Google org.Timeline file submitted in the front end.
 *
 *  To be used with org.googleTimeline.TimelineParser.java
 */
public class TimelineData {
    private final PointGeo start;
    private final PointGeo end;
    private long placeID;
    private String tripName;
    private int frequency;
    private List<GeoPoint> stops;

    /**
     * Constructer
     * @param _placeID identification of a trip
     * @param _start location of the start of the trip
     * @param _end location of the destination of the trip
     */
    public TimelineData(long _placeID, PointGeo _start, PointGeo _end) {
        this.placeID = _placeID;
        this.start = _start;
        this.end = _end;
        stops = new ArrayList<GeoPoint>();
    }

    /**
     * Prints trip data to the screen
     */
    public void printTripData(){
        System.out.println("\nID: " + placeID);
        System.out.println("Start: " + "lat: " + start.getLat() + " lgt: " + start.getLgt());
        System.out.println("End: " + "lat: " + end.getLat() + " lgt: " + end.getLgt());
        System.out.println("Frequency: " + frequency + "\n");
    }

    public long getID(){
        return placeID;
    }

    public void setID(long ID){
        this.placeID = ID;
        //finalizeTripData(ID);
    }

    public void finalizeTripData(long ID) {
        String IDString = Long.toString(ID);
        String name = "Timeline_Trip_";
        this.tripName = name + IDString;
        stops.add(new GeoPoint(this.tripName + "_Start", this.start.getLat(), this.start.getLgt()));
        stops.add(new GeoPoint(this.tripName + "_End", this.end.getLat(), this.end.getLgt()));
    }

    public List<GeoPoint> getStops(){
        return this.stops;
    }

    public String getTripName(){
        return this.tripName;
    }

    public PointGeo getStart(){
        return start;
    }

    public PointGeo getEnd(){
        return end;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }
}
