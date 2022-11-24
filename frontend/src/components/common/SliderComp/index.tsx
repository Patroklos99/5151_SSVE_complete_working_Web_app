import React from 'react';
import Box from '@mui/material/Box';
import Slider from '@mui/material/Slider';

const marks = [

    {
        value:0,
        label:'0$',
    },

    {
        value:100,
        label:'200 000$',
    },

];

function valueText(value: number) {
    return `${value}`;
}


export default function SliderComp() {
    return (
        <div className='priceSlider'>
            <Box sx={{ width: 300}}>
                <Slider
                    aria-label="slider"
                    getAriaValueText={valueText}
                    valueLabelDisplay="on"
                    /*marks={marks} */
                />
            </Box>
        </div>
    )
}