import TripData from "./trip";

export default interface TripNeeds {
    id?: number | null,
    trips: TripData[] 
}