import { Divider, List } from '@mui/material';
import React, { useEffect } from 'react';
import {carsData} from '../../../assets/data_exemples/cars';
import { ICar } from '../../../models/cars';
import ListItemCar from './listItemCar';

import './style.css';

const ResultsList = () => {
    const [cars, setCars] = React.useState<ICar[]>([]);
    useEffect(() => {
        //shoud load data from BE, but use local data for now
        setCars(carsData);
    }, []);


    

    const getCarsList = () => {
        return cars.map((car: ICar, index: number) => {
            const divider = index < cars.length-1 ?<Divider variant="inset" component="li" /> :"";
            return(
                <div>
                    {ListItemCar(car, index)}
                    {divider}
                </div>
            )
        });
    }
    
    return (
        <div className='results-list'>
            <div className='header'>
                <h2>Résultats</h2>
                <Divider variant="inset" />
            </div>
            
            <List sx={{ width: '100%',  bgcolor: 'background.paper'}}>
                {getCarsList()}
            </List>
        </div>
        
    );
};

export default ResultsList;