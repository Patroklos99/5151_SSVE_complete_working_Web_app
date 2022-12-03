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
      for ( let i = 0; i < cars.length; i++) {
        for ( let j = 0; j < newCarType.length; j++)


          if ( cars[i].type == newCarType[j]) {
              CarFilterUtil.addValueToInclude(i);
          } else {
              CarFilterUtil.removeValueFromInclude(i);
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