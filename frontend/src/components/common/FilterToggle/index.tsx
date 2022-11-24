import React from 'react';
import { ClassNames } from '@emotion/react';
import { makeStyles, ToggleButtonGroup } from '@mui/material';
import { ToggleButton } from '@mui/material';



export default function FilterToggle() {
    const [carType, setCarType] = React.useState(() => ['Berline','VUS']);
  
  
    const handleChange = (
      event: React.MouseEvent<HTMLElement>,
      newCarType: string[],
    ) => {
      setCarType(newCarType);
  };
  
  return (
    <ToggleButtonGroup
      color="primary"
      value={carType}
      onChange={handleChange}
      aria-label="car type"
      >
        <ToggleButton value="Berline">Berline</ToggleButton>
        <ToggleButton value="VUS">VUS</ToggleButton>
        
      </ToggleButtonGroup>
  
  
  
  
  
  );
  
  }