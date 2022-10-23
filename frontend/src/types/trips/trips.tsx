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
    uneFoisSemaine = "1 fois par semaine",
    deuxFoisSemaine = "2 fois par semaine",
    uneFoisMois = "1 fois par mois",
    deuxFoisMois = "2 fois mois",
    uneFoisAnnee = "1 fois par année",
    deuxFoisAnnee = "2 fois année"

}