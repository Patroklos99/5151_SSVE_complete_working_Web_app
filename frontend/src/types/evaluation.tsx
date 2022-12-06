import ICar from "./Car";

export default interface Evaluation {
    score: number;
    trajetTotal: number;
    nbTrajetSansRecharge: number;
    vehicle: ICar;
}