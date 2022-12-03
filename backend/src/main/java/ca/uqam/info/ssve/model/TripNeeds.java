package ca.uqam.info.ssve.model;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
 * @version 2022-11-30
 */

public class TripNeeds implements Serializable {

    @JsonProperty("trips")
    private List<Trip> trips;

    @JsonProperty("chargeTime")
    private final int chargeTime;

    @JsonProperty("autonomy") 
    private final int autonomy;

    /**
     * Constructeur par défaut
     */

    public TripNeeds() {
        this.chargeTime = 0;
        this.autonomy = 0;
        this.trips = new ArrayList();
    }

    /**
     * Constructeur
     * @param chargeTime Temps de rechargement souhaité par l'usager
     * @param autonomy Autonomie du véhicule souhaité par l'usager
     */
    public TripNeeds(int chargeTime, int autonomy) {
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
        return "autonomy: " + autonomy +
            "\nchargeTime: " + chargeTime +
            "\ntrips: {" + tripsString + "\n}" ;
    }

}
