import http from "../http-commons";
import CarData from "../types/Car";

/**
 * These are all examples of services, if you need more complex
 * services feel free to create your own in it own file to prevent clutter.
 * Note that there is no error handling here but axios includes a elegant way to handle errors
 * that should be implemented in services. See https://axios-http.com/docs/handling_errors 
 */

const getAll = () => {
  return http.get<Array<CarData>>("/vehicule");
};

const get = (id: any) => {
  console.log("getting with id:", id);
  return http.get<CarData>(`/vehicule/${id}`);
};

const post = (data: CarData) => {
  return http.post<CarData>("/vehicule", data);
};

// Note that update, remove and removeAll aren't typed so be carefull !
const update = (id: any, data: CarData) => {
  return http.put<any>(`/url/${id}`, data);
};

const remove = (id: any) => {
  return http.delete<any>(`/vehicle/${id}`);
};

const removeAll = () => {
  return http.delete<any>(`/vehicle`);
};

const ExampleService = {
  getAll,
  get,
  post,
  update,
  remove,
  removeAll,
};

export default ExampleService;
