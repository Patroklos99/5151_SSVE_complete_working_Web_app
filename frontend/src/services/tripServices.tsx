import http from "../http-commons";
import TripNeeds from "../types/tripNeeds";



const postTripNeeds = async (data: TripNeeds) => {

    return http.post<TripNeeds>("/tripneeds", data);

};




const TripService = {

    postTripNeeds

};



export default TripService;