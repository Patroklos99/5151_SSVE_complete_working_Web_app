package ca.uqam.info.ssve.model;

import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Objet contenant les données d'un point géographique.
 *
 * @author David Daoud
 *         Code permanent: DAOD80070006
 *         Courriel: daoud.david@courrier.uqam.ca
 *
 * @author Christopher Chamberland-Rémillard
 *         Code permanent: CHAC29089704
 *         Courriel: chamberland-remillard.christopher@courrier.uqam.ca
 *
 * @version 2022-11-30
 */
public class GeoPoint implements Serializable {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("lat")
    private final double lat;

    @JsonProperty("lgt")
    private final double lgt;

    /**
     * Constructeur par défaut
     */

    public GeoPoint() {
        this.name = "";
        this.lat = 0;
        this.lgt = 0;
    }

    /**
     * Constructeur
     * 
     * @param name Nom de l'endroit
     * @param lat  Latitude du point géographique
     * @param lgt  Longitude du point géographique
     */
    public GeoPoint(String name, double lat, double lgt) {
        this.name = name;
        this.lat = lat;
        this.lgt = lgt;
    }

    /**
     * Retourne le nom du point géographique
     * 
     * @return Le nom du point géographique
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne la latitude du point géographique
     * 
     * @return La latitude du point géographique
     */
    public double getLat() {
        return lat;
    }

    /**
     * Retourne la longitude du point géographique
     * 
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
