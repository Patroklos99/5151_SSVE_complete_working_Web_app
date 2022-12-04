package java.ca.uqam.info.ssve.model;

import lombok.Data;

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
    private int nbPlaces;
    @NotEmpty
    private String type;
    @NotEmpty
    private int price;
    @NotEmpty
    private double maintainCosts;
    @NotEmpty
    private int electricalCapacity;
    @NotEmpty
    private double electricalStreetConsumption;
    @NotEmpty
    private double electricalHighwayConsumption;
    @NotEmpty
    private int gasCapacity;
    @NotEmpty
    private double gasStreetConsumption;
    @NotEmpty
    private double gasHighwayConsumption;
    @NotEmpty
    private int loadCapacity;
    @NotEmpty
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
            int maintainCosts,
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