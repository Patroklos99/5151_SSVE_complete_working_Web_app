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
        return Math.round(capacity / consumption * 100);
    }
    const totalRangeCity_E = getRange(car.electricalCapacity, car.electricalStreetConsumption);
    const totalRangeHighway_E = getRange(car.electricalCapacity, car.electricalHighwayConsumption)
    const totalRangeCity_G = getRange(car.gasCapacity, car.gasStreetConsumption);
    const totalRangeHighway_G = getRange(car.gasCapacity, car.gasHighwayConsumption);
    const totalRange_E = (totalRangeCity_E + totalRangeHighway_E) / 2;
    const totalRange_G = (totalRangeCity_G + totalRangeHighway_G) / 2;

    const getTotalRange = ()=>{
        const totalRange = car.gasCapacity > 0 ? totalRange_E + totalRange_G : totalRange_E;
        return (totalRange).toFixed(2);
    }

    const gasInformationsRender = () => {
        if(car.gasCapacity > 0)
            return(
                <div>
                    <h3>Gas informations</h3>
                    <div className="gas-infos-container">
                        <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                            <Grid xs={6}>
                                    <div className="desc-item">
                                        <p className="title">City consumption: </p>
                                        <p>{car.gasStreetConsumption}</p><p>L/100km</p>
                                    </div>
                            </Grid>
                            <Grid xs={6}>
                                <Tooltip title="Range int the city with full gas tank" arrow>
                                    <div className="desc-item">
                                        <p className="title">City range: </p>
                                        <p>{totalRangeCity_G}</p><p>km</p>
                                    </div>
                                </Tooltip>
                            </Grid>
                            <Grid xs={6}>
                                <Tooltip title="Range on the highway with full tank" arrow>
                                    <div className="desc-item">
                                        <p className="title">Highway consumption: </p>
                                        <p>{car.gasHighwayConsumption}</p><p>L/100km</p>
                                    </div>
                                </Tooltip>
                            </Grid>
                            <Grid xs={6}>
                            <Tooltip title="Range on the highway with full gas tank" arrow>
                                <div className="desc-item">
                                    <p className="title">Highway range: </p>
                                    <p>{totalRangeHighway_G}</p><p>km</p>
                                </div>
                            </Tooltip>
                            </Grid>
                            <Grid xs={6}>
                                    <div className="desc-item">
                                        <p className="title">Gas capacity: </p>
                                        <p>{car.gasCapacity}</p><p>L</p>
                                    </div>
                            </Grid>
                        </Grid>
                    </div>
                </div>
            )
        return "";
    }


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
                <div className='desc-text'>
                    {car.description}
                </div>
                <h3>General informations</h3>
                <div className="general-infos-container">
                    <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                        <Grid xs={6}>
                            <Tooltip title="Maintenance costs" arrow>
                                <div className="desc-item">
                                    <BuildIcon/>
                                    {car.maintainCosts}$ / year
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Total range calculated with electrical (and gas if there is) and taking the mean of city and highway range" arrow>
                                <div className="desc-item">
                                    {distanceIcon && <img className="distance-icon" src={distanceIcon} alt="" />}
                                    {getTotalRange()} km
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
                                <div className="desc-item">
                                    <p className="title">City consumption: </p>
                                    <p>{car.electricalStreetConsumption} </p><p>kWh/100km</p>
                                </div>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range int the city with full battery" arrow>
                                <div className="desc-item">
                                    <p className="title">City range: </p>
                                    <p>{totalRangeCity_E}</p><p>km</p>
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                                <div className="desc-item">
                                    <p className="title">Highway consumption: </p>
                                    <p>{car.electricalHighwayConsumption}</p><p>kWh/100km</p>
                                </div>
                        </Grid>
                        <Grid xs={6}>
                            <Tooltip title="Range on the highway with full battery" arrow>
                                <div className="desc-item">
                                    <p className="title">Highway range: </p>
                                    <p>{totalRangeHighway_E}</p><p>km</p>
                                </div>
                            </Tooltip>
                        </Grid>
                        <Grid xs={6}>
                                <div className="desc-item">
                                    <p className="title">Battery capacity: </p>
                                    <p>{car.electricalCapacity}</p><p>kWh</p>
                                </div>
                        </Grid>
                    </Grid>
                </div>
                {gasInformationsRender()}

            </div>
            </span>
            </Container>
            


        </Container>

    )
}

export default ResultDetails;