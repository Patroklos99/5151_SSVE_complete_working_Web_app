package ca.uqam.info.ssve.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
 * @version 2022-10-22
 */
 @Entity
public class GeoPoint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private final String name;
    @JsonProperty("lat")
    private final double lat;
    @JsonProperty("lgt")
    private final double lgt;

    @ManyToOne
    @JoinColumn(name="id_trip")
    private Trip trip;

    /**
     * Constructeur
     * @param lat Latitude du point géographique
     * @param lgt Longitude du point géographique
     */

    public GeoPoint(String name, double lat, double lgt) {
        this.name = name;
        this.lat = lat;
        this.lgt = lgt;
    }

    public GeoPoint(String s) {
        String[] parts = s.split("\\\\");
        this.name = parts[0];
        this.lat = Double.parseDouble(parts[1]);
        this.lgt = Double.parseDouble(parts[2]);
    }

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

            public String toString(){
    return name + ", " + lat + ", " + lgt;
 }  
}
