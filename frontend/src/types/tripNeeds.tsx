import TripData from "./trip2";

export default interface TripNeeds {
    id?: number | null,
    autonomy: number | null,
    charge_time: number | null,
    trips: TripData[] 
}