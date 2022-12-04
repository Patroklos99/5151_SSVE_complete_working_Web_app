import React, { useState } from 'react';
import { ClassNames } from '@emotion/react';
import { makeStyles, ToggleButtonGroup } from '@mui/material';
import { ToggleButton } from '@mui/material';
import CarFilterUtil from '../../../util/CarFilterUtil';
import { ICar } from '../../../models/cars';


export default function FilterToggle() {
    const [carType, setCarType] = useState<string[]>(['Berline','VUS'])
  
    const handleChange = (
    _event: React.MouseEvent<HTMLElement>,
      newCarType: string[]
    ) => {
        let cars: ICar[] = CarFilterUtil.getAll();
        let listToAdd: number[] = [];
        for ( let i = 0; i < cars.length; i++) {
            for ( let j = 0; j < newCarType.length; j++) {
                if ( cars[i].type == newCarType[j]) {
                    let find = listToAdd.indexOf(i);
                    if(find < 0) {
                        listToAdd.push(i);
                    }
                } 
            }
        }
        for(let k = 0; k < CarFilterUtil.getAll().length; k++) {
            let find = listToAdd.indexOf(k);
            if (find >= 0) {
                CarFilterUtil.addValueToInclude(k,"type");
            } else if (find < 0) {
                CarFilterUtil.removeValueFromInclude(k,"type");
            }
        }
        setCarType(newCarType);
  };
  
  return (
    <ToggleButtonGroup
      color="success"
      value={carType}
      onChange={handleChange}
      aria-label="car type"
      size='large'
      >
        <ToggleButton value="Berline" aria-label='Berline'>Berline</ToggleButton>
        <ToggleButton value="VUS" aria-label='VUS'>VUS</ToggleButton>
        
      </ToggleButtonGroup>
  
  
  );
  
}