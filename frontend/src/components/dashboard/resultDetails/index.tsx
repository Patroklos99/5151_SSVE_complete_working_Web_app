import { Container, Tooltip } from "@mui/material"
import Grid from '@mui/material/Unstable_Grid2';
import ICar from "../../../types/Car"
import './style.css'
import HealthAndSafetyIcon from '@mui/icons-material/HealthAndSafety';
import { CircularProgressbar, buildStyles } from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';
import BuildIcon from '@mui/icons-material/Build';
import PersonIcon from '@mui/icons-material/Person';
import FitnessCenterIcon from '@mui/icons-material/FitnessCenter';



interface ResultDetailsProps {
    car: ICar;
}
const distanceIcon = require('../../../assets/icons/distance.png');


const ResultDetails = (props: ResultDetailsProps) => {
    const { car } = props;
    const score = (car.score * 10).toFixed(2);
    
    const getRange = (capacity: number, consumption: number)=>{
        return Math.round(capacity / consumption * 100) / 100;
    }
    const totalRangeCity = getRange(car.electricalCapacity, car.electricalStreetConsumption) + getRange(car.gasCapacity, car.gasStreetConsumption);
    const totalRangeHighway = getRange(car.electricalCapacity, car.electricalHighwayConsumption) + getRange(car.gasCapacity, car.gasHighwayConsumption);
    const totalRange = totalRangeCity + totalRangeHighway;
    return (
        <Container className="result-details-container">
            <div className="main-img">
                <img src={require(`../../../assets/images/audiETron.png`)} alt="" />
            </div>
            <Container className="result-details-infos-container">
            <div className="title">
                <h2 className='modele'>{car.brand +" "+ car.modelName}</h2>
                    <h3 className='prix'>{car.price}$</h3>
                    <CircularProgressbar className="circular-progress-score" value={car.score} maxValue={10} text={`${score}`} 
                        styles={buildStyles({
                            textSize: '16px',
                            pathColor: `rgba(0, 153, 120, ${car.score})`,
                            trailColor: '#d6d6d6',
                            textColor: '#000',
                        })} 
                    />
            </div>
            <span>
            <div className="desc">
                <h3>General informations</h3>
                <div className="general-infos-container">
                    <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                        <Grid xs={6}>
                            <Tooltip title="Maintenance costs" arrow>
                                <div className="desc-item">
                                    <BuildIcon/>
                                    {car.maintainCosts}$
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range with full battery (and full gas tank)" arrow>
                                <div className="desc-item">
                                    {distanceIcon && <img className="distance-icon" src={distanceIcon} alt="" />}
                                    {totalRange} km
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="NHTSA Safety Score" arrow>
                                <div className="desc-item">
                                    <HealthAndSafetyIcon />
                                    {car.safetyScore} / 5
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Number of places" arrow>
                                <div className="desc-item">
                                    <PersonIcon />
                                    {car.nbPlaces}
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Load capacity" arrow>
                                <div className="desc-item">
                                    <FitnessCenterIcon />
                                    {car.loadCapacity} kg
                                </div>
                            </Tooltip>
                        </Grid>
                    </Grid>
                </div>

                <h3>Electric informations</h3>
                <div className="eletric-infos-container">
                    <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                        <Grid xs={6}>
                            <Tooltip title="Battery capacity" arrow>
                                <div className="desc-item">
                                    <p className="title">Battery capacity: </p>
                                    <p>{car.electricalCapacity} kWh</p>
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range in the city with full battery" arrow>
                                <div className="desc-item">
                                    <p className="title">Street consumption: </p>
                                    <p>{car.electricalStreetConsumption} kWh/100km</p>
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range on the highway with full battery" arrow>
                                <div className="desc-item">
                                    <p className="title">Highway consumption: </p>
                                    <p>{car.electricalHighwayConsumption} kWh/100km</p>
                                </div>
                            </Tooltip>
                        </Grid>
                    </Grid>
                </div>
                <h3>Gas informations</h3>
                <div className="gas-infos-container">
                    <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                        <Grid xs={6}>
                            <Tooltip title="Fuel tank capacity" arrow>
                                <div className="desc-item">
                                    <p className="title">Gas capacity: </p>
                                    <p>{car.gasCapacity} L</p>
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range in the city with full tank" arrow>
                                <div className="desc-item">
                                    <p className="title">Street consumption: </p>
                                    <p>{car.gasStreetConsumption} L/100km</p>
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range on the highway with full tank" arrow>
                                <div className="desc-item">
                                    <p className="title">Highway consumption: </p>
                                    <p>{car.gasHighwayConsumption} L/100km</p>
                                </div>
                            </Tooltip>
                        </Grid>
                    </Grid>
                </div>

            </div>
            </span>
            </Container>
            


        </Container>

    )
}

export default ResultDetails;