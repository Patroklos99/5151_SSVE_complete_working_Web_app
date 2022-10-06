import React, { useState, ChangeEvent } from "react";
import ExampleService from "../../services/ExampleServices";
import CarData from "../../types/Car";
import { TextField, Button } from "@mui/material";
import { Link } from "react-router-dom";

const CarList: React.FC = () => {

  const initialCarState = {
    id: null,
    modelName: "",
  };

  const [Car, setCar] = useState<CarData>(initialCarState);
  const [fetched, setFetched] = useState<boolean>(false);
  const [CarId, setCarId] = useState<number>(-1);

  const onChangeCarId = (e: ChangeEvent<HTMLInputElement>) => {
    const Car = Number(e.target.value);
    setCarId(Car);
  };

  const getCar = () => {
    ExampleService.get(CarId)
      .then((response: any) => {
        setCar(response.data);
        setFetched(true);
        console.log(response.data);
      })
      .catch((e: Error) => {
        console.log(e);
      });
  };

  return (
    <div className="submit-form">
      {fetched ? (
    <div>
      <h4>Car Model:</h4>
      <p>{Car.modelName}</p>
      <h4>Car Id:</h4>
      <p>{Car.id}</p>
      <div>
        <Link to="/">Back</Link>
      </div>
    </div>
  ) : (
    <div>
      <div className="form-group">
        <TextField
          type="number"
          className="form-control"
          id="id"
          required
          value={CarId as number}
          onChange={onChangeCarId}
          name="id"
          label="Car id"
          variant="filled"
        />
      </div>

      <Button onClick={getCar} variant="contained">
        Submit
      </Button>
      
      <div>
        <Link to="/">Back</Link>
      </div>
    </div>
  )}
    </div>
  );
};

export default CarList;