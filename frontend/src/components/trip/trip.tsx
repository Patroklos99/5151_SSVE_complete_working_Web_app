import React, { useState, useEffect } from 'react';
import { ScriptTarget } from 'typescript';
import './trip.css'
import TripData from "../../types/trip2";
import TripService from '../../services/tripServices';
import TripNeeds from '../../types/tripNeeds';
import { FormControl, TextField } from '@mui/material';


const Trip: React.FC = () => {

  const tripState = {
    id: null,
    name: "",
    start_point: "",
    end_point: "",
    freq: "",
  };

  const tripNeedsState = {
    id: null,
    autonomy: 0,
    charge_time: 0,
    trips: []
  };

  const [trip, setTrip] = useState<TripData>(tripState);
  const [submitted, setSubmitted] = useState<boolean>(false);
  const [TripList, setTripList] = useState<TripData[]>([]);
  const [tripNeeds, setTripNeeds] = useState<TripNeeds>(tripNeedsState);

  const soumettre = () => {

    if (TripList.length > 0) {
      const label = document.getElementById('soumis') as HTMLLabelElement;
      const autonomy_input = document.getElementById('autonomy') as HTMLInputElement
      const charge_time_input = document.getElementById('charge_time') as HTMLInputElement

      let autonomy: number = +autonomy_input?.value;
      let charge_time: number = +charge_time_input?.value;

      var dataTripNeeds = {
        id: null,
        autonomy: autonomy, //PASSER VALEUR DE L'ELEMENT
        charge_time: charge_time, //PASSER VALEUR DE L'ELEMENT
        trips: tripNeeds.trips
      };

      TripService.postTripNeeds(dataTripNeeds)
        .then((response: any) => {
          setTripNeeds({
            id: response.id,
            autonomy: response.autonomy,
            charge_time: response.charge_time,
            trips: response.trips
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

  const getData = () => {
    TripService.getTrip(1)
      .then((response: any) => {
        setTripNeeds(response.data);
        console.log(response.data);
      })
      .catch((e: Error) => {
        console.log(e);
      });
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
      setTripNeeds({ ...tripNeeds, trips: [...tripNeeds.trips, data] });
    }

  }

  const handleTripRemove = (index: number) => {
    const list = [...TripList]
    list.splice(index, 1)
    setTripList(list)
  }
  return (
    <div>
      <FormControl variant="filled">
        <label id="textsup">Automie souhaitée pour le véhicule (km)</label>
        <TextField
          id="autonomy"
          type="number"
          placeholder={"Automomie"}
          required
          sx={{ boxShadow: 5 }}
        />
        <br />
        <label id="textsup">Temps de recharge souhaité (min)</label>
        <TextField
          id="charge_time"
          type="number"
          placeholder={"Temps de recharge"}
          required
          sx={{ boxShadow: 5 }}
        />
        <br />
        <label id="textsup">Nom du trajet</label>
        <TextField
          id="nom"
          type="text"
          placeholder={"Nom du trajet"}
          required
          sx={{ boxShadow: 5 }}
        />
        <div id="map"></div>
        <div id="map2"></div>
        <br />
        <label id="textsup">Adresse de début du trajet</label>

        <div id="search-box"></div>
        <input id='search1' type={"text"} required hidden />
        <div id="result" hidden></div>
        <label id="textsup">Adresse de la destination du trajet</label>

        <div id="search-box2"></div>
        <input id='search2' type={"text"} required hidden />
        <div id="result2" hidden></div>

        <label id="textsup">Je fais ce trajet </label>
        <TextField
          type="number"
          id='freq_nb'
          placeholder="Fréquence"
          required
          sx={{ boxShadow: 5 }} />
        <label id="textsup"> fois par </label>
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
      </FormControl>
    </div>
  );
};

export default Trip;