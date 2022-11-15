import React, { useState, ChangeEvent } from "react";
import Button from "@mui/material/Button";
import Select, { SelectChangeEvent } from "@mui/material/Select";
import MenuItem from "@mui/material/MenuItem";
import { FormControl } from "@mui/material";
import TextField from "@mui/material/TextField";

import TripData, { Frequency } from "../../types/trips/trips";
import TripServices from "../../services/tripServices";

const AddTrip: React.FC = () => {

    const initialTripState = {
        id: null,
        name: "",
        start: null,
        end: null,
        frequency: null,
    };

    const [Trip, setTrip] = useState<TripData>(initialTripState);
    const [submitted, setSubmitted] = useState<boolean>(false);
    const [frequency, setFrequency] = useState<Frequency>();

    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const { name, value } = event.target;
        setTrip({ ...Trip, [name]: value });
    };

    const handleFrequencyChange = (event: SelectChangeEvent) => {
        setFrequency(event.target.value as Frequency);
    }

    const saveTutorial = () => {
        var data = {
            name: Trip.name,
            start: Trip.start,
            end: Trip.end,
            frequency: Trip.frequency
        };

        // TripServices.postTrip(data)
        //     .then((response: any) => {
        //         setTrip({
        //             id: response.data.id,
        //             name: response.data.name,
        //             start: response.data.start,
        //             end: response.data.end,
        //             frequency: response.data.frequency,
        //         });
        //         setSubmitted(true);
        //         console.log(response.data);
        //     })
        //     .catch((e: Error) => {
        //         console.log(e);
        //     });
    };

    const newTrip = () => {
        setTrip(initialTripState);
        setSubmitted(false);
    };

    return (
        <div className="submit-form">
            {submitted ? (
                <div>
                    <h4>You submitted successfully!</h4>
                    <button className="btn btn-success" onClick={newTrip}>
                        Add
                    </button>
                </div>
            ) : (
                <div>
                    <FormControl sx={{ minWidth: 300 }}>
                        <TextField
                            type="text"
                            id="name"
                            required
                            value={Trip.name as string}
                            onChange={handleInputChange}
                            name="name"
                            label="Nom du trajet"
                        />
                        <TextField
                            type="text"
                            id="start"
                            label="Départ"
                        />
                        <TextField
                            type="text"
                            id="end"
                            label="Arrivée"
                        />
                        <Select
                            id="frequency"
                            value={frequency}
                            onChange={handleFrequencyChange}
                        >
                            <MenuItem value={Frequency.tousLesJours}>Tous les jours</MenuItem>
                            <MenuItem value={Frequency.joursOUvrables}>Jours ouvrables</MenuItem>
                            <MenuItem value={Frequency.uneFoisSemaine}>Une fois par semaine</MenuItem>
                            <MenuItem value={Frequency.deuxFoisSemaine}>Deux fois par semaine</MenuItem>
                            <MenuItem value={Frequency.uneFoisMois}>Une fois par mois</MenuItem>
                            <MenuItem value={Frequency.deuxFoisMois}>Deux fois mois</MenuItem>
                            <MenuItem value={Frequency.uneFoisAnnee}>Une fois par année</MenuItem>
                            <MenuItem value={Frequency.deuxFoisAnnee}>Deux fois par année</MenuItem>

                        </Select>

                        <Button onClick={saveTutorial} variant="contained">
                            Soumettre
                        </Button>
                    </FormControl>

                </div>
            )}
        </div>
    );
};

export default AddTrip;