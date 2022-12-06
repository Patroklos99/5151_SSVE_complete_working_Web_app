export default interface ICar {
    id: number;
    brand: string;
    modelName: string;
    nbPlaces: number;
    imgLink: string;
    price: number;
    nbDoors?: number | null;
    type: string;
    safetyScore: number;
    batteryCapacity?: number | null;
    range?: number | null;
    refLink: string;
    description: string;
    score?: number | null;

    maintainCosts: number;
    electricalCapacity: number;
    electricalStreetConsumption: number;
    electricalHighwayConsumption: number;
    gasCapacity: number;
    gasStreetConsumption: number;
    gasHighwayConsumption: number;
    loadCapacity: number;
}

