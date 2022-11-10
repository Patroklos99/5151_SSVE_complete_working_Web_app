import React from 'react';
import { Routes, Route } from "react-router-dom";
import './App.css';

import logo from "./assets/onlycars_old.png";
import { Card } from "./components/example/example";
import AddCar from "./components/example2/example2";
import CarList from './components/example3/example3';
import UserData1 from "./components/userData1/userData1";

function App() {
  return (
    <div className="App">
      <div className="App-header">
        <Routes>
          <Route path="/exemple" element={<Card title="Titre exemple" paragraph='Ceci est un exemple' />} />
          <Route path="/add" element={<AddCar />} />
          <Route path="/get" element={<CarList />} />
          <Route path="/" element={<UserData1 />} />
        </Routes>
      </div>
    </div>

  );
}

export default App;
