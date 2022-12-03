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
    for ( let i = 0; i < cars.length; i++) {
      for ( let j = 0; j < newCarDoorNum.length; j++)


        if ( cars[i].nbPortes == newCarDoorNum[j]) {
            CarFilterUtil.addValueToInclude(i);
        } else {
            CarFilterUtil.removeValueFromInclude(i);
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





    

