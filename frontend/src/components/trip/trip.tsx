import React, { useState, useEffect } from 'react';
import { ScriptTarget } from 'typescript';
import './trip.css'
import TripData from "../../types/trip";
import TripService from '../../services/tripServices';
import TripNeeds from '../../types/tripNeeds';
import { FormControl, IconButton, NativeSelect, Select, Table, TableCell, TableRow, TextField } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';

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
    trips: []
  };

  const [trip, setTrip] = useState<TripData>(tripState);
  const [submitted, setSubmitted] = useState<boolean>(false);
  const [TripList, setTripList] = useState<TripData[]>([]);
  const [tripNeeds, setTripNeeds] = useState<TripNeeds>(tripNeedsState);

  const submitForm = () => {

    if (TripList.length > 0) {
      const label = document.getElementById('submitted') as HTMLLabelElement;

      var dataTripNeeds = {
        id: null,
        trips: tripNeeds.trips
      };

      TripService.postTripNeeds(dataTripNeeds)
        .then((response: any) => {
          setTripNeeds({
            id: response.id,
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
    const name = document.getElementById('name') as HTMLInputElement
    const start = document.getElementById('search1') as HTMLInputElement
    const end = document.getElementById('search2') as HTMLInputElement
    const freqNb = document.getElementById('freqNb') as HTMLInputElement
    const freq = document.getElementById('frequences') as HTMLInputElement

    const vName = name?.value;
    const vStart = start?.value;
    const vEnd = end?.value;
    const vFreqNb = freqNb?.value;
    const vFreq = freq?.value;

    if (vName != null && vName != "" &&
      vStart != null && vStart != "" &&
      vEnd != null && vEnd != "" &&
      vFreqNb != null && vFreqNb != "" &&
      vFreq != null && vFreq != "") {

      var data = {
        id: null,
        name: vName,
        start_point: vStart,
        end_point: vEnd,
        freq: vFreqNb + "\\" + vFreq,
      };
      setTripList([...TripList, data])
      setTripNeeds({ ...tripNeeds, trips: [...tripNeeds.trips, data] });
    }

  }

  const handleTripRemove = (index: number) => {
    const list = [...TripList]
    list.splice(index, 1)
    setTripList(list)
    setTripNeeds({ ...tripNeeds, trips: [...list] });
  }
  return (
    <div>
       <FormControl variant="filled">
        <label id="textsup">Nom du trajet</label>
        <TextField
          id="name"
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

        <Table size="small">
          <TableRow>
            <TableCell>
              Je fais ce trajet
            </TableCell>
            <TableCell>
              <TextField
                type="number"
                id='freqNb'
                placeholder="Fréquence"
                required
                sx={{ boxShadow: 5, width: 150 }} />
            </TableCell>
            <TableCell>
              fois par
            </TableCell>
            <TableCell>
              <NativeSelect id="frequences" required>
                <option value="Jour">Jour</option>
                <option value="Semaine">Semaine</option>
                <option value="Mois">Mois</option>
                <option value="Année">Année</option>
              </NativeSelect>
            </TableCell>
          </TableRow>
        </Table>
        <button onClick={() => handleTripAdd()} type={"submit"}>Ajouter trajet</button>
        <div>
          {TripList.map((trip, index) => (
            <div>
              <Table size="small">
                <TableRow >
                  <div>
                    <TableCell sx={{ width: "100%" }}>{trip.name}</TableCell>
                    <TableCell >
                      <IconButton aria-label="delete">
                        <DeleteIcon
                          onClick={() => handleTripRemove(index)} />
                      </IconButton>

                    </TableCell>
                  </div>
                </TableRow>
              </Table>
            </div>
          ))
          }
        </div >
        < button onClick={() => submitForm()} type={"submit"} >Soumettre</button >
        <label id='submitted'>NON-SOUMIS</label>
      </FormControl >
    </div >
  );
};

export default Trip;