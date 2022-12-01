import { Avatar, ListItem, ListItemAvatar, ListItemText, Paper } from "@mui/material"
import ICar from "../../../../types/Car"
import { LinearProgressWithLabel } from "../linearProgressWithLabel"
import './style.css'

const ListItemCar = (car:ICar, index: number) => {

    return (
        <div key={index} className="list-item-car">
            <Paper elevation={4}>
                <ListItem key={index} alignItems="flex-start">
                    <ListItemAvatar>
                        <Avatar alt="img" src={require(`../../../../assets/images/${car.imgLink}`)} />
                    </ListItemAvatar>
                    <div className="desc">
                        <ListItemText
                            primary={
                                <div className="primary">
                                    <div className='modele'>{car.brand +" "+ car.modelName}</div>
                                    <div className='prix'>{car.price}$</div>
                                </div> 
                            }
                            secondary={car.description}
                            color="black"
                        />
                        <LinearProgressWithLabel variant="determinate" value={car.score * 10}/>
                    </div>
                </ListItem>
            </Paper>
        </div>

    )
}

export default ListItemCar;
