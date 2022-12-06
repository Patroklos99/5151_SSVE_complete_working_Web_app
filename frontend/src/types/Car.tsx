export default interface CarData {

    /**
     * This is the data type we use to interface with our API.
     * Be especially carefull when playing with this as it might break other parts 
     * of the code if changes aren't implemented mindfully.
     */

    id?: number | null, // The id of the Car
    modelName: string | null, // The model of the car
}