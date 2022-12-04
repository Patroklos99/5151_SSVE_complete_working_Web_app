package java.ca.uqam.info.ssve.model;

import lombok.Data;

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
 * @version 2022-10-22
 */
@Data
public class PointGeo {

    private final double lat;
    private final double lgt;

    /**
     * Constructeur
     * 
     * @param lat Latitude du point géographique
     * @param lgt Longitude du point géographique
     */
    public PointGeo(double lat, double lgt) {
        this.lat = lat;
        this.lgt = lgt;
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
}
