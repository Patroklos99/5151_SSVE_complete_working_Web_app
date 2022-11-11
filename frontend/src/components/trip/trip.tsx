import React, { useState, useEffect } from 'react';
import { ScriptTarget } from 'typescript';
import './trip.css'
import TripData from "../../types/trip2";
import TripService from '../../services/tripServices';


const Trip: React.FC = () => {

  const tripState = {
    name: "",
    start_point: "",
    end_point: "",
    freq: "",
  };

  const [Trip, setTrip] = useState<TripData>(tripState);
  const [submitted, setSubmitted] = useState<boolean>(false);


  const soumettre = () => {
    const nom = document.getElementById('nom') as HTMLInputElement
    const depart = document.getElementById('search1') as HTMLInputElement
    const arrive = document.getElementById('search2') as HTMLInputElement
    const freq_nb = document.getElementById('freq_nb') as HTMLInputElement
    const freq = document.getElementById('frequences') as HTMLInputElement

    const vNom = nom?.value;
    const vDepart = depart?.value;
    const vArrive = arrive?.value;
    const vFreq_nb = freq_nb?.value;
    const vFreq = freq?.value;

    if (vNom != null && vNom != "" &&
      vDepart != null && vDepart != "" &&
      vArrive != null && vArrive != "" &&
      vFreq_nb != null && vFreq_nb != "" &&
      vFreq != null && vFreq != "") {

      const data = {
        name: vNom,
        start_point: vArrive,
        end_point: vDepart,
        freq: vFreq_nb + "\\" + vFreq,
      }

      const label = document.getElementById('soumis') as HTMLLabelElement;

      TripService.postTrip(data)
        .then((response: any) => {
          setTrip({
            name: response.data.name,
            start_point: response.data.start,
            end_point: response.data.end,
            freq: response.data.frequency,
          });
          setSubmitted(true);
          console.log(response.data);
          label.innerHTML = "Soumis!";
        })
        .catch((e: Error) => {
          console.log(e);
        });

    }


  }

  useEffect(() => {
    const script = document.createElement('script');

    const index: Number = 0;
    script.src = "trip.js";
    script.async = true;
    //script.onload = function go() {
    // whatever(index);
    //}

    document.body.appendChild(script);

    return () => {
      document.body.removeChild(script);
    }
  }, []);
  return (

    <div style={{
      "border": "2px solid blue"
    }}>
      <form action=""></form>
      <label>Nom de votre trajet</label>
      <br />
      <input id='nom' type={"text"} placeholder={"Nom du trajet"} required></input>
      <br />
      <div id="map"></div>
      <div id="map2"></div>
      <label>Adresse de début du trajet</label>
      <br />
      <div id="search-box"></div>
      <input id='search1' type={"text"} required hidden />
      <div id="result" hidden></div>
      <label>Adresse de la destination du trajet</label>
      <br />
      <div id="search-box2"></div>
      <input id='search2' type={"text"} required hidden />
      <div id="result2" hidden></div>
      <label>Je fais ce trajet </label>
      <input id='freq_nb' type={"text"} placeholder={"Fréquence"} required></input>
      <label> fois par </label>
      <select id="frequences" required>
        <option value="Jour">Jour</option>
        <option value="Semaine">Semaine</option>
        <option value="Mois">Mois</option>
        <option value="Année">Année</option>
      </select>
      <br></br>
      <input onClick={() => soumettre()} type={"submit"} value={"Soumettre"} />
      <br />
      <label id='soumis'>NON-SOUMIS</label>
    </div>
  );
};

export default Trip;