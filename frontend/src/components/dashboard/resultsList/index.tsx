import { Button, Divider, FormControl, FormControlLabel, FormLabel, List, Popover, Radio, RadioGroup} from '@mui/material';
import React, { useEffect, useState } from 'react';
import CarServices from '../../../services/CarServices';
import ICar from '../../../types/Car';

import ListItemCar from './listItemCar';

import './style.css';


const ResultsList = () => {
    const [orderByAnchorEl, setOrderByAnchorEl] = React.useState<HTMLButtonElement | null>(null);
    const [orderBy, setOrderBy] = useState<string>('score');
    const [carsList, setCarsList] = useState<ICar[]>([]);

    useEffect(() => {
        const getCars = async()=> {
            const data = await CarServices.getAllCars();
            setCarsList([...data.sort((a: ICar, b: ICar) => b.score - a.score)]);
        }
        getCars();
      }, []);


    const handleOrderByClick = (event: React.MouseEvent<HTMLButtonElement>) => {
        setOrderByAnchorEl(event.currentTarget);
    };

    const handleOrderByClose = () => {
        setOrderByAnchorEl(null);
    };

    const getCarsList = () => carsList.map((car: ICar, index: number) => ListItemCar(car, index));

    const openOrderBy = Boolean(orderByAnchorEl);

    const handleOrderByChange = (event: React.ChangeEvent<HTMLInputElement>) => {
        const orderBy = (event.target as HTMLInputElement).value;
        switch (orderBy) {
            case 'priceAsc':
                setCarsList([...carsList.sort((a, b) => a.price - b.price)]);
                
                break;
            case 'priceDesc':
                setCarsList([...carsList.sort((a, b) => b.price - a.price)]);
                break;
            case 'score':
                setCarsList([...carsList.sort((a, b) => b.score - a.score)]);
                break;
            
        }
        setOrderBy(orderBy);
    }

    const orderByChoices = (
        <FormControl style={{margin: '10px'}}>
            <FormLabel id="demo-radio-buttons-group-label" >Ordre des résultats</FormLabel>
            <RadioGroup
                aria-labelledby="demo-radio-buttons-group-label"
                defaultValue="score"
                name="radio-buttons-group"
                onChange={handleOrderByChange}
                value={orderBy}
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
