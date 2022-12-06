import ICar from "../types/Car";

// Toutes les autos
let carsData: ICar[] = [];

// Autos à afficher:
let include: any[] = [];

// Autos à ne pas afficher dû à un type de filtre :
let excludeNo: any[] = [];
let excludeType: string[] = [];

// Type de tri des autos: 
let filter: any = "score";

// Défini toutes les autos dans une variable
const setCars = (cars: ICar[]) => {
    carsData = cars;
}

// Obtient toutes les autos de la variable d'autos
const getAll = () => {
  return carsData;
};

// Remplir les autos à inclure par toutes les autos de la BD
const fillOriginalPartial = () => {
    // Vide la liste actuel d'include
    while(include.length > 0) {
        include.pop();
    }
    // Remplit la liste d'include
    for(let i = 0; i < carsData.length; i++) {
        include.push(i);
    }
}

// Retourne la liste des autos à afficher en ordre d'affichage
const getPartial = () => {
    let partialCars: ICar[] = [];
    for(let i = 0; i < include.length; i++){
        if(include[i] < carsData.length) {
            partialCars.push(carsData[include[i]]);
        }
    }
    partialCars = sortCars(partialCars);
    return partialCars;
};

// Tri les autos d'une liste selon le type défini
const sortCars = (cars: ICar[]) => {
    switch (filter) {
        case 'priceAsc':
            cars.sort((a, b) => a.price - b.price);
            break;
        case 'priceDesc':
            cars.sort((a, b) => b.price - a.price);
            break;
        case 'score':
            cars.sort((a, b) => b.score - a.score);
            break;
    }
    return cars;
}

// Permet de définir quel type de tri utiliser
const setFilter = (filterValue: any) => {
    filter = filterValue;
}

// Ajoute une auto à la liste à inclure
const addValueToInclude = (value: any, type: string) => {
    // S'assure que c'est une valeur valide
    if(value < carsData.length) {
        // Si l'auto était exclu pour ce type de filtre, 
        // la retirer de la liste d'exclusion
        let remove: number = -1;
        for(let i = 0; i < excludeNo.length; i++) {
            if(excludeNo[i] == value) {
                let typeFind = excludeType[i];
                if (typeFind === type) {
                    remove = i;
                } 
            }
        }
        if(remove >= 0) {
            for(let i = remove; i < excludeNo.length ; i++) {
                excludeNo[i] = excludeNo[i+1];
                excludeType[i] = excludeType[i+1];
            } 
            excludeNo.pop();
            excludeType.pop();
        }
        // Si l'auto n'est pas exclu par un autre type de filtre, 
        // la rajouter à la liste à afficher
        let findExclude = excludeNo.indexOf(value);
        if(findExclude < 0) {
            let find = include.indexOf(value);
            if(find < 0) {
                include.push(value);
            }
        }
    }

}

// Retire une auto à la liste à inclure
const removeValueFromInclude = (value: any, type: string) => {
    // S'assure que c'est une valeur valide
    if(value < carsData.length) {
        // Si l'auto est dans la liste à afficher, 
        // la retirer de la liste
        let find = include.indexOf(value);
        if(find >= 0) {
            for(let i = find; i < include.length; i++) {
                include[i] = include[i+1];
            }
            include.pop();
        } 
        // Si l'auto n'est pas déjà dans la liste à exclure pour ce type, 
        // la rajouter à la liste d'exclusion
        let add: boolean = true;
        for(let i = 0; i < excludeNo.length; i++) {
            if(excludeNo[i] == value) {
                let typeFind = excludeType[i];
                if (typeFind === type) {
                    add = false;
                } 
            }
        }
        if(add) {
            excludeNo.push(value);
            excludeType.push(type);
        }
    }
}

const CarFilterUtil = {
  setCars,
  getAll,
  fillOriginalPartial,
  getPartial,
  setFilter,
  addValueToInclude,
  removeValueFromInclude,
};

export default CarFilterUtil;
