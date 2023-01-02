package ca.uqam.info.ssve.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Size(max = 20)
    private String brand;
    @NotEmpty
    @Size(max = 20)
    private String modelName;

    @NotNull
    @Min(1)
    @Max(8)
    private int nbPlaces;

    @NotEmpty
    @Size(max = 20)
    private String type;
    @NotNull
    @Min(1)
    @Max(Integer.MAX_VALUE)
    private int price;
    @NotNull
    @Min(1)
    @Max(1000)
    private double maintainCosts;
    @NotNull
    @Min(1)
    @Max(499)
    private int electricalCapacity;
    @NotNull
    @Min(1)
    @Max(99)
    private double electricalStreetConsumption;
    @NotNull
    @Min(1)
    @Max(99)
    private double electricalHighwayConsumption;
    @NotNull
    @Min(0)
    @Max(499)
    private int gasCapacity;
    @NotNull
    @Min(1)
    @Max(100)
    private double gasStreetConsumption;

    @NotNull
    @Min(1)
    @Max(100)
    private double gasHighwayConsumption;

    @NotNull
    @Min(1)
    @Max(499)
    private int loadCapacity;

    @NotNull
    @Min(0)
    @Max(5)
    private int safetyScore;

    @NotEmpty
    @Size(max = 100)
    private String refLink;

    @NotEmpty
    @Size(max = 100)
    private String imgLink;

    @NotEmpty(message = "description shouldnt be empty")
    @Size(max = 1000)
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