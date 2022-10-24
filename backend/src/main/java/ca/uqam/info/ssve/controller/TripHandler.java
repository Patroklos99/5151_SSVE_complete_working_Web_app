/**
 * The TripHandler object seperates and stores a set of
 * trip data to their respective types
 *
 */
package java.ca.uqam.info.ssve.controller;
import java.util.Map;

public class TripHandler {
    private int id;
    private String name;
    private double start;
    private double end;
    private String frequence;
    
    public TripHandler(int _id, String _name, double _start, double _end, String _frequence) {
            this.id = _id;
            this.name = _name;
            this.start = _start;
            this.end = _end;
            this.frequence = _frequence;
        }

    public TripHandler(Map<String, Object> tripData) {
        this.id = (Integer)tripData.get("id");
        this.name = tripData.get("name").toString();
        this.start = ((Number)tripData.get("start")).doubleValue();
        this.end = ((Number)tripData.get("end")).doubleValue();
        this.frequence = tripData.get("frequency").toString();

    }
        
        public int getID() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public double getStart() {
            return this.start;
        }

        public double getEnd() {
            return this.end;
        }

        public String getFrequence() {
            return this.frequence;
        }
}
