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
        if (validateId(id))
            this.id = id;
    }

    public void setBrand(String brand) {
        if (validateBrand(brand))
            this.brand = brand;
    }

    public void setModelName(String modelName) {
        if (validateModelName(modelName))
            this.modelName = modelName;
    }

    public void setNbDoors(int nbDoors) {
        if (validateNbDoors(nbDoors))
            this.nbDoors = nbDoors;
    }

    public void setType(String type) {
        if (validateType(type))
            this.type = type;
    }

    public void setPrice(int price) {
        if (validatePrice(price))
            this.price = price;
    }

    public void setRange(int range) {
        if (validateRange(range))
            this.range = range;
    }

    public void setBatteryCapacity(int batteryCapacity) {
        if (validateBatteryCapacity(batteryCapacity))
            this.batteryCapacity = batteryCapacity;
    }

    public void setScore(double score) {
        if (validateScore(score))
            this.score = score;
    }

    public void setSafetyScore(int safetyScore) {
        if (validateSafetyScore(safetyScore))
            this.safetyScore = safetyScore;
    }

    public void setRefLink(String refLink) {
        if (validateRefLink(refLink))
            this.refLink = refLink;
    }

    public void setImgLink(String imgLink) {
        if (validateImgLink(imgLink))
            this.imgLink = imgLink;
    }

    // ----------------------------------------------------   ----------------------------------------
    private boolean validateId(Long id) {
        return id > 0 && id < Integer.MAX_VALUE;
    }

    private boolean validateBrand(String brand) {
        return brand.matches("[a-zA-Z]+");
    }

    private boolean validateModelName(String modelName) {
        return modelName.matches("[A-Za-z\s0-9]]");
    }

    private boolean validateNbDoors(int nbDoors) {
        return nbDoors > 0 && nbDoors < 10;
    }

    private boolean validateType(String type) {
        return type.matches("[a-zA-Z]+");
    }

    private boolean validatePrice(int price) {
        return price > 0 && price < Integer.MAX_VALUE;
    }

    private boolean validateRange(int range) {
        return range > 0 && range < 2000;
    }

    private boolean validateBatteryCapacity(int batteryCapacity) {
        return batteryCapacity > 0 && batteryCapacity < Integer.MAX_VALUE;
    }

    private boolean validateScore(double score) {
        return score >= 0.0 && score <= 15.0;
    }

    private boolean validateSafetyScore(int safetyScore) {
        return safetyScore >= 0 && safetyScore <= 5;
    }

    private boolean validateRefLink(String refLink) {
        return refLink.matches("(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
    }

    private boolean validateImgLink(String imgLink) {
        return imgLink.matches("(\\b(https?|ftp|file)://)?[-A-Za-z0-9+&@#/%?=~_|!:,.;]+[-A-Za-z0-9+&@#/%=~_|]");
    }


}
