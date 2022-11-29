import {carsData} from '../assets/data_exemples/cars';
import { ICar } from '../models/cars';

let include: any[] = [];

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
    return partialCars;
};

const addValueToInclude = (value: any) => {
    if(value < carsData.length) {
        let find = include.indexOf(value);
        if(find < 0) {
            include.push(value);
        }
    }
}

const removeValueFromInclude = (value: any) => {
    if(value < carsData.length) {
        let find = include.indexOf(value);
        if(find >= 0) {
            for(let i = find; i < include.length; i++) {
                include[i] = include[i+1];
            }
            include.pop();
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

const update = (index: any, data: ICar) => {
    if(index >= carsData.length) {
        return "error";
    } else {
        carsData[index] = data;
        return carsData[index];
    }
};

const CarFilterUtil = {
  getAll,
  fillPartialInclude,
  clearPartialInclude,
  getPartial,
  addValueToInclude,
  removeValueFromInclude,
  get,
  update,
};

export default CarFilterUtil;
