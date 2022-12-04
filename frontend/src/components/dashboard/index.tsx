import React from "react";
import {  Container, Grid} from '@mui/material';
import ResultsList from './resultsList';
import Trip from "../trip/trip"

const Dashboard = () => {
    
    return (
        <Container maxWidth="xl">
            <h1>Dashboard</h1>
            <Grid container spacing={2}>
                <Grid item xs={4}>
                    <Trip/>
                </Grid>
                <Grid item xs={8}>
                    <ResultsList/>
                </Grid>
            </Grid>
        </Container>
    );
};

export default Dashboard;