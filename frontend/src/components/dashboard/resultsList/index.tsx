import { Avatar, Divider, List, ListItem, ListItemAvatar, ListItemText, Typography } from '@mui/material';
import React, { useEffect } from 'react';
import {carsData} from '../../../assets/data_exemples/cars';
import { ICar } from '../../../models/cars';

import './style.css';




const ResultsList = () => {
    const [cars, setCars] = React.useState<ICar[]>([]);
    useEffect(() => {
        //shoud load data from BE, but use local data for now
        setCars(carsData);
    }, []);

    const getCarsList = () => {
        return cars.map((car, index) => {
            const divider = index < cars.length-1 ?<Divider variant="inset" component="li" /> :"";

            return (
                <div>
                    <ListItem key={index} alignItems="flex-start">
                        <ListItemAvatar>
                            <Avatar alt="img" src={require(`../../../assets/images/${car.image}`)} />
                        </ListItemAvatar>
                        <ListItemText
                            primary={
                                <div className="primary">
                                    <div className='modele'>{car.modele}</div>
                                    <div className='prix'>{car.prix}$</div>
                                </div> 
                              }
                            secondary={car.marque}
                            color="black"
                        />
                    </ListItem>
                    {divider}
                </div>
            );
        });
    }
    
    return (
        <div className='results-list'>
            <div className='header'>
                <h2>Résultats</h2>
                <Divider variant="inset" />
            </div>
            
            <List sx={{ width: '100%',  bgcolor: 'background.paper' }}>
            {getCarsList()}
        </List>
        </div>
        
    );
};

export default ResultsList;