import React from "react";
import {  Container, Grid} from '@mui/material';
import ResultsList from './resultsList';

const Dashboard = () => {
    
    return (
        <Container maxWidth="xl">
            <h1>Dashboard</h1>
            <Grid container spacing={2}>
                <Grid item xs={4}>
                    {/*To do: input pannel*/}
                </Grid>
                <Grid item xs={8}>
                    <ResultsList/>
                </Grid>
            </Grid>
       
        
        </Container>
    );
};

export default Dashboard;