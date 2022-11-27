import React from 'react';
import { Routes, Route } from "react-router-dom";
import './App.css';

import logo from "./assets/onlycars_old.png";
import { Card } from "./components/example/example";
import AddCar from "./components/example2/example2";
import CarList from './components/example3/example3';
import FormNote from './components/example4/example4';

function App() {
  return (
    <div className="App">
      <div className="App-header">
        <img src={logo} className="App-logo" alt="logo" />

        <Routes>
          <Route path="/" element={<Card title="Titre exemple" paragraph='Ceci est un exemple'/>}/>
          <Route path="/add" element={<AddCar/>}/>
          <Route path="/get" element={<CarList/>}/>
          <Route path="/form_note" element={<FormNote/>}/>
        </Routes>
      </div>
    </div>
    
  );
}

export default App;
