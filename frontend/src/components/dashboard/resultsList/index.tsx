import { Button, Divider, FormControl, FormControlLabel, FormLabel, List, Popover, Radio, RadioGroup, Typography } from '@mui/material';
import React, { useEffect } from 'react';
import {carsData} from '../../../assets/data_exemples/cars';
import { ICar } from '../../../models/cars';
import ListItemCar from './listItemCar';

import './style.css';

const ResultsList = () => {
    const [cars, setCars] = React.useState<ICar[]>([]);
    const [orderByAnchorEl, setOrderByAnchorEl] = React.useState<HTMLButtonElement | null>(null);


    useEffect(() => {
        //shoud load data from BE, but use local data for now
        setCars(carsData);
    }, []);


    const handleOrderByClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setOrderByAnchorEl(event.currentTarget);
    };

    const handleOrderByClose = () => {
        setOrderByAnchorEl(null);
    };

    const getCarsList = () => cars.map((car: ICar, index: number) => ListItemCar(car, index));

    const openOrderBy = Boolean(orderByAnchorEl);

    const handleOrderByChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const orderBy = (event.target as HTMLInputElement).value;
        switch (orderBy) {
            case 'priceAsc':
                setCars([...cars.sort((a, b) => a.prix - b.prix)]);
                break;
            case 'priceDesc':
                setCars([...cars.sort((a, b) => b.prix - a.prix)]);
                break;
            case 'scoreAsc':
                setCars([...cars.sort((a, b) => a.score - b.score)]);
                break;
            

        }
    }

    const orderByChoices = (
        <FormControl style={{margin: '10px'}}>
            <FormLabel id="demo-radio-buttons-group-label" >Ordre des résultats</FormLabel>
            <RadioGroup
                aria-labelledby="demo-radio-buttons-group-label"
                defaultValue="score"
                name="radio-buttons-group"
                onChange={handleOrderByChange}
            >
                <FormControlLabel value="score" control={<Radio />} label="Score" />
                <FormControlLabel value="priceAsc" control={<Radio />} label="Prix Ascendant" />
                <FormControlLabel value="priceDesc" control={<Radio />} label="Prix Descendant" />
            </RadioGroup>
        </FormControl>
    )
    
    return (
        <div className='results-list'>
            <div className='header-container'>
                <div className='header'>
                    <h2>Résultats</h2>
                    <Button variant="outlined" onClick={handleOrderByClick}>Changer l'ordre</Button>
                    <Popover
                        id={openOrderBy ? 'simple-popover' : undefined}
                        open={openOrderBy}
                        anchorEl={orderByAnchorEl}
                        onClose={handleOrderByClose}
                        anchorOrigin={{
                            vertical: 'bottom',
                            horizontal: 'left',
                        }}
                    >
                        {orderByChoices}
                    </Popover>
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