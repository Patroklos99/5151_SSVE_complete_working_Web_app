import {
  Avatar,
  ListItem,
  ListItemAvatar,
  ListItemText,
  Paper,
} from "@mui/material";
import ICar from "../../../../types/Car";
import { getCarImage } from "../../../../utils/utils";
import { LinearProgressWithLabel } from "../linearProgressWithLabel";
import "./style.css";

interface ListItemCarProps {
  car: ICar;
  index: number;
  handleClick: (result: ICar) => void;
}

const ListItemCar = (props: ListItemCarProps) => {
  let imgSrc = ""; // Definiser votre source d'image local ici

  if (process.env.NODE_ENV === "production") {
    imgSrc = "http://adve.info.uqam.ca/img/";
  }

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
                  <div className="modele">
                    {props.car.brand + " " + props.car.modelName}
                  </div>
                  <div className="prix">{props.car.price}$</div>
                </div>
              }
              // secondary={props.car.description}
              secondary="Lorem ipsum dolor sit amet consectetur adipisicing elit. Inventore impedit voluptatem delectus, ipsum dignissimos facere eveniet error, odit nisi aliquid cum cumque. Magnam ad, possimus non vitae quod quas ducimus."
              color="black"
            />
            <LinearProgressWithLabel
              variant="determinate"
              value={props.car.score}
            />
          </div>
        </ListItem>
      </Paper>
    </div>
  );
};

export default ListItemCar;
