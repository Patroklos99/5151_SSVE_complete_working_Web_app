import { ClassNames } from '@emotion/react';
import FormControlLabel  from '@mui/material/FormControlLabel';
import React from 'react';
import FormGroup from '@mui/material/FormGroup';
import Checkbox from '@mui/material/Checkbox';
import CarFilterUtil from '../../../util/CarFilterUtil';
import { ICar } from '../../../models/cars';

export default function CheckboxComp( brand: any, changeChecked: any): any {

    let PorscheAppear : boolean = true;
    let TeslaAppear : boolean = true;
    let BmwAppear : boolean = true;

    const filterCompleted = (marque : boolean, nom : any) => {
        marque = !marque;

        if(marque == true) {
            let cars: ICar[] = CarFilterUtil.getAll();
            for(let i = 0; i < cars.length; i++) {
                if(cars[i].marque == nom) {
                    CarFilterUtil.addValueToInclude(i);
                }
            }
        } else if (marque == false) {
            let cars: ICar[] = CarFilterUtil.getAll();
            for(let i = 0; i < cars.length; i++) {
                if(cars[i].marque == nom) {
                    CarFilterUtil.removeValueFromInclude(i);
                }
            }
        }
        
        return marque;
    }
    
    return (
        <FormGroup>

            <FormControlLabel onChange={() => PorscheAppear = filterCompleted(PorscheAppear, "Porsche")} control={<Checkbox defaultChecked color="success"/>} label="Porsche" />
            <FormControlLabel onChange={() => TeslaAppear = filterCompleted(TeslaAppear, "Tesla")} control={<Checkbox defaultChecked color="success"/>} label="Tesla" />
            <FormControlLabel onChange={() => BmwAppear = filterCompleted(BmwAppear, "Bmw")} control={<Checkbox defaultChecked color="success"/>} label="Bmw" />

        </FormGroup>
    );

}