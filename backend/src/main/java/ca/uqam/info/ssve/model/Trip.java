package ca.uqam.info.ssve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String start;
    private String tripEnd;
    private String freq;

    public Trip() {
    }

    public Trip(Long id, String name, String start, String tripEnd, String freq) {
        this.id = id;
        this.name = name;
        this.start = start;
        this.tripEnd = tripEnd;
        this.freq = freq;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return tripEnd;
    }

    public void setEnd(String tripEnd) {
        this.tripEnd = tripEnd;
    }

    public String getFreq() {
        return freq;
    }

    public void setFreq(String freq) {
        this.freq = freq;
    }
}
