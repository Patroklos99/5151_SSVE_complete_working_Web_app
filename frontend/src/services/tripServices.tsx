import http from "../http-commons";
import TripData from "../types/trip2";



/**

 * These are all examples of services, if you need more complex

 * services feel free to create your own in it own file to prevent clutter.

 * Note that there is no error handling here but axios includes a elegant way to handle errors

 * that should be implemented in services. See https://axios-http.com/docs/handling_errors

 */



const getAllTrip = () => {

    return http.get<Array<TripData>>("/trip");

};



const getTrip = (id: any) => {

    console.log("getting with id:", id);

    return http.get<TripData>(`/trip/${id}`);

};



const postTrip = (data: TripData) => {

    return http.post<TripData>("/trip", data);

};


// Note that update, remove and removeAll aren't typed so be carefull !

const updateTrip = (id: any, data: TripData) => {

    return http.put<any>(`/url/${id}`, data);

};



const removeTrip = (id: any) => {

    return http.delete<any>(`/trip/${id}`);

};





const removeAllTrip = () => {

    return http.delete<any>(`/trip`);

};



const TripService = {

    getAllTrip,

    getTrip,

    postTrip,

    updateTrip,

    removeTrip,

    removeAllTrip

};



export default TripService;