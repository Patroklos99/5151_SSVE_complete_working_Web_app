import { Divider, List, ListItem, ListItemText } from '@mui/material';
import React, { useEffect } from 'react';
import {carsData} from '../../assets/data_exemples/cars';
import { ICar } from '../../models/cars';



const Dashboard = () => {
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
                    <ListItem key={index}>
                        <ListItemText
                            primary={car.modele}
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
        <div>
        <h1>Dashboard</h1>
        <List sx={{ width: '100%',  bgcolor: 'background.paper' }}>
            {getCarsList()}
        </List>
        
        </div>
    );
};

export default Dashboard;