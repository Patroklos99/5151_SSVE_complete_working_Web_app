import React, { useState, useEffect } from "react";
import "./trip.css";
import TripData from "../../types/trip";
import TripService from "../../services/tripServices";
import TripNeeds from "../../types/tripNeeds";
import {
  Button,
  Divider,
  FormControl,
  IconButton,
  NativeSelect,
  Table,
  TableBody,
  TableCell,
  TableRow,
  TextField,
} from "@mui/material";
import { Add } from "@mui/icons-material";
import DeleteIcon from "@mui/icons-material/Delete";
import GeoPoint from "../../types/geoPoint";

const Trip: React.FC = () => {
  const tripNeedsState = {
    trips: [],
  };

<<<<<<< HEAD
  const [submitted, setSubmitted] = useState<boolean>(false);
  const [TripList, setTripList] = useState<TripData[]>([]);
  const [tripNeeds, setTripNeeds] = useState<TripNeeds>(tripNeedsState);
  const [GeoPointList, setGeoPointList] = useState<GeoPoint[]>([]);

  const submitForm = () => {
    if (TripList.length > 0) {
      const label = document.getElementById("submitted") as HTMLLabelElement;

      var dataTripNeeds = {
        id: null,
        trips: tripNeeds.trips,
      };

      TripService.postTripNeeds(dataTripNeeds)
        .then((response: any) => {
          setTripNeeds({
            trips: response.trips,
          });
          setSubmitted(true);
          label.innerHTML = "Soumis!";
        })
        .catch((e: Error) => {
          console.log(e);
        });
    }
  };

  useEffect(() => {
    const script = document.createElement("script");
    script.src = "trip.js";
    script.async = true;
    document.body.appendChild(script);
    return () => {
      document.body.removeChild(script);
    };
  }, []);

  const handleGeoPointAdd = () => {
    const stop = document.getElementById("search") as HTMLInputElement;

    const vStops = stop?.value;

    if (vStops !== null && vStops !== "") {
      var splitStop = vStops.split("\\");

      var geoPointStop: GeoPoint = {
        name: splitStop[0],
        lat: +splitStop[1],
        lgt: +splitStop[2],
      };

      setGeoPointList([...GeoPointList, geoPointStop]);
    }
  };
=======
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
          setSubmitted(true);
          console.log(response.data);
          label.innerHTML = "Soumis!";
        })
        .catch((e: Error) => {
          console.log(e);
        });
    }
    };
>>>>>>> bc55af5fba5e09c36f257f61f697f64a9f0ca97f

  const handleGeoPointRemove = (index: number) => {
    const list = [...GeoPointList];
    list.splice(index, 1);
    setGeoPointList(list);
  };

  const handleTripAdd = () => {
    const name = document.getElementById("name") as HTMLInputElement;
    const stop = GeoPointList;
    const freqNb = document.getElementById("freqNb") as HTMLInputElement;
    const freq = document.getElementById("frequences") as HTMLInputElement;

    const vName = name?.value;
    const vStops = stop;
    const vFreqNb = freqNb?.value;
    const vFreq = freq?.value;

    if (
      vName !== null &&
      vName !== "" &&
      vStops !== null &&
      vFreqNb !== null &&
      vFreqNb !== "" &&
      vFreq !== null &&
      vFreq !== ""
    ) {
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
        stops: vStops,
        annualFreq: cal,
      };

      setTripList([...TripList, data]);
      setTripNeeds({ ...tripNeeds, trips: [...tripNeeds.trips, data] });
    }
    name.value = "";
    setGeoPointList([]);
    freqNb.value = "";
  };

  const handleTripRemove = (index: number) => {
    const list = [...TripList];
    list.splice(index, 1);
    setTripList(list);
    setTripNeeds({ ...tripNeeds, trips: [...list] });
  };

  return (
    <div className="trip-form">
      <div className="header-container">
        <div className="header">
          <h2>Entrer les trajets</h2>
        </div>
        <Divider variant="inset" />
      </div>
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
        <input id="search" type={"text"} required hidden />
        <div id="result" hidden></div>

        <Button variant="outlined" onClick={handleGeoPointAdd}>
          <Add /> Ajouter une destination
        </Button>
        <div>
          {GeoPointList.map((geoPoint, index) => (
            <div>
              <Table size="small">
                <TableBody>
                  <TableRow>
                    <div>
                      <TableCell sx={{ width: "100%" }}>
                        {geoPoint.name}
                      </TableCell>
                      <TableCell>
                        <IconButton aria-label="delete">
                          <DeleteIcon
                            onClick={() => handleGeoPointRemove(index)}
                          />
                        </IconButton>
                      </TableCell>
                    </div>
                  </TableRow>
                </TableBody>
              </Table>
            </div>
          ))}
        </div>

        <Table size="small">
          <TableBody>
            <TableRow>
              <TableCell>Je fais ce trajet</TableCell>
              <TableCell>
                <TextField
                  type="number"
                  id="freqNb"
                  placeholder="Fréquence"
                  required
                  sx={{ boxShadow: 5, width: 150 }}
                />
              </TableCell>
              <TableCell>fois par</TableCell>
              <TableCell>
                <NativeSelect id="frequences" required>
                  <option value="Jour">Jour</option>
                  <option value="Semaine">Semaine</option>
                  <option value="Mois">Mois</option>
                  <option value="Année">Année</option>
                </NativeSelect>
              </TableCell>
            </TableRow>
          </TableBody>
        </Table>
        <Button
          variant="outlined"
          onClick={() => handleTripAdd()}
          type={"submit"}
        >
          <Add /> Ajouter un trajet
        </Button>
        <div>
          {TripList.map((trip, index) => (
            <div>
              <Table size="small">
                <TableBody>
                  <TableRow>
                    <div>
                      <TableCell sx={{ width: "100%" }}>{trip.name}</TableCell>
                      <TableCell>
                        <IconButton aria-label="delete">
                          <DeleteIcon onClick={() => handleTripRemove(index)} />
                        </IconButton>
                      </TableCell>
                    </div>
                  </TableRow>
                </TableBody>
              </Table>
            </div>
          ))}
        </div>
        <Button variant="outlined" onClick={() => submitForm()} type={"submit"}>
          Soumettre
        </Button>
        <label id="submitted">NON-SOUMIS</label>
      </FormControl>
    </div>
  );
};

export default Trip;
