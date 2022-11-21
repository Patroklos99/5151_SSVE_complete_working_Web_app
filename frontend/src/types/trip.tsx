import GeoPoint from "./geoPoint";

export default interface TripData {
    id?: number | null,
    name: string | null,
    startPoint: GeoPoint | null,
    endPoint: GeoPoint | null,
    freq: number | null,
}