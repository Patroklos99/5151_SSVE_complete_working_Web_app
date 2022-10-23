/**
 * Enum qui contient les valeurs possible pour la fréquence d'un déplacement
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
public enum FrequenceDeplacement {
    EVERYDAY("Tous les jours", 365),
    WORKING_DAYS("Jours ouvrables", 260),
    ONCE_A_WEEK("Une fois par semaine",52),
    TWICE_A_WEEK("Deux fois par semaine",104),
    ONCE_A_MONTH("Une fois par mois",12),
    TWICE_A_MONTH("Deux fois par mois",24),
    ONCE_A_YEAR("Une fois par année",1),
    TWICE_A_YEAR("Deux fois par année",2);


    private final String message;
    private final int nbDays;

    /**
     * Constructeur
     * @param m Le message qui sera affiché à l'usager pour sélectionner cette fréquence
     * @param nb_days Le nombre de jours par année qui correspond à cette fréquence
     */
    FrequenceDeplacement(String m, int nb_days) {
        this.message = m;
        this.nbDays = nb_days;
    }

    /**
     * Retourne le message qui sera présenté à l'usager pour sélectionner cette fréquence
     * @return Le message qui sera présenté à l'usager pour sélectionner cette fréquence
     */
    public String getMessage() {
        return message;
    }

    /**
     * Retourne le nombre de jours par année qui correspond à cette fréquence
     * @return Le nombre de jours par année qui correspond à cette fréquence
     */
    public int getNb_days() {
        return nbDays;
    }

}
