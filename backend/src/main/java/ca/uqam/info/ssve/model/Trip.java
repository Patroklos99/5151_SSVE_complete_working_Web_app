package ca.uqam.info.ssve.model;


import java.io.Serializable;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objet contenant les données d'un déplacement de l'usager.
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
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_trip")
    @JsonProperty("id_trip")
    private final Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private final String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="geoPointStart_id", referencedColumnName="id_geopoint")
    @JsonProperty("startPoint")
    private final GeoPoint startPoint;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="geoPointEnd_id", referencedColumnName="id_geopoint")
    @JsonProperty("endPoint")
    private final GeoPoint endPoint;

    @Column(name = "annualFreq")
    @JsonProperty("freq")
    private final int annualFreq;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="id_trip_needs")
    private TripNeeds tripneeds;


    /**
     * Constructeur par défaut
     */
    public Trip () {
        this.id = null;
        this.name = "";
        this.startPoint = null;
        this.endPoint = null;
        this.annualFreq = 0;
    }

    /**
     * Constructeur
     * @param id Id de l'objet
     * @param name Nom du déplacement
     * @param start Point de départ du déplacement
     * @param end Point d'arrivée du déplacement
     * @param freq La frequence du déplacement
     */
    public Trip(long id, String name, GeoPoint start, GeoPoint end, int freq) {
        this.id = id;
        this.name = name;
        this.startPoint = start;
        this.endPoint = end;
        this.annualFreq = freq;
    }

    /**
     * Retourne le id de l'objet
     * @return Le id de l'objet
     */
    public Long getId() {
        return id;
    }

    /**
     * Retourne le nom de déplacement
     * @return Le nom de déplacement
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne le point de départ du déplacement
     * @return Le point de départ du déplacement
     */
    public GeoPoint getStartPoint() {
        return startPoint;
    }

    /**
     * Retourne le point d'arrivée du déplacement
     * @return Le point d'arrivée du déplacement
     */
    public GeoPoint getEndPoint() {
        return endPoint;
    }

    /**
     * Retourne la fréquence du déplacement
     * @return La fréquence du déplacement
     */
    public int getFreq() {
        return annualFreq;
    }

    /**
     * Permet l'affichage d'un objet Trip
     */
        public String toString(){
    return "\n\tid: " + id +
        "\n\tname: " + name +
        "\n\tstart: " + startPoint.toString() +
        "\n\tend: " + endPoint.toString()+
        "\n\tfreq: " + annualFreq;
 }  
}
