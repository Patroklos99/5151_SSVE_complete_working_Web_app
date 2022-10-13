import { ICar } from "../../models/cars";



export const carsData: ICar[] = [
    {
        id: 0,
        marque: "Bmw",
        modele: "Cool",
        nbPortes: 3,
        type: "VUS",
        prix: 75000,
        autonomie: 250,
        capacite: 140,
        tempsRecharge: 10000,
        score: 98,
        scoreSecurite: 78,
        lienReference: "String",
        image: "blob"
    },
    {
        id: 1,
        marque: "Bmw",
        modele: "Trop Cool",
        nbPortes: 4,
        type: "Berline",
        prix: 95000,
        autonomie: 350,
        capacite: 140,
        tempsRecharge: 20000,
        score: 89,
        scoreSecurite: 88,
        lienReference: "String",
        image: "blob"
    },
    {
        id: 2,
        marque: "Porsche",
        modele: "Mega Cool",
        nbPortes: 3,
        type: "berline",
        prix: 175000,
        autonomie: 350,
        capacite: 180,
        tempsRecharge: 30000,
        score: 94,
        scoreSecurite: 92,
        lienReference: "String",
        image: "blob"
    }
]