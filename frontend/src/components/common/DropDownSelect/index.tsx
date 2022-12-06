// une partie du code provient du site mui.com/material-ui/reac-select et adapter pour le select des modeles

import * as React from 'react';
import { Theme, useTheme } from '@mui/material/styles';
import Box from '@mui/material/Box';
import OutlinedInput from '@mui/material/OutlinedInput';
import InputLabel from '@mui/material/InputLabel';
import MenuItem from '@mui/material/MenuItem';
import FormControl from '@mui/material/FormControl';
import Select, { SelectChangeEvent } from '@mui/material/Select';
import Chip from '@mui/material/Chip';
import CarFilterUtil from '../../../util/CarFilterUtil';
import ICar from '../../../types/Car';

const ITEM_HEIGHT = 36;
const ITEM_PADDING_TOP = 6;
const MenuProps = {
  PaperProps: {
    style: {
      maxHeight: ITEM_HEIGHT * 4 + ITEM_PADDING_TOP,
      width: 250,
    },
  },
};

const carModels = [
  'Cool',
  'Trop Cool',
  'Mega Cool',
  'Mega Trop Cool',
  
];

function getStyles(aModel: string, model: readonly string[], theme: Theme) {
  return {
    fontWeight:
      model.indexOf(aModel) === -1
        ? theme.typography.fontWeightRegular
        : theme.typography.fontWeightMedium,
  };
}

export default function DropDownSelect() {
  const theme = useTheme();
  const [model, setModel] = React.useState<string[]>([])

  const updateCarList = (newModel: any) => {
        if(newModel.length == 0) {
            for(let i = 0; i < CarFilterUtil.getAll().length; i++) {
                CarFilterUtil.addValueToInclude(i,"modele");
            }
        } else {
            let cars: ICar[] = CarFilterUtil.getAll();
            let listToAdd: number[] = []
            for ( let i = 0; i < cars.length; i++) {
            for ( let j = 0; j < newModel.length; j++)
                if ( cars[i].modelName == newModel[j]) {
                    let find = listToAdd.indexOf(i);
                    if(find < 0) {
                        listToAdd.push(i);
                    }
                } 
            }
            for(let k = 0; k < CarFilterUtil.getAll().length; k++) {
                let find = listToAdd.indexOf(k);
                if (find >= 0) {
                    CarFilterUtil.addValueToInclude(k,"modele");
                } else if (find < 0) {
                    CarFilterUtil.removeValueFromInclude(k,"modele");
                }
            }
        }
  }

  const handleChange = (event: SelectChangeEvent<typeof model>) => {
    const {
      target: { value },
    } = event;

    let newModel = typeof value === 'string' ? value.split(',') : value

    setModel(newModel);

    updateCarList(newModel);
      
  };

  return (
    <div>
      <FormControl sx={{ m: 1, width: 4/5 }}>
        <InputLabel id="models-label">Modele</InputLabel>
        <Select
          labelId="car-model-label"
          id="car-models"
          multiple
          value={model}
          onChange={handleChange}
          input={<OutlinedInput id="select-car-models" label="Model" />}
          renderValue={(selected) => (
            <Box sx={{ display: 'flex', flexWrap: 'wrap', gap: 0.5 }}>
              {selected.map((value) => (
                <Chip key={value} label={value} />
              ))}
            </Box>
          )}
          MenuProps={MenuProps}
        >
          {carModels.map((aModel) => (
            <MenuItem
              key={aModel}
              value={aModel}
              style={getStyles(aModel, model, theme)}
            >
              {aModel}
            </MenuItem>
          ))}
        </Select>
      </FormControl>
    </div>
  );
}
