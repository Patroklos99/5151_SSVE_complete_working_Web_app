package ca.uqam.info.ssve.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.Serializable;
import com.fasterxml.jackson.annotation.JsonProperty;
import ca.uqam.info.ssve.googleTimeline.TimelineData;

//import ca.uqam.info.ssve.googleTimeline.TimelineData;

//import googleTimeline.TimelineData;

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
 * @version 2022-11-30
 */
public class Trip implements Serializable {

    @JsonProperty("name")
    private final String name;

    @JsonProperty("stops")
    private List<GeoPoint> stops;

    @JsonProperty("annualFreq")
    private final int annualFreq;


    /**
     * Constructeur par défaut
     */
    public Trip () {
        this.name = "";
        this.stops = new ArrayList();
        this.annualFreq = 0;
    }

    /**
     * Constructeur
     * @param name Nom du déplacement
     * @param start Point de départ du déplacement
     * @param end Point d'arrivée du déplacement
     * @param freq La frequence du déplacement
     */
    public Trip(String name, List<GeoPoint> list, int freq) {
        this.name = name;
        this.stops = list;
        this.annualFreq = freq;
    }

     public Trip(TimelineData timelineData) {
         this.name = timelineData.getTripName();
         this.stops = timelineData.getStops();
         this.annualFreq = timelineData.getFrequency();
     }

    /**
     * Retourne le nom de déplacement
     * @return Le nom de déplacement
     */
    public String getName() {
        return name;
    }

    /**
     * Retourne les arrêts du déplacement 
     * @return Les arrêts du déplacement 
     */
    public List<GeoPoint> getStops() {
        return Collections.unmodifiableList(stops);
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
            String r = "";
            for(GeoPoint g: stops) {
                r += g.toString() + "\n\t\t";
            }
    return "\n\tname: " + name +
        "\n\tstops: " + r +
        "\n\tfreq: " + annualFreq;
 }  
}
