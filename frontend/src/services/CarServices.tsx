import ICar from "../types/Car";
import axios from "../http-commons";

/**
 * These are all examples of services, if you need more complex
 * services feel free to create your own in it own file to prevent clutter.
 * Note that there is no error handling here but axios includes a elegant way to handle errors
 * that should be implemented in services. See https://axios-http.com/docs/handling_errors
 */
const getAllCars = async () => {
  try {
    const res = await axios.get("/vehicle/evaluate");
    const data = res.data;
    data.forEach((car: ICar) => {
      car.imgLink = car.imgLink.substring(car.imgLink.lastIndexOf('/') + 1)
    });
    return await data;
  } catch (err) {
    console.log(err);
    return [];
  }
};

const CarServices = {
  getAllCars,
};

export default CarServices;
