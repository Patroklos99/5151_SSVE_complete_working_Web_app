package ca.uqam.info.ssve.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class Vehicle implements Comparable<Vehicle>{

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

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModelName() {
        return modelName;
    }

    public int getNbDoors() {
        return nbDoors;
    }

    public String getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public int getRange() {
        return range;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public int getSafetyScore() {
        return safetyScore;
    }

    public String getImgLink() {
        return imgLink;
    }

    public String getRefLink() {
        return refLink;
    }

    //------------------------------------------------------ ---------------------------------------
    public void setId(Long id) {
            this.id = id;
    }

    public void setBrand(String brand) {
            this.brand = brand;
    }

    public void setModelName(String modelName) {
            this.modelName = modelName;
    }

    public void setNbDoors(int nbDoors) {
            this.nbDoors = nbDoors;
    }

    public void setType(String type) {
            this.type = type;
    }

    public void setPrice(int price) {
            this.price = price;
    }

    public void setRange(int range) {
            this.range = range;
    }

    public void setBatteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
    }

    public void setSafetyScore(int safetyScore) {
            this.safetyScore = safetyScore;
    }

    public void setRefLink(String refLink) {
            this.refLink = refLink;
    }

    public void setImgLink(String imgLink) {
            this.imgLink = imgLink;
    }

    //a modifier
    @Override
    public int compareTo(Vehicle o) {
        return Integer.compare(this.getSafetyScore(), o.getSafetyScore());
    }
}
