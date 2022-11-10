import { Avatar, ListItem, ListItemAvatar, ListItemText, Paper } from "@mui/material"
import { ICar } from "../../../../types/Car"
import { LinearProgressWithLabel } from "../linearProgressWithLabel"
import './style.css'

const ListItemCar = (car:ICar, index: number) => {
    return (
        <div className="list-item-car">
            <Paper elevation={4}>
                <ListItem key={index} alignItems="flex-start">
                    <ListItemAvatar>
                        <Avatar alt="img" src={`car.imgLink`} />
                    </ListItemAvatar>
                    <ListItemText
                        primary={
                            <div className="primary">
                                <div className='modele'>{car.brand +" "+ car.modelName}</div>
                                <div className='prix'>{car.price}$</div>
                            </div> 
                        }
                        secondary={
                            <div>
                                <div className='desc-text'>
                                    {car.description}
                                </div>
                                {/* <LinearProgressWithLabel variant="determinate" value={car.score}/> */}
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