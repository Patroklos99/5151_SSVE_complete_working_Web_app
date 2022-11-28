package ca.uqam.info.ssve.model;

import java.util.Random;

public class Evaluation extends Vehicle {
    private double score;

    public Evaluation() {
        Random r = new Random();
        this.score = r.nextDouble(0, 10);
    }

    public Evaluation(Vehicle vehicle) {
        this.setId(vehicle.getId());
        this.setBrand(vehicle.getBrand());
        this.setModelName(vehicle.getModelName());
        this.setNbPlaces(vehicle.getNbPlaces());
        this.setType(vehicle.getType());
        this.setPrice(vehicle.getPrice());
        this.setMaintainCosts(vehicle.getMaintainCosts());
        this.setElectricalCapacity(vehicle.getElectricalCapacity());
        this.setElectricalStreetConsumption(vehicle.getElectricalStreetConsumption());
        this.setElectricalHighwayConsumption(vehicle.getElectricalHighwayConsumption());
        this.setGasCapacity(vehicle.getGasCapacity());
        this.setGasStreetConsumption(vehicle.getGasStreetConsumption());
        this.setGasHighwayConsumption(vehicle.getGasHighwayConsumption());
        this.setLoadCapacity(vehicle.getLoadCapacity());
        this.setSafetyScore(vehicle.getSafetyScore());
        this.setRefLink(vehicle.getRefLink());
        this.setImgLink(vehicle.getImgLink());
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
