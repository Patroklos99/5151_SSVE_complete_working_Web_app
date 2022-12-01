import React, { useState, useEffect } from 'react';
import { ScriptTarget } from 'typescript';
import './trip.css'
import TripData from "../../types/trip";
import TripService from '../../services/tripServices';
import TripNeeds from '../../types/tripNeeds';
import { Button, FormControl, IconButton, NativeSelect, Select, Table, TableCell, TableRow, TextField } from '@mui/material';
import {Add} from "@mui/icons-material";
import DeleteIcon from '@mui/icons-material/Delete';
import { v4 as uuidv4 } from 'uuid';
import GeoPoint from '../../types/geoPoint';

const Trip: React.FC = () => {
  
    const tripNeedsState = {
      trips: []
    };
  
    const [submitted, setSubmitted] = useState<boolean>(false);
    const [TripList, setTripList] = useState<TripData[]>([]);
    const [tripNeeds, setTripNeeds] = useState<TripNeeds>(tripNeedsState);
    const [GeoPointList, setGeoPointList] = useState<GeoPoint[]>([]);

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

  useEffect(() => {
    const script = document.createElement('script');
    script.src = "trip.js";
    script.async = true;
    document.body.appendChild(script);
    return () => {
      document.body.removeChild(script);
    }
  }, []);

  const handleGeoPointAdd = () => {
    const start = document.getElementById('search1') as HTMLInputElement

    const vStart = start?.value;

    if (vStart !== null && vStart !== "") {

        var cal: number = 0;

      var splitStart = vStart.split("\\");

      var geoPointStart: GeoPoint =  {
        name : splitStart[0],
        lat : +splitStart[1],
        lgt : +splitStart[2],
      };
      
      setGeoPointList([...GeoPointList, geoPointStart]);
    }

  }  

  const handleGeoPointRemove = (index: number) => {
    const list = [...GeoPointList]
    list.splice(index, 1)
    setGeoPointList(list)
  }
  

  const handleTripAdd = () => {
    const name = document.getElementById('name') as HTMLInputElement
    // const start = document.getElementById('search1') as HTMLInputElement
    const start = GeoPointList;
    const freqNb = document.getElementById('freqNb') as HTMLInputElement
    const freq = document.getElementById('frequences') as HTMLInputElement

    const vName = name?.value;
    const vStart = start;
    const vFreqNb = freqNb?.value;
    const vFreq = freq?.value;

    if (vName !== null && vName !== "" &&
      vStart !== null &&
      vFreqNb !== null && vFreqNb !== "" &&
      vFreq !== null && vFreq !== "") {

        var cal: number = 0;

        if (vFreq === "Jour") {
          cal = +vFreqNb * 365;
        } else if (vFreq === "Semaine") {
          cal = +vFreqNb * 52;
        } else if (vFreq === "Mois") {
          cal = +vFreqNb * 12;
        } else if (vFreq === "Année") {
          cal = +vFreqNb * 1;
        }
      

      var data = {
        name: vName,
        stops: vStart,
        annualFreq: cal,
      };
      console.log(data);

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
        <br />
        <label id="textsup">Arrêt</label>

        <div id="search-box"></div>
        <input id='search1' type={"text"} required hidden />
        <div id="result" hidden></div>

           <Button variant="outlined" onClick={handleGeoPointAdd}>
               <Add /> Ajouter une destination
           </Button>
           <div>
          {GeoPointList.map((geoPoint, index) => (
            <div>
              <Table size="small">
                <TableRow >
                  <div>
                    <TableCell sx={{ width: "100%" }}>{geoPoint.name}</TableCell>
                    <TableCell >
                      <IconButton aria-label="delete">
                        <DeleteIcon
                          onClick={() => handleGeoPointRemove(index)} />
                      </IconButton>

                    </TableCell>
                  </div>
                </TableRow>
              </Table>
            </div>
          ))
          }
        </div >

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
        <Button variant="outlined" onClick={() => handleTripAdd()} type={"submit"}>Ajouter trajet</Button>
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
        < Button variant="outlined" onClick={() => submitForm()} type={"submit"} >Soumettre</Button >
        <label id='submitted'>NON-SOUMIS</label>
      </FormControl >
    </div >
  );
};

export default Trip;