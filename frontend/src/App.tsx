import React from 'react';
import { Routes, Route } from "react-router-dom";
import './App.css';

import logo from "./assets/onlycars_old.png";
import Trip from "./components/trip/trip"
import MakeResearch from "./components/makeResearch/makeResearch";


function App() {
  return (
    <div className="App">
      <div className="App-header">
      </div>

      <div className={"App-body"}>
        <Routes>
          <Route path="/researchMan" element={<Trip />} />
          <Route path="/" element={<MakeResearch />} />
        </Routes>
      </div>

    </div>

  );
}

export default App;
