import React from "react";
import {Container, Grid} from '@mui/material';
import ResultsList from './resultsList';
import FilterPanel from "./filterPanel";
import CarService from "../../services/CarService"

const Dashboard = () => {
    CarService.fillPartialInclude();

    return (
        <Container maxWidth="xl">
            <h1>Dashboard</h1>
            <Grid container spacing={2}>
                <Grid item xs={4}>
                    <h1>Formulaire de deplacement</h1>
                    <FilterPanel/>
                </Grid>     
                <Grid item xs={8}>
                    <ResultsList/>
                </Grid>
            </Grid>
       
        
        </Container>
    );
};

export default Dashboard;