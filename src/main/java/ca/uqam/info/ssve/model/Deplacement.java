package ca.uqam.info.ssve.model;

import lombok.*;

@Data
public class Deplacement {
    private double start_coordinate;
    private double end_coordinate;
    private double distance;
    private double tripTime;
    private double waitingTime;
    private double chargingTime;
    private int frequence;
}
