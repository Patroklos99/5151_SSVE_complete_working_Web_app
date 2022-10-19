import { Avatar, ListItem, ListItemAvatar, ListItemText, Paper } from "@mui/material"
import { ICar } from "../../../../models/cars"
import { LinearProgressWithLabel } from "../linearProgressWithLabel"
import './style.css'

const ListItemCar = (car:ICar, index: number) => {
    return (
        <div className="list-item-car">
            <Paper elevation={4}>
                <ListItem key={index} alignItems="flex-start">
                    <ListItemAvatar>
                        <Avatar alt="img" src={require(`../../../../assets/images/${car.image}`)} />
                    </ListItemAvatar>
                    <ListItemText
                        primary={
                            <div className="primary">
                                <div className='modele'>{car.marque + car.modele}</div>
                                <div className='prix'>{car.prix}$</div>
                            </div> 
                        }
                        secondary={
                            <div>
                                <div className='desc-text'>
                                    {car.desc}
                                </div>
                                <LinearProgressWithLabel variant="determinate" value={car.score}/>
                            </div> 
                        }
                        color="black"
                    />
                </ListItem>
            </Paper>
        </div>

    )
}

export default ListItemCar;