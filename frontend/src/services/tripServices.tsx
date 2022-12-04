import http from "../http-commons";
import TripNeeds from "../types/tripNeeds";
import TimelineNeedsState from "../types/timelineNeeds"



const postTripNeeds = async (data: TripNeeds) => {

    return http.post<TripNeeds>("/tripneeds", data);

};

const postTimelineNeeds = async (data: TimelineNeedsState ) => {

  return http.post<String>("/tripneeds/timelineNeeds", data);

};

 const postTimelineTrips = async (data: String) => {

  return http.post<String>("/tripneeds/timelineTrips", data);

};


const TripService = {

    postTripNeeds,
    postTimelineNeeds,
    postTimelineTrips

};



export default TripService;
