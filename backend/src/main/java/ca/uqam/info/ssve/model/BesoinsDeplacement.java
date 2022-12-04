package java.ca.uqam.info.ssve.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Objet contenant les données des besoins de déplacement de l'usager.
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

public class BesoinsDeplacement {

    private List<Deplacement> deplacementList;
    private final int rechargeTime;
    private final int kmBeforeRecharge;

    /**
     * Constructeur
     * 
     * @param rechargeTime     Temps de rechargement souhaité par l'usager
     * @param kmBeforeRecharge Autonomie du véhicule souhaité par l'usager
     */
    public BesoinsDeplacement(int rechargeTime, int kmBeforeRecharge) {
        this.rechargeTime = rechargeTime;
        this.kmBeforeRecharge = kmBeforeRecharge;
        deplacementList = new ArrayList<>();
    }

    /**
     * Permet d'ajouter un déplacement dans la liste de déplacements
     * 
     * @param d Le déplacement à ajouter
     */
    public void addTravel(Deplacement d) {
        deplacementList.add(d);
    }

    /**
     * Permet de print les données en console.
     * À utiliser uniquement pour le débogage
     */
    public void print() {
        System.out.println("Recharge time: " + rechargeTime);
        System.out.println("Km before recharge: " + kmBeforeRecharge);

        for (int i = 0; i < deplacementList.size(); i++) {
            System.out.println("Travel #" + (i + 1));
            System.out.println("\tStart:" + deplacementList.get(i).getStart().getLat() + " "
                    + deplacementList.get(i).getStart().getLgt() +
                    "\n\tEnd: " + deplacementList.get(i).getEnd().getLat() + " "
                    + deplacementList.get(i).getEnd().getLgt() +
                    "\n\tFrequency: " + deplacementList.get(i).getFd().getMessage());
        }

    }

    /**
     * Retourne la liste de déplacement dans une liste Immutable empêchant ainsi la
     * fuite de données
     * 
     * @return La liste de déplacement
     */
    public List<Deplacement> getDeplacementList() {
        return Collections.unmodifiableList(deplacementList);
    }

    /**
     * Retourne le temps de recharge souhaité par l'usager
     * 
     * @return Le temps de recharge souhaité par l'usager
     */
    public int getRechargeTime() {
        return rechargeTime;
    }

    /**
     * Retourne l'autonomie du véhicule souhaité par l'usager
     * 
     * @return L'autonomie du véhicule souhaité par l'usager
     */
    public int getKmBeforeRecharge() {
        return kmBeforeRecharge;
    }
}
