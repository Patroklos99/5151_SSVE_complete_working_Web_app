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
    @JsonProperty("chargeTime")
    private int chargeTime;
    @OneToMany(mappedBy="tripneedsdummy",cascade = CascadeType.ALL)
    @OrderColumn
    @JsonProperty("trips")
    private TripDummy[] trips;

    

    public TripNeedsDummy() {
    }

    public TripNeedsDummy(int autonomy, int chargeTime, TripDummy[] trips) {
        this.autonomy = autonomy;
        this.chargeTime = chargeTime;
        this.trips = trips;
    }

    public Long getId() {
        return id;
    }

    public int getAutonomy() {
        return autonomy;
    }

    public int getChargeTime() {
        return chargeTime;
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
            "\nchargeTime: " + chargeTime +
            "\ntrips: {" + tripsString + "\n}" ;

     }

}
