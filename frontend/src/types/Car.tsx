export default interface ICar {
    id: number;
    brand: string;
    modelName: string;
    nbPlaces: number;
    imgLink: string;
    price: number;
    nbDoors: number;
    type: string;
    safetyScore: number;
    batteryCapacity: number;
    range: number;
    refLink: string;
    description: string;
    score: number;

    maintainCosts: number;
    electricalCapacity: number;
    electricalStreetConsumption: number;
    electricalHighwayConsumption: number;
    gasCapacity: number;
    gasStreetConsumption: number;
    gasHighwayConsumption: number;
    loadCapacity: number;
}

