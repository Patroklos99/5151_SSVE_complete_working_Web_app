import http from "../http-commons";
import TripNeeds from "../types/tripNeeds";



const postTripNeeds = async (data: TripNeeds) => {

    return http.post<TripNeeds>("/vehicle/evaluate", data);

};




const TripService = {

    postTripNeeds

};



export default TripService;