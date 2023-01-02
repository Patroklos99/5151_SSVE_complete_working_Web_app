package ca.uqam.info.ssve.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @NotNull
    private int nbPlaces;
    @NotEmpty
    private String type;
    @NotNull
    private int price;
    @NotNull
    private double maintainCosts;
    @NotNull
    private int electricalCapacity;
    @NotNull
    private double electricalStreetConsumption;
    @NotNull
    private double electricalHighwayConsumption;
    @NotNull
    private int gasCapacity;
    @NotNull
    private double gasStreetConsumption;

    @NotNull
    private double gasHighwayConsumption;
    @NotNull
    private int loadCapacity;
    @NotNull
    private int safetyScore;
    @NotEmpty
    private String refLink;
    @NotEmpty
    private String imgLink;
    @NotEmpty
    private String description;

    public Vehicle(
            String brand,
            String modelName,
            int nbPlaces,
            String type,
            int price,
            double maintainCosts,
            int electricalCapacity,
            double electricalStreetConsumption,
            double electricalHighwayConsumption,
            int gasCapacity,
            double gasStreetConsumption,
            double gasHighwayConsumption,
            int loadCapacity,
            int safetyScore,
            String refLink,
            String imgLink,
            String description) {
        this.brand = brand;
        this.modelName = modelName;
        this.nbPlaces = nbPlaces;
        this.type = type;
        this.price = price;
        this.maintainCosts = maintainCosts;
        this.electricalCapacity = electricalCapacity;
        this.electricalStreetConsumption = electricalStreetConsumption;
        this.electricalHighwayConsumption = electricalHighwayConsumption;
        this.gasCapacity = gasCapacity;
        this.gasStreetConsumption = gasStreetConsumption;
        this.gasHighwayConsumption = gasHighwayConsumption;
        this.loadCapacity = loadCapacity;
        this.safetyScore = safetyScore;
        this.refLink = refLink;
        this.imgLink = imgLink;
        this.description = description;
    }

    public Vehicle() {
    }
}