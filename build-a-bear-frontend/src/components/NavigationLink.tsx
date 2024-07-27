import { useNavigate } from "react-router-dom";

const NavigationLink = ({ linkTo, style }: NavigationLinkProps) => {
  const navigate = useNavigate();
  return (
    <li
      className={`${style} cursor-pointer p-2 rounded-xl hover:bg-purple hover:text-maize`}
      onClick={() => {
        navigate(`/${linkTo}`);
      }}
    >
      {linkTo}
    </li>
  );
};

export default NavigationLink;

interface NavigationLinkProps {
  linkTo: string;
  style?: string;
}
