import { Button, Divider, List } from '@mui/material';
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


    

    const getCarsList = () => cars.map((car: ICar, index: number) => ListItemCar(car, index));

    
    return (
        <div className='results-list'>
            <div className='header'>
                <div>
                    <h2>Résultats</h2>
                    <Button variant="outlined">Changer l'ordre</Button>
                </div>
                
                <Divider variant="inset" />
                
            </div>
            
            <List sx={{ width: '100%',  bgcolor: 'background.paper'}}>
                {getCarsList()}
            </List>
        </div>
        
    );
};

export default ResultsList;