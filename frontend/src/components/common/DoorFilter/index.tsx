import React from 'react';
import { ClassNames } from '@emotion/react';
import { ToggleButtonGroup } from '@mui/material';
import { ToggleButton } from '@mui/material';



export default function DoorFilter() {
    const [nbDoors, setNbDoors] = React.useState(() => ['2','4']);
  
  
    const handleChange = (
      event: React.MouseEvent<HTMLElement>,
      newCarDoors: string[],
    ) => {
      setNbDoors(newCarDoors);
  };
  
  return (
    <ToggleButtonGroup
      color="primary"
      value={nbDoors}
      onChange={handleChange}
      aria-label="number of doors"
      >
        <ToggleButton value="2">2</ToggleButton>
        <ToggleButton value="4">4</ToggleButton>
        
      </ToggleButtonGroup>
  
  );
  
  }