package ca.uqam.info.ssve.model;


import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objet contenant les données de déplacement de l'usager.
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
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    private final Long id;

    @JsonProperty("name")
    private final String name;

    @OneToOne(mappedBy="trip",cascade = CascadeType.ALL)
    @OrderColumn
    @JsonProperty("start_point")
    private final GeoPoint start_point;
    @OneToOne(mappedBy="trip",cascade = CascadeType.ALL)
    @OrderColumn
    @JsonProperty("end_point")
    private final GeoPoint end_point;
    @JsonProperty("freq")
    private final int freq; // NOMBRE DE FOIS PAR ANNÉE QUE LE DÉPLACEMENT EST FAIT

    @ManyToOne
    @JoinColumn(name="id_trip")
    private TripNeeds tripneeds;

    /**
     * Constructeur
     * @param start Point de départ du déplacement
     * @param end Point d'arrivée du déplacement
     * @param fd La frequence du déplacement
     */

    public Trip () {
        this.id = null;
        this.name = "";
        this.start_point = null;
        this.end_point = null;
        this.freq = 0;
    }

    public Trip(long id, String name, GeoPoint start, GeoPoint end, int f) {
        this.id = id;
        this.name = name;
        this.start_point = start;
        this.end_point = end;
        this.freq = f;
    }


    public Trip(TripDummy td) {
        this.id = td.getId();
        this.name = td.getName();
        this.start_point = new GeoPoint(td.getStartPoint());
        this.end_point = new GeoPoint(td.getEndPoint());
        String[] parts = td.getFreq().split("\\\\");
        int num = Integer.parseInt(parts[0]);
        String s = parts[1];
        int mult = 0;
        switch(s) {
            case "Jour" :
                mult = 365;
            break;
            case "Semaine" :
                mult = 52;
            break;
            case "Mois" :
                mult = 12;
            break;
            case "Année" :
                mult = 1;
            break;
        }
        this.freq = num * mult;
    }

    public String getName() {
        return name;
    }

    /**
     * Retourne le point de départ du déplacement
     * @return Le point de départ du déplacement
     */
    public GeoPoint getStart() {
        return start_point;
    }

    /**
     * Retourne le point d'arrivée du déplacement
     * @return Le point d'arrivée du déplacement
     */
    public GeoPoint getEnd() {
        return end_point;
    }

    /**
     * Retourne la fréquence du déplacement
     * @return La fréquence du déplacement
     */
    public int getFd() {
        return freq;
    }

        public String toString(){
    return "\n\tid: " + id +
        "\n\tname: " + name +
        "\n\tstart: " + start_point.toString() +
        "\n\tend: " + end_point.toString()+
        "\n\tfreq: " + freq;
 }  
}
