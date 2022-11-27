import { Avatar, Container, Icon, ListItem, ListItemAvatar, ListItemText, Paper, Tooltip } from "@mui/material"
import Grid from '@mui/material/Unstable_Grid2';
import ICar from "../../../types/Car"
import './style.css'
import BatteryChargingFullOutlinedIcon from '@mui/icons-material/BatteryChargingFullOutlined';
import HealthAndSafetyIcon from '@mui/icons-material/HealthAndSafety';
import { CircularProgressbar } from 'react-circular-progressbar';
import 'react-circular-progressbar/dist/styles.css';


interface ResultDetailsProps {
    car: ICar;
}

const carDoorIcon = require('../../../assets/icons/car-door.png');
const distanceIcon = require('../../../assets/icons/distance.png');


const ResultDetails = (props: ResultDetailsProps) => {
    const score = (Math.round(props.car.score * 100) / 100).toFixed(2);
    return (
        <Container className="result-details-container">
            <div className="main-img">
                <img src={/*require(`../../../assets/images/${props.car.imgLink}`)*/""} alt="" />
            </div>
            <div className="title">
                <h2 className='modele'>{props.car.brand +" "+ props.car.modelName}</h2>
                <h3 className='prix'>{props.car.price}$</h3>
                <CircularProgressbar className="circular-progress-score" value={props.car.score} maxValue={10} text={`${score}`} />
            </div>
            <span>
            <div className="desc">
                <Grid container rowSpacing={1} columnSpacing={{ xs: 1, sm: 2, md: 3 }}>
                    <Grid xs={6}>
                        <Tooltip title="Number of doors" arrow>
                            <div className="desc-item">
                                {carDoorIcon && <img className="car-door-icon" src={carDoorIcon} alt="" />}
                                {props.car.nbDoors}
                            </div>
                        </Tooltip>
                    </Grid>
                    <Grid xs={6}>
                        <Tooltip title="Battery capacity" arrow>
                            <div className="desc-item">
                                <BatteryChargingFullOutlinedIcon />
                                {props.car.batteryCapacity} kWh
                            </div>
                        </Tooltip>
                    </Grid>
                    <Grid xs={6}>
                        <Tooltip title="Range with full battery" arrow>
                            <div className="desc-item">
                                {distanceIcon && <img className="distance-icon" src={distanceIcon} alt="" />}
                                {props.car.range} km
                            </div>
                        </Tooltip>
                    </Grid>
                    <Grid xs={6}>
                        <Tooltip title="NHTSA Safety Score" arrow>
                            <div className="desc-item">
                                <HealthAndSafetyIcon />
                                {props.car.safetyScore} / 5
                            </div>
                        </Tooltip>
                    </Grid>
                </Grid>

            </div>
            </span>


        </Container>

    )
}

export default ResultDetails;