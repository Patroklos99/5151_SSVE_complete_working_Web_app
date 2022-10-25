package ca.uqam.info.ssve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String brand;
    private String modelName;
    private int nbDoors;
    private String type;
    private int price;
    private int range;
    private int batteryCapacity;
    private double score;
    private int safetyScore;
    private String refLink;
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

    public double getBatteryCapacity() {
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

    public double getScore() {
        return score;
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

    public void setScore(double score) {
            this.score = score;
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

}
