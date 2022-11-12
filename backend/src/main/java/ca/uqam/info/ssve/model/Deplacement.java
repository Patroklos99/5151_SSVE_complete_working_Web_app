package ca.uqam.info.ssve.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Deplacement {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private final Long id;
    private final PointGeo start;
    private final PointGeo end;
    private final FrequenceDeplacement fd;

    /**
     * Constructeur
     * @param start Point de départ du déplacement
     * @param end Point d'arrivée du déplacement
     * @param fd La frequence du déplacement
     */
    public Deplacement(long id, PointGeo start, PointGeo end, FrequenceDeplacement fd) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.fd = fd;
    }

    /**
     * Retourne le point de départ du déplacement
     * @return Le point de départ du déplacement
     */
    public PointGeo getStart() {
        return start;
    }

    /**
     * Retourne le point d'arrivée du déplacement
     * @return Le point d'arrivée du déplacement
     */
    public PointGeo getEnd() {
        return end;
    }

    /**
     * Retourne la fréquence du déplacement
     * @return La fréquence du déplacement
     */
    public FrequenceDeplacement getFd() {
        return fd;
    }
}
