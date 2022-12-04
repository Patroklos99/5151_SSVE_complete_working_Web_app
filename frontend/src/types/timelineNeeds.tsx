export default interface TimelineNeedsState {

    /**
     * This is the data type we use to interface with our API.
     * Be especially carefull when playing with this as it might break other parts 
     * of the code if changes aren't implemented mindfully.
     */

    autonomy?: number | 0, // The id of the Car
    chargeTime?: number | 0, // The model of the car
}