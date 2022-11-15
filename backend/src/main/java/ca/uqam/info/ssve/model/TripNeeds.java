package ca.uqam.info.ssve.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Objet contenant les données des besoins de déplacement de l'usager.
 *
 * @author David Daoud
 * Code permanent: DAOD80070006
 * Courriel: daoud.david@courrier.uqam.ca
 *
 * @author Christopher Chamberland-Rémillard
 * Code permanent: CHAC29089704
 * Courriel: chamberland-remillard.christopher@courrier.uqam.ca
 *
 * @version 2022-10-22
 */

@Entity
public class TripNeeds implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    private final Long id;
    @OneToMany(mappedBy="tripneeds",cascade = CascadeType.ALL)
    @OrderColumn
    @JsonProperty("trips")
    private List<Trip> trips;
    @JsonProperty("charge_time")
    private final int charge_time;
    @JsonProperty("autonomy")
    private final int autonomy;

    /**
     * Constructeur
     * @param rechargeTime Temps de rechargement souhaité par l'usager
     * @param autonomy Autonomie du véhicule souhaité par l'usager
     */

    public TripNeeds() {
        this.id = null;
        this.charge_time = 0;
        this.autonomy = 0;
        this.trips = new ArrayList();
    }

    public TripNeeds(Long id, int rechargeTime, int autonomy) {
        this.id = id;
        this.charge_time = rechargeTime;
        this.autonomy = autonomy;
        this.trips = new ArrayList();
    }

    public TripNeeds(TripNeedsDummy tnd) {
        this.id = tnd.getId();
        this.charge_time = tnd.getCharge_time();
        this.autonomy = tnd.getAutonomy();
        this.trips = new ArrayList();
        for(TripDummy td: tnd.getTrips()) {
            Trip d = new Trip(td);
            trips.add(d);
        }
    }

    /**
     * Permet d'ajouter un déplacement dans la liste de déplacements
     * @param d Le déplacement à ajouter
     */
    public void addTravel(Trip d) {
        trips.add(d);
    }

    /**
     * Retourne la liste de déplacement dans une liste Immutable empêchant ainsi la fuite de données
     * @return La liste de déplacement
     */
    public List<Trip> getTrips() {
        return Collections.unmodifiableList(trips);
    }

    /**
     * Retourne le temps de recharge souhaité par l'usager
     * @return Le temps de recharge souhaité par l'usager
     */
    public int getChargeTime() {
        return charge_time;
    }

    /**
     * Retourne l'autonomie du véhicule souhaité par l'usager
     * @return L'autonomie du véhicule souhaité par l'usager
     */
    public int getAutonomy() {
        return autonomy;
    }

    public String toString() {
        String tripsString = "";

        for (Trip t: trips) {
            tripsString += t.toString() + '\n';
        }

        return "id: " + id +
            "\nautonomy: " + autonomy +
            "\ncharge_time: " + charge_time +
            "\ntrips: {" + tripsString + "\n}" ;
    }

}
