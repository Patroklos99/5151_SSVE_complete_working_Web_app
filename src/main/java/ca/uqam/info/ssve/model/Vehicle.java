package ca.uqam.info.ssve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String brand;
    private String modelName;
    private int nbDoors;
    private String type;
    private int price;
    private int range;
    private int batteryCapacity;
    private double score;

    public Vehicle(Long id, String brand, String modelName, int nbDoors, String type, int price, int range, int batteryCapacity, double score, int safetyScore, String refLink, String imgLink) {
        this.id = id;
        this.brand = brand;
        this.modelName = modelName;
        this.nbDoors = nbDoors;
        this.type = type;
        this.price = price;
        this.range = range;
        this.batteryCapacity = batteryCapacity;
        this.score = score;
        this.safetyScore = safetyScore;
        this.refLink = refLink;
        this.imgLink = imgLink;
    }

    private int safetyScore;
    private String refLink;
    private String imgLink;


    public Vehicle() {
    }



    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getNbDoors() {
        return nbDoors;
    }

    public void setNbDoors(int nbDoors) {
        this.nbDoors = nbDoors;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public double getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getSafetyScore() {
        return safetyScore;
    }

    public void setSafetyScore(int safetyScore) {
        this.safetyScore = safetyScore;
    }

    public String getRefLink() {
        return refLink;
    }

    public void setRefLink(String refLink) {
        this.refLink = refLink;
    }

    public String getImgLink() {
        return imgLink;
    }

    public void setImgLink(String imgLink) {
        this.imgLink = imgLink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }
}
