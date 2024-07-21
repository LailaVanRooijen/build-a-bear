import Logo from "./Logo";
import NavigationLink from "./NavigationLink";

const NavBar: React.FC<NavBarProps> = ({ style }) => {
  return (
    <>
      <ul
        className={`${style} grid grid-cols-12 shadow-bottom bg-maize text-purple font-bold text-xl text-center tracking-wider p-4 gap-6 items-center font-comforta tracking-wider`}
      >
        <Logo style={"h-20 col-span-8"} />
        <NavigationLink linkTo={"test"} style={"col-span-1"} />
        <NavigationLink linkTo={"test"} style={"col-span-1"} />
        <NavigationLink linkTo={"bears"} style={"col-span-1"} />
        <NavigationLink linkTo={"home"} style={"col-span-1"} />
      </ul>
    </>
  );
};

export default NavBar;

interface NavBarProps {
  style?: string;
}
