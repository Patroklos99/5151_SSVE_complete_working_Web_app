package ca.uqam.info.ssve.model;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class TripDummy implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("startPoint")
    private String startPoint;
    @JsonProperty("endPoint")
    private String endPoint;
    @JsonProperty("freq")
    private String freq;

    @ManyToOne
    @JoinColumn(name="idTrip")
    private TripNeedsDummy tripneedsdummy;

    public TripDummy() {
    }

    public TripDummy(String name, String startPoint, String endPoint, String freq) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.freq = freq;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartPoint() {
        return startPoint;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public String getFreq() {
        return freq;
    }

    public String toString(){
    return "\n\tid: " + id +
        "\n\tname: " + name +
        "\n\tstart: " + startPoint +
        "\n\tend: " + endPoint +
        "\n\tfreq: " + freq;
 }  
}
