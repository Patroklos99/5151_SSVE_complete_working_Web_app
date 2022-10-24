import http from "../http-commons";
import TripData from "../types/trips/trips";



/**

 * These are all examples of services, if you need more complex

 * services feel free to create your own in it own file to prevent clutter.

 * Note that there is no error handling here but axios includes a elegant way to handle errors

 * that should be implemented in services. See https://axios-http.com/docs/handling_errors

 */



const getAllTrip = () => {

    return http.get<Array<TripData>>("/vehicule");

};



const getTrip = (id: any) => {

    console.log("getting with id:", id);

    return http.get<TripData>(`/vehicule/${id}`);

};



const postTrip = (data: TripData) => {

    return http.post<TripData>("/vehicule", data);

};

const postTripJson = (data: TripData) => {
    return fetch("/trip", {
        method: "POST",
        body: JSON.stringify({
            id: data.id,
            name: data.name,
            start: data.start,
            end: data.end,
            frequency: data.frequency,  
        }),
    });
}

// Note that update, remove and removeAll aren't typed so be carefull !

const updateTrip = (id: any, data: TripData) => {

    return http.put<any>(`/url/${id}`, data);

};



const removeTrip = (id: any) => {

    return http.delete<any>(`/vehicle/${id}`);

};





const removeAllTrip = () => {

    return http.delete<any>(`/vehicle`);

};



const TripService = {

    getAllTrip,

    getTrip,

    postTrip,

    postTripJson,

    updateTrip,

    removeTrip,

    removeAllTrip

};



export default TripService;