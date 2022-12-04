import {carsData} from '../assets/data_exemples/cars';
import { ICar } from '../models/cars';

let include: any[] = [];
let filter: any = "score";
let excludeNo: any[] = [];
let excludeType: string[] = [];

const getAll = () => {
  return carsData;
};

const fillPartialInclude = () => {
    clearPartialInclude();
    for(let i = 0; i < carsData.length; i++) {
        include.push(i);
    }
}

const clearPartialInclude = () => {
    while(include.length > 0) {
        include.pop();
    }
}

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

const sortCars = (cars: ICar[]) => {
    switch (filter) {
        case 'priceAsc':
            cars.sort((a, b) => a.prix - b.prix);
            break;
        case 'priceDesc':
            cars.sort((a, b) => b.prix - a.prix);
            break;
        case 'score':
            cars.sort((a, b) => b.score - a.score);
            break;
    }
    return cars;
}

const addValueToInclude = (value: any, type: string) => {

    if(value < carsData.length) {
        
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

        let findExclude = excludeNo.indexOf(value);
        if(findExclude < 0) {
            let find = include.indexOf(value);
            if(find < 0) {
                include.push(value);
            }
        }
    }

}

const removeValueFromInclude = (value: any, type: string) => {

    if(value < carsData.length) {
        let find = include.indexOf(value);
        if(find >= 0) {
            for(let i = find; i < include.length; i++) {
                include[i] = include[i+1];
            }
            include.pop();
        } 


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

const get = (index: any) => {
  if(index >= carsData.length) {
    return "error";
  } else {
    return carsData[index];
  }
};

const setFilter = (filterValue: any) => {
    filter = filterValue;
}

const CarFilterUtil = {
  getAll,
  fillPartialInclude,
  clearPartialInclude,
  getPartial,
  addValueToInclude,
  removeValueFromInclude,
  get,
  setFilter,
};

export default CarFilterUtil;
