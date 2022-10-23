import React, {useState, ChangeEvent} from "react";
import {Link} from 'react-router-dom';
import TripData, {Frequency} from "../../types/trips/trips";
import Button from "@mui/material/Button";
import TextField from "@mui/material/TextField";
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

    const handleInputChange = (event: ChangeEvent<HTMLInputElement>) => {
        const {name, value} = event.target;
        setTrip({...Trip, [name]: value});
    };

    const saveTutorial = () => {
        var data = {
            name: Trip.name,
            start: Trip.start,
            end: Trip.end,
            frequency: Trip.frequency
        };

        TripServices.postTrip(data)
            .then((response: any) => {
                setTrip({
                    id: response.data.id,
                    name: response.data.name,
                    start: response.data.start,
                    end: response.data.end,
                    frequency: response.data.frequency,
                });
                setSubmitted(true);
                console.log(response.data);
            })
            .catch((e: Error) => {
                console.log(e);
            });
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
                    <div className="form-group">
                        <table>
                            <tr>
                                <TextField
                                    type="text"
                                    className="form-control"
                                    id="name"
                                    required
                                    value={Trip.name as string}
                                    onChange={handleInputChange}
                                    name="name"
                                    label="Name"
                                    variant="filled"
                                />
                            </tr>
                            <tr>
                                <TextField
                                    type="text"
                                    className="form-control"
                                    id="start"
                                    required
                                    value={Trip.start as number}
                                    onChange={handleInputChange}
                                    name="start"
                                    label="Start"
                                    variant="filled"
                                />
                            </tr>
                            <tr>
                                <TextField
                                    type="text"
                                    className="form-control"
                                    id="end"
                                    required
                                    value={Trip.end as number}
                                    onChange={handleInputChange}
                                    name="end"
                                    label="End"
                                    variant="filled"
                                />
                            </tr>
                            <tr>
                                <TextField
                                    type="text"
                                    className="form-control"
                                    id="frequency"
                                    required
                                    value={Trip.frequency as Frequency}
                                    onChange={handleInputChange}
                                    name="frequency"
                                    label="Frequency"
                                    variant="filled"
                                />
                            </tr>
                        </table>
                    </div>

                    <Button onClick={saveTutorial} variant="contained"
                            style={{display: "flex", alignItems: "center", padding: "0px 20px"}}>
                        Submit
                    </Button>

                </div>
            )}
        </div>
    );
};

export default AddTrip;