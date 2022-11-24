package ca.uqam.info.ssve.model;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objet contenant les données d'un point géographique.
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
public class GeoPoint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id_geopoint")
    @JsonProperty("id_geopoint")
    private Long id;

    @Column(name = "name")
    @JsonProperty("name")
    private final String name;

    @Column(name = "lat")
    @JsonProperty("lat")
    private final double lat;

    @Column(name = "lgt")
    @JsonProperty("lgt")
    private final double lgt;

    @OneToOne(mappedBy="startPoint")
    @JoinColumn(name="id_trip")
    private Trip trip;

    @OneToOne(mappedBy="endPoint")
    @JoinColumn(name="id_trip")
    private Trip trip2;

    /**
     * Constructeur par défaut
     */

    public GeoPoint() {
        this.id = null;
        this.name = "";
        this.lat = 0;
        this.lgt = 0;
    }

    /**
     * Constructeur
     * @param id Id de l'objet
     * @param name Nom de l'endroit
     * @param lat Latitude du point géographique
     * @param lgt Longitude du point géographique
     */
    public GeoPoint(Long id, String name, double lat, double lgt) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lgt = lgt;
    }

    /**
     * Retourne le id de l'objet
     * @return Le id de l'objet
     */
    public Long getId() {
        return id;
    }

    /**
     * Retourne le nom du point géographique
     * @return Le nom du point géographique
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne la latitude du point géographique
     * @return La latitude du point géographique
     */
    public double getLat() {
        return lat;
    }

    /**
     * Retourne la longitude du point géographique
     * @return La longitude du point géographique
     */
    public double getLgt() {
        return lgt;
    }

    /**
     * Permet l'affichage d'un objet GeoPoint
     */   
    public String toString() {
        return name + ", " + lat + ", " + lgt;
    }  
}
