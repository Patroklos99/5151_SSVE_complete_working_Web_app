import React, { useState } from 'react';
import Box from '@mui/material/Box';
import { Typography } from '@mui/material';
import Slider from '@mui/material/Slider';
import CarFilterUtil from '../../../util/CarFilterUtil';
import { ICar } from '../../../models/cars';



const marks = [

    {
        value:0,
        label:'0',
    },

    {
        value:25,
        label:'25',
    },

    {
        value:50,
        label:'50',
    },

    {
        value:75,
        label:'75',
    },


    {
        value:100,
        label:'100',
    },

];

function valueText(value: number) {
    return `{value}`;
}


export default function SliderScore(props: { minValue: number | undefined; maxValue: number | undefined; }) : any{

    const [score, setScore] = useState();

    const filterSlider = (event: any, value: any) => {

        let cars: ICar[] = CarFilterUtil.getAll();
        for ( let i = 0; i < cars.length; i++) {
            if ( cars[i].score <= value) {
                CarFilterUtil.addValueToInclude(i,"score");
            } else {
                CarFilterUtil.removeValueFromInclude(i,"score");
            }
        }
        setScore(value.target.valueAsNumber)
    };




    return (
        <div className='scoreSlider'>
            <Box sx={{ width: 400}}>
                <Slider
                    min={0}
                    max={100}
                    value={score}
                    aria-label="score slider"
                    onChange={filterSlider}
                    getAriaValueText={valueText}
                    valueLabelDisplay="on"
                    aria-labelledby="non-linear-slider"
                    step={5}
                    marks={marks} 
                />
            </Box>
        </div>
    )
}


