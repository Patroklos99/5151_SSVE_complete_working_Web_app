package ca.uqam.info.ssve.model;
import java.util.List;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TripNeedsDummy implements Serializable{

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("autonomy")
    private int autonomy;
    @JsonProperty("charge_time")
    private int charge_time;
    @OneToMany(mappedBy="tripneedsdummy",cascade = CascadeType.ALL)
    @OrderColumn
    @JsonProperty("trips")
    private TripDummy[] trips;

    

    public TripNeedsDummy() {
    }

    public TripNeedsDummy(int autonomy, int charge_time, TripDummy[] trips) {
        this.autonomy = autonomy;
        this.charge_time = charge_time;
        this.trips = trips;
    }

    public Long getId() {
        return id;
    }

    public int getAutonomy() {
        return autonomy;
    }

    public int getCharge_time() {
        return charge_time;
    }

    public TripDummy[] getTrips() {
        return trips;
    }

    public String toString(){

        String tripsString = "";

        for (TripDummy t: trips) {
            tripsString += t.toString() + '\n';
        }

        return "id: " + id +
            "\nautonomy: " + autonomy +
            "\ncharge_time: " + charge_time +
            "\ntrips: {" + tripsString + "\n}" ;

     }

}
