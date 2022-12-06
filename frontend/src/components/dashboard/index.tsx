import React from "react";
import { Container, Grid } from "@mui/material";
import ResultsList from "./resultsList";
import ResultDetails from "./resultDetails";
import ICar from "../../types/Car";
import Trip from "../trip/trip";

const Dashboard = () => {
  //used to switch between search and results
  const [dashboardStatus, setDashboardStatus] =
    React.useState<string>("search");
  const [selectedCar, setSelectedCar] = React.useState<ICar | null>(null);
  const [evaluateRes, setEvaluateRes] = React.useState<ICar[]>([]);

  const handleResultClick = (result: ICar) => {
    setSelectedCar(result);
    setDashboardStatus("results");
  };
  const handleEvaluateRes = (res: any) => {
    setEvaluateRes(res.map((data:any)=> {
      return {...data.vehicle, score: data.score};
    }));
    
  };
  return (
    <Container maxWidth="xl">
      <h1 hidden>Dashboard</h1>
      <Grid container spacing={2}>
        {dashboardStatus === "search" && (
          <Grid item xs={4}>
            <Trip handleEvaluateRes={handleEvaluateRes}/>
          </Grid>
        )}
        <Grid item xs={dashboardStatus === "search" ? 8 : 4}>
          <ResultsList handleResultClick={handleResultClick} evaluateRes={evaluateRes}/>
        </Grid>
        {dashboardStatus === "results" && selectedCar && (
          <Grid item xs={8}>
            <ResultDetails car={selectedCar} />
          </Grid>
        )}
      </Grid>
    </Container>
  );
};

export default Dashboard;
