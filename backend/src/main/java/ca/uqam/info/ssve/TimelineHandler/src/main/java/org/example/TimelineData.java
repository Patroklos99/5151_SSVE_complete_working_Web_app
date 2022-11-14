package org.example;

/**
 * This class stores relevant data from a trip(Deplacement) received by
 * a Google org.Timeline file submitted in the front end.
 *
 *  To be used with org.TimelineParser.java
 */
public class TimelineData {
    private final PointGeo start;
    private final PointGeo end;
    private final String placeID;

    private int frequency;

    /**
     * Constructer
     * @param _placeID identification of a trip
     * @param _start location of the start of the trip
     * @param _end location of the destination of the trip
     */
    public TimelineData(String _placeID, PointGeo _start, PointGeo _end) {
        this.placeID = _placeID;
        this.start = _start;
        this.end = _end;
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

    public String getID(){
        return placeID;
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
