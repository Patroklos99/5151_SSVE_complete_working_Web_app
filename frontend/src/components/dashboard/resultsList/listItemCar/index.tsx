import { Avatar, ListItem, ListItemAvatar, ListItemText, Paper } from "@mui/material"
import ICar from "../../../../types/Car"
import { getCarImage } from "../../../../utils/utils";
import { LinearProgressWithLabel } from "../linearProgressWithLabel"
import './style.css'


interface ListItemCarProps {
    car: ICar;
    index: number;
    handleClick: (result: ICar) => void;
}



const ListItemCar = (props: ListItemCarProps) => {

    return (
        <div key={props.index} className="list-item-car">
            <Paper elevation={4} onClick={() => props.handleClick(props.car)}>
                <ListItem key={props.index} alignItems="flex-start">
                    <ListItemAvatar>
                        <Avatar alt="img" src={getCarImage(props.car.imgLink)} />
                    </ListItemAvatar>
                    <div className="desc">
                        <ListItemText
                            primary={
                                <div className="primary">
                                    <div className='modele'>{props.car.brand +" "+ props.car.modelName}</div>
                                    <div className='prix'>{props.car.price}$</div>
                                </div> 
                            }
                            secondary={props.car.description}
                            color="black"
                        />
                        <LinearProgressWithLabel variant="determinate" value={props.car.score * 10}/>
                    </div>
                </ListItem>
            </Paper>
        </div>

    )
}

export default ListItemCar;
