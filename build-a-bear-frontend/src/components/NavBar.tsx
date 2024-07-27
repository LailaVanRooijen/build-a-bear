import { useEffect } from "react";
import { useAuth } from "../context/AuthContext";
import Logo from "./Logo";
import NavigationLink from "./NavigationLink";

const NavBar: React.FC<NavBarProps> = ({ style }) => {
  const { user } = useAuth();
  useEffect(() => {}, [user]);

  return (
    <>
      <ul
        className={`${style} grid grid-cols-12 shadow-bottom bg-maize text-purple font-bold text-xl text-center tracking-wider p-4 gap-6 items-center font-comforta tracking-wider`}
      >
        <Logo style={"h-20 col-span-4"} />
        <NavigationLink linkTo={"build-a-bear"} style={"col-span-2"} />
        <NavigationLink linkTo={"buy-a-bear"} style={"col-span-2"} />
        <NavigationLink linkTo={"home"} style={"col-span-2"} />
        {user != null ? (
          <NavigationLink linkTo={"logout"} style={"col-span-2"} />
        ) : (
          <NavigationLink linkTo={"login"} style={"col-span-2"} />
        )}
      </ul>
    </>
  );
};

export default NavBar;

interface NavBarProps {
  style?: string;
}
