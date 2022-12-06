import axios from "../http-commons";
import TripNeeds from "../types/tripNeeds";
import Evaluation from "../types/evaluation";


/*
const postTripNeeds = async (data: TripNeeds) => {

    return axios.post<TripNeeds>("/vehicle/evaluate", data);

};
**/
const postTripNeeds = async (data: TripNeeds) => {

    try {
        const res = await axios.post("/vehicle/evaluate", data);
        const resData = res.data;
        resData.forEach((evaluation: Evaluation) => {
            evaluation.vehicle.imgLink = 
                evaluation.vehicle.imgLink.substring(evaluation.vehicle.imgLink.lastIndexOf('/') + 1);
        });
        console.log(resData);
        return await data;
    } catch (err) {
        console.log(err);
        return [];
    }
}


const TripService = {

    postTripNeeds

};



export default TripService;