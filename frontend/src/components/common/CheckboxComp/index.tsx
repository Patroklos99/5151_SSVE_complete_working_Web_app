import { ClassNames } from '@emotion/react';
import FormControlLabel  from '@mui/material/FormControlLabel';
import React from 'react';
import FormGroup from '@mui/material/FormGroup';
import Checkbox from '@mui/material/Checkbox';
import CarService from '../../../services/CarService';
import { ICar } from '../../../models/cars';

export default function CheckboxComp( brand: any, changeChecked: any): any {

    let PorscheAppear : boolean = true;
    let TeslaAppear : boolean = true;
    let BmwAppear : boolean = true;

    const filterCompleted = (marque : boolean, nom : any) => {
        marque = !marque;

        if(marque == true) {
            let cars: ICar[] = CarService.getAll();
            for(let i = 0; i < cars.length; i++) {
                if(cars[i].marque == nom) {
                    CarService.addValueToInclude(i);
                }
            }
        } else if (marque == false) {
            let cars: ICar[] = CarService.getAll();
            for(let i = 0; i < cars.length; i++) {
                if(cars[i].marque == nom) {
                    CarService.removeValueFromInclude(i);
                }
            }
        }
        
        return marque;
    }
    
    return (
        <FormGroup>

            <FormControlLabel onChange={() => PorscheAppear = filterCompleted(PorscheAppear, "Porsche")} control={<Checkbox defaultChecked />} label="Porsche" />
            <FormControlLabel onChange={() => TeslaAppear = filterCompleted(TeslaAppear, "Tesla")} control={<Checkbox defaultChecked />} label="Tesla" />
            <FormControlLabel onChange={() => BmwAppear = filterCompleted(BmwAppear, "Bmw")} control={<Checkbox defaultChecked />} label="Bmw" />

        </FormGroup>
    );

}