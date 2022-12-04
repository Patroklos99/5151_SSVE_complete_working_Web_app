import React, { useState } from 'react';
import { ClassNames } from '@emotion/react';
import { ToggleButtonGroup } from '@mui/material';
import { ToggleButton } from '@mui/material';
import CarFilterUtil from '../../../util/CarFilterUtil';
import { ICar } from '../../../models/cars';


  
export default function DoorFilter() {
  const [carDoorNum, setCarDoorNum] = useState<number[]>([2,3,4,5])


  const handleChange = (
  _event: React.MouseEvent<HTMLElement>,
    newCarDoorNum: number[]
  ) => {
    let cars: ICar[] = CarFilterUtil.getAll();
    let listToAdd: number[] = []
    for ( let i = 0; i < cars.length; i++) {
      for ( let j = 0; j < newCarDoorNum.length; j++)
        if ( cars[i].nbPortes == newCarDoorNum[j]) {
            let find = listToAdd.indexOf(i);
            if(find < 0) {
                listToAdd.push(i);
            }
        } 
    }
    for(let k = 0; k < CarFilterUtil.getAll().length; k++) {
        let find = listToAdd.indexOf(k);
        if (find >= 0) {
            CarFilterUtil.addValueToInclude(k);
        } else if (find < 0) {
            CarFilterUtil.removeValueFromInclude(k);
        }
    }

    setCarDoorNum(newCarDoorNum);
  };


  return (

      <ToggleButtonGroup
          color="success"
          value={carDoorNum}
          onChange={handleChange}
          aria-label="car type"
          size='large'
          >
            <ToggleButton value={2} aria-label='two doors'>2</ToggleButton>
            <ToggleButton value={3} aria-label='three doors'>3</ToggleButton>
            <ToggleButton value={4} aria-label='four dooors'>4</ToggleButton>
            <ToggleButton value={5} aria-label='five'>5</ToggleButton>
            
            
            
      </ToggleButtonGroup>

  );

}





    

