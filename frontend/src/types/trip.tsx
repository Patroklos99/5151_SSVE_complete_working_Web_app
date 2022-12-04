import GeoPoint from "./geoPoint";

export default interface TripData {
    name: string | null,
    stops: GeoPoint[] | null,
    annualFreq: number | null,
}
