import { useNavigate } from "react-router-dom";
import BearImg from "../assets/bear.png";
import { IBear } from "../interfaces/Ibear";
import CardRow from "./CardRow";

const Card: React.FC<CardProps> = ({ bear }) => {
  const navigate = useNavigate();
  return (
    <li
      className="flex flex-col items-center min-h-48 cursor-pointer border-4 border-white p-4 w-96 rounded-lg shadow-card-sand bg-gradient-to-br from-sand from-10% to-maize to-90% hover:bg-gradient-to-tr hover:shadow-card-hover-sand text-purple font-comforta"
      key={bear.id}
      onClick={() => {
        navigate(`/bears/${bear.id}`);
      }}
    >
      <img src={BearImg} className="w-1/3" />
      <h6 className="font-extrabold text-xl bg-purple text-maize p-2 rounded-lg m-2">
        {bear.name}
      </h6>
      <CardRow label={"color"} content={bear.color} />
      <CardRow label={"TODO"} content={"pattern"} />
      <CardRow label={"TODO"} content={"fur type"} />
      <CardRow label={"outfit"} content={bear.outfit} />
      <CardRow label={"head"} content={bear.head} />
      <CardRow label={"chest"} content={bear.chest} />
      <CardRow label={"feet"} content={bear.feet} />
    </li>
  );
};

export default Card;

interface CardProps {
  bear: IBear;
}
