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
    @JsonProperty("start_point")
    private String start_point;
    @JsonProperty("end_point")
    private String end_point;
    @JsonProperty("freq")
    private String freq;

    @ManyToOne
    @JoinColumn(name="id_trip")
    private TripNeedsDummy tripneedsdummy;

    public TripDummy() {
    }

    public TripDummy(String name, String start_point, String end_point, String freq) {
        this.start_point = start_point;
        this.end_point = end_point;
        this.freq = freq;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartPoint() {
        return start_point;
    }

    public String getEndPoint() {
        return end_point;
    }

    public String getFreq() {
        return freq;
    }

    public String toString(){
    return "\n\tid: " + id +
        "\n\tname: " + name +
        "\n\tstart: " + start_point +
        "\n\tend: " + end_point +
        "\n\tfreq: " + freq;
 }  
}
