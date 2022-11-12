import React, { useState, useEffect } from 'react';
import { ScriptTarget } from 'typescript';
import './trip.css'
import TripData from "../../types/trip2";
import TripService from '../../services/tripServices';


const Trip: React.FC = () => {

  const tripState = {
    id: null,
    name: "",
    start_point: "",
    end_point: "",
    freq: "",
  };

  const listState = {
    id: null,
    name: "",
    start_point: "",
    end_point: "",
    freq: "",
  };

  const [Trip, setTrip] = useState<TripData>(tripState);
  const [submitted, setSubmitted] = useState<boolean>(false);
  const [TripList, setTripList] = useState<TripData[]>([]);

  const soumettre = () => {

    if (TripList.length > 0) {
      const label = document.getElementById('soumis') as HTMLLabelElement;
      TripList.map(trip => {
        var data = {
          name: trip.name,
          start_point: trip.start_point,
          end_point: trip.end_point,
          freq: trip.freq
        };
        TripService.postTrip(trip)
        .then((response: any) => {
          setTrip({
            id: response.data.id,
            name: response.data.name,
            start_point: response.data.start_point,
            end_point: response.data.end_point,
            freq: response.data.freq,
          });
          setSubmitted(true);
          console.log(response.data);
        })
        .catch((e: Error) => {
          console.log(e);
        });
      })
      label.innerHTML = "Soumis!";
    }
  }

  useEffect(() => {
    const script = document.createElement('script');
    script.src = "trip.js";
    script.async = true;
    document.body.appendChild(script);
    return () => {
      document.body.removeChild(script);
    }
  }, []);

  const handleTripAdd = () => {
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

      var data = {
        id: null,
        name: vNom,
        start_point: vArrive,
        end_point: vDepart,
        freq: vFreq_nb + "\\" + vFreq,
      };
      setTripList([...TripList, data])
    }

  }

  const handleTripRemove = (index: number) => {
    const list = [...TripList]
    list.splice(index, 1)
    setTripList(list)
  }
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
      <input onClick={() => handleTripAdd()} type={"submit"} value={"Ajouter trajet"} />
      <br />
      <label id='soumis'>NON-SOUMIS</label>
      <div>
        {TripList.map((trip, index) => (
          <div style={{
            "border": "2px solid red"
          }}>
            <label >{trip.name}  </label>
            <button onClick={() => handleTripRemove(index)}>Retirer</button>
            <br></br>
          </div>
        ))}
      </div>
      <input onClick={() => soumettre()} type={"submit"} value={"Soumettre"} />
    </div>
  );
};

export default Trip;