import React from 'react';
import CheckboxComp from '../../common/CheckboxComp';
import DoorFilter from '../../common/DoorFilter';
import DropDownSelect from '../../common/DropDownSelect';
import FilterToggle from '../../common/FilterToggle';
import SliderComp from '../../common/SliderComp';
import Typography from '@mui/material/Typography';
import { Paper } from "@mui/material";
import "./style.css";
import SliderSafetyScore from '../../common/SliderSafetyScore';
import SliderScore from '../../common/SliderScore';

const FilterPanel = ({
    

}) => (
       <Paper elevation={10}>
        <div className="filters">
            <h1><em>Filtres</em></h1>

            <div className="input-group">
                <Typography id="non-linear-slider" gutterBottom>
                    Type de voiture
                </Typography>
                <FilterToggle/>
            </div>

            <div className="input-group">
                <p className="label">Marque</p>
                <CheckboxComp/>
            </div>

            <div className="input-group">
                <p className="label">Modele</p>
                <DropDownSelect/>
                
            </div>

            <div className="input-group">
                <p className="label">Nombre de portes</p>
                <DoorFilter/>
                
            </div>

            <div className="input-group">
                <Typography id="non-linear-slider" gutterBottom>
                    Prix
                </Typography>
                <SliderComp minValue={undefined} maxValue={undefined} />
            </div>

            <div className="input-group">
                <Typography id="non-linear-slider" gutterBottom>
                    Score
                </Typography>
                <SliderScore minValue={undefined} maxValue={undefined} />
            </div>
                   
            <div className="input-group">
                <Typography id="non-linear-slider" gutterBottom>
                    Score de Securite
                </Typography>
                <SliderSafetyScore minValue={undefined} maxValue={undefined} />
            </div>

 

        </div>
        </Paper>
);


export default FilterPanel;