import NotFoundImg from "../assets/notFound.png";
import Page from "./Page";

const NotFound = () => {
  return (
    <Page style={"flex flex-col items-center justify-center"}>
      <img src={NotFoundImg} className={"w-48 ml-6"} />
      <p className="text-xl font-extrabold text-maize tracking-wider">
        404 not found
      </p>
    </Page>
  );
};

export default NotFound;
