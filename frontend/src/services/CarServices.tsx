import axios from "../http-commons";
import Icar from "../types/Car";

/**
 * These are all examples of services, if you need more complex
 * services feel free to create your own in it own file to prevent clutter.
 * Note that there is no error handling here but axios includes a elegant way to handle errors
 * that should be implemented in services. See https://axios-http.com/docs/handling_errors
 */
const getAllCars = async () => {
  try {
    console.log(process.env.NODE_ENV);
    const res = await axios.get<Array<Icar>>("/vehicle/evaluate");
    const data = res.data;
    return data;
  } catch (err) {
    console.log(err);
    return [];
  }
};

const CarServices = {
  getAllCars,
};

export default CarServices;
