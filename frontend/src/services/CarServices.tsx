import http from "../http-commons";
import {ICar} from "../types/Car";

/**
 * These are all examples of services, if you need more complex
 * services feel free to create your own in it own file to prevent clutter.
 * Note that there is no error handling here but axios includes a elegant way to handle errors
 * that should be implemented in services. See https://axios-http.com/docs/handling_errors 
 */
const url = "http://localhost:8080"
const getAllCars = async () => {
  try{
    const res = await fetch(`${url}/vehicle`,
    {
      method: 'GET',
    });
  
    const data = await res.json();
    //console.log(data);
    return data;
  }
  catch(err){
    console.log(err);
  }

};


const CarServices = {
  getAllCars
};

export default CarServices;
