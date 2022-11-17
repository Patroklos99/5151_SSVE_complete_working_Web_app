import http from "../http-commons";
import TripData from "../types/trip";
import TripNeeds from "../types/tripNeeds";



/**

 * These are all examples of services, if you need more complex

 * services feel free to create your own in it own file to prevent clutter.

 * Note that there is no error handling here but axios includes a elegant way to handle errors

 * that should be implemented in services. See https://axios-http.com/docs/handling_errors

 */



const getAllTrip = async () => {

    return http.get<Array<TripData>>("/trip");

};



const getTrip = async (id: any) => {

    console.log("getting with id:", id);

    return http.get<TripNeeds>(`/tripneeds/${id}`);

};



const postTrip = async (data: TripData) => {

    return http.post<TripData>("/trip", data);

};

const postTripNeeds = async (data: TripNeeds) => {

    return http.post<TripNeeds>("/tripneeds", data);

};


// Note that update, remove and removeAll aren't typed so be carefull !

const updateTrip = async (id: any, data: TripData) => {

    return http.put<any>(`/url/${id}`, data);

};



const removeTrip = async (id: any) => {

    return http.delete<any>(`/trip/${id}`);

};





const removeAllTrip = async () => {

    return http.delete<any>(`/trip`);

};



const TripService = {
    getAllTrip,
    getTrip,
    postTripNeeds,
    postTrip,
    updateTrip,
    removeTrip,
    removeAllTrip
};



export default TripService;