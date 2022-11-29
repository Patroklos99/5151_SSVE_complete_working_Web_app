import LinearProgress, { LinearProgressProps } from '@mui/material/LinearProgress';
import Typography from '@mui/material/Typography';
import Box from '@mui/material/Box';
import React from "react"

export function LinearProgressWithLabel(props: LinearProgressProps & { value: number }) {
    //linear-gradient(90deg, #6fcbb6 ${100 - props.score}%, #9c64f4 100%)
    return (
      <Box sx={{ display: 'flex', alignItems: 'center' }}>
        <Box sx={{ width: '100%', mr: 1 }}>
          <LinearProgress variant="determinate" {...props} sx={{
            background:`linear-gradient(90deg, #B14E4E 0%, #FAD02C 50%, #3E9D73 100%)`,
            borderRadius: 2,
            height: '10px',
            '& .MuiLinearProgress-bar': 
                {background: `#95ABBC`, transform: `translateX(${props.value}%)!important`}
            }}/>
        </Box>
        <Box sx={{ minWidth: 35 }}>
          <Typography variant="body2" color="text.secondary">{`${Math.round(
            props.value,
          )}%`}</Typography>
        </Box>
      </Box>
    );
  }