package ca.uqam.info.ssve.model;

import java.util.Random;

public class Evaluation extends Vehicle{
    private double score;

    public Evaluation() {
        Random r = new Random();
        this.score = r.nextDouble(0,10);
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

}
