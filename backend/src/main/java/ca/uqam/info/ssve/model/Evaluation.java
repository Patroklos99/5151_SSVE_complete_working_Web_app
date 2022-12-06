package ca.uqam.info.ssve.model;

import java.util.Random;

public class Evaluation {
    private double score;
    private int trajetTotal;
    private int nbTrajetSansRecharge;
    private Vehicle vehicle = new Vehicle();

    public Evaluation() {
        Random r = new Random();
        this.score = r.nextDouble(0, 10);
    }

    public Evaluation(Vehicle vehicle) {
        this.vehicle.setId(vehicle.getId());
        this.vehicle.setBrand(vehicle.getBrand());
        this.vehicle.setModelName(vehicle.getModelName());
        this.vehicle.setNbPlaces(vehicle.getNbPlaces());
        this.vehicle.setType(vehicle.getType());
        this.vehicle.setPrice(vehicle.getPrice());
        this.vehicle.setMaintainCosts(vehicle.getMaintainCosts());
        this.vehicle.setElectricalCapacity(vehicle.getElectricalCapacity());
        this.vehicle.setElectricalStreetConsumption(vehicle.getElectricalStreetConsumption());
        this.vehicle.setElectricalHighwayConsumption(vehicle.getElectricalHighwayConsumption());
        this.vehicle.setGasCapacity(vehicle.getGasCapacity());
        this.vehicle.setGasStreetConsumption(vehicle.getGasStreetConsumption());
        this.vehicle.setGasHighwayConsumption(vehicle.getGasHighwayConsumption());
        this.vehicle.setLoadCapacity(vehicle.getLoadCapacity());
        this.vehicle.setSafetyScore(vehicle.getSafetyScore());
        this.vehicle.setRefLink(vehicle.getRefLink());
        this.vehicle.setImgLink(vehicle.getImgLink());
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public int getTrajetTotal() {
        return trajetTotal;
    }

    public void setTrajetTotal(int trajetTotal) {
        this.trajetTotal = trajetTotal;
    }

    public double getNbTrajetSansRecharge() {
        return nbTrajetSansRecharge;
    }

    public void setNbTrajetSansRecharge(int nbTrajetSansRecharge) {
        this.nbTrajetSansRecharge = nbTrajetSansRecharge;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
