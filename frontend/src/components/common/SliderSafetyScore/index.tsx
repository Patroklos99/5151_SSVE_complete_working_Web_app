import React, { useState } from 'react';
import Box from '@mui/material/Box';
import { Typography } from '@mui/material';
import Slider from '@mui/material/Slider';
import CarFilterUtil from '../../../util/CarFilterUtil';
import { ICar } from '../../../models/cars';
import { green } from '@mui/material/colors';
import { createTheme, ThemeProvider } from '@mui/material/styles'


const theme = createTheme({
    palette : {
        primary: {
            main: green[700],

        },
    },
});

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


export default function SliderSafetyScore(props: { minValue: number | undefined; maxValue: number | undefined; }) : any{

    const [scoreSecurite, setScoreSecurite] = useState()

    const filterSlider = (event: any, value: any) => {

        let cars: ICar[] = CarFilterUtil.getAll();
        for ( let i = 0; i < cars.length; i++) {
            if ( cars[i].scoreSecurite <= value) {
                CarFilterUtil.addValueToInclude(i,"safety");
            } else {
                CarFilterUtil.removeValueFromInclude(i,"safety");
            }
        }
        setScoreSecurite(value.target.valueAsNumber)
    };




    return (
        <div >
            <Box sx={{ width: 4/5}}>
            <ThemeProvider theme={theme}>
                <Slider
                    className='scoreSecuriteSlider'
                    min={0}
                    max={100}
                    value={scoreSecurite}
                    aria-label="score security slider"
                    onChange={filterSlider}
                    getAriaValueText={valueText}
                    valueLabelDisplay="on"
                    aria-labelledby="non-linear-slider"
                    step={5}
                    marks={marks} 
                    color='primary'
                />
            </ThemeProvider>
            </Box>
        </div>
    )
}


