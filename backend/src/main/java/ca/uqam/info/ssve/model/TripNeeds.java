package ca.uqam.info.ssve.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.persistence.*;
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
 * @version 2022-11-23
 */

@Entity
public class TripNeeds implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_trip_needs")
    @JsonProperty("id_trip_needs")
    private final Long id;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_trip_needs")
    @JsonProperty("trips")
    private List<Trip> trips;

    @Column(name = "chargeTime")
    @JsonProperty("chargeTime")
    private final int chargeTime;

    @Column(name = "autonomy")
    @JsonProperty("autonomy")
    private final int autonomy;

    /**
     * Constructeur par défaut
     */

    public TripNeeds() {
        this.id = null;
        this.chargeTime = 0;
        this.autonomy = 0;
        this.trips = new ArrayList();
    }

    /**
     * Constructeur
     * @param id Id de l'objet
     * @param chargeTime Temps de rechargement souhaité par l'usager
     * @param autonomy Autonomie du véhicule souhaité par l'usager
     */
    public TripNeeds(Long id, int chargeTime, int autonomy) {
        this.id = id;
        this.chargeTime = chargeTime;
        this.autonomy = autonomy;
        this.trips = new ArrayList();
    }

    /**
     * Permet d'ajouter un déplacement dans la liste de déplacements
     * @param d Le déplacement à ajouter
     */
    public void addTravel(Trip d) {
        trips.add(d);
    }

    /**
     * Retourne le id de l'objet
     * @return Le id de l'objet
     */
    public Long getId() {
        return id;
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
        return chargeTime;
    }

    /**
     * Retourne l'autonomie du véhicule souhaité par l'usager
     * @return L'autonomie du véhicule souhaité par l'usager
     */
    public int getAutonomy() {
        return autonomy;
    }


    /**
     * Permet l'affichage d'un objet TripNeeds
     */
    public String toString() {
        String tripsString = "";

        for (Trip t: trips) {
            tripsString += t.toString() + '\n';
        }

        return "id: " + id +
            "\nautonomy: " + autonomy +
            "\nchargeTime: " + chargeTime +
            "\ntrips: {" + tripsString + "\n}" ;
    }

}
