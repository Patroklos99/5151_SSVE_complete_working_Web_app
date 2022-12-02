import React from "react";
import {  Container, Grid} from '@mui/material';
import ResultsList from './resultsList';
import ResultDetails from "./resultDetails";
import ICar from "../../types/Car";

const Dashboard = () => {
    //used to switch between search and results
    const [dashboardStatus, setDashboardStatus] = React.useState<string>('search');
    const [selectedCar, setSelectedCar] = React.useState<ICar | null>(null);

    const handleResultClick = (result: ICar) => {
        setSelectedCar(result);
        setDashboardStatus('results');
    }
    return (
        <Container maxWidth="xl">
            <h1 hidden>Dashboard</h1>
            <Grid container spacing={2}>
                {dashboardStatus === 'search' &&
                    <Grid item xs={4}>
                        {/*To do: input pannel*/}
                    </Grid>
                }
                <Grid item xs={dashboardStatus === 'search' ? 8 : 4}>
                    <ResultsList handleResultClick = {handleResultClick}/>
                </Grid>
                {dashboardStatus === 'results' && selectedCar &&
                    <Grid item xs={8}>
                        <ResultDetails car={selectedCar}/>
                    </Grid>
                }
                
            </Grid>
       
        
        </Container>
    );
};

export default Dashboard;