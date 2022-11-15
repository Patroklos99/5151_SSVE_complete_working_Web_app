export default interface TripData {

    id?: number | null, // The id of the Car
    name: string | null, // The model of the car
    start: number | null,
    end: number | null,
    frequency: Frequency | null,

}



export enum Frequency {

    tousLesJours = "Tous les jours",
    joursOUvrables = "Jours ouvrables",
    uneFoisSemaine = "Une fois par semaine",
    deuxFoisSemaine = "Deux fois par semaine",
    uneFoisMois = "Une fois par mois",
    deuxFoisMois = "Deux fois mois",
    uneFoisAnnee = "Une fois par année",
    deuxFoisAnnee = "Deux fois par année"

}