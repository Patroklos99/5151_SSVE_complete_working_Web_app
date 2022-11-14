package ca.uqam.info.ssve.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    private String brand;
    @NotEmpty
    private String modelName;
    @NotEmpty
    private int nbDoors;
    @NotEmpty
    private String type;
    @NotEmpty
    private int price;
    @NotEmpty
    private int range;
    @NotEmpty
    private int batteryCapacity;
    @NotEmpty
    private int safetyScore;
    @NotEmpty
    private String refLink;
    @NotEmpty
    private String imgLink;


    public Vehicle(String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, int safetyScore, String refLink, String imgLink) {
        this.brand = brand;
        this.modelName = modelName;
        this.nbDoors = nbDoors;
        this.type = type;
        this.price = price;
        this.range = range;
        this.batteryCapacity = batteryCapacity;
        this.safetyScore = safetyScore;
        this.refLink = refLink;
        this.imgLink = imgLink;
    }

    public Vehicle() {
    }
}