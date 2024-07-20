import Logo from "./Logo";
import NavigationLink from "./NavigationLink";

const NavBar = () => {
  return (
    <>
      <ul className="grid grid-cols-12 shadow-shadow-b bg-maize text-purple font-bold text-xl text-center tracking-wider p-4 gap-6">
        <Logo style={"h-12 col-span-8"} />
        <NavigationLink linkTo={"home"} style={"col-span-1"} />
        <NavigationLink linkTo={"home"} style={"col-span-1"} />
        <NavigationLink linkTo={"home"} style={"col-span-1"} />
        <NavigationLink linkTo={"home"} style={"col-span-1"} />
      </ul>
    </>
  );
};

export default NavBar;
