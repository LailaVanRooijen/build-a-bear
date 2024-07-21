import Bear from "../assets/logo.png";
const Logo = ({ style }: LogoProps) => {
  return <img className={style} src={Bear} alt="bear" />;
};

export default Logo;

interface LogoProps {
  style?: string;
}
