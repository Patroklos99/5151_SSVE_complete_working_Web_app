import React from 'react';
import { Routes, Route } from "react-router-dom";
import './App.css';

import logo from "./assets/onlycars_old.png";
import { Card } from "./components/example/example";
import AddCar from "./components/example2/example2";
import CarList from './components/example3/example3';
import UserData1 from "./components/userData1/userData1";
import Trip from "./components/trip/trip"
import MakeResearch from "./components/makeResearch/makeResearch";
import Form from "./components/form/form";
import Timeline from "./components/timeline/timeline";


function App() {
  return (
    <div className="App">
      <div className="App-header">
      </div>

      <div className={"App-body"}>
        <Routes>
          <Route path="/exemple" element={<Card title="Titre exemple" paragraph='Ceci est un exemple' />} />
          <Route path="/add" element={<AddCar />} />
          <Route path="/get" element={<CarList />} />
          <Route path="/user" element={<UserData1 />} />
          <Route path="/researchMan" element={<Trip />} />
          <Route path="/" element={<MakeResearch />} />
          <Route path="/timeline" element={<Timeline />} />
        </Routes>
      </div>

    </div>

  );
}

export default App;
