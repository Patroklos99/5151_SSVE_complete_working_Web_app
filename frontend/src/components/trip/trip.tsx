import React, { useEffect } from 'react';
import { ScriptTarget } from 'typescript';
import './trip.css'

const Trip: React.FC = (index) => {
  useEffect(() => {
    const script = document.createElement('script');
  
    script.src = "trip.js";
    script.async = true;
  
    document.body.appendChild(script);
  
    return () => {
      document.body.removeChild(script);
    }
  }, []);
  return ( 
    
    <div style={{
        "border": "2px solid blue"
    }}>
        <input type={"text"} placeholder={"Nom du trajet"}></input>
        <div id="map"></div>
        <div id="map2"></div>
        <div id="search-box"></div>
        <div id="result"></div>
        <div id="search-box2"></div>
        <div id="result2"></div>
        <input type={"text"} placeholder={"Fréquence"}></input>
    </div>
);
};

export default Trip;