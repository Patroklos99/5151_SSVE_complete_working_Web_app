package ca.uqam.info.ssve.model;

import lombok.*;

@Data
public class Route {
    private double distance;
    private double tripTime;
    private double waitingTime;
    private double chargingTime;
    private double weight;
    private double score;
    private int frequence;
    private Trip trip;
}
