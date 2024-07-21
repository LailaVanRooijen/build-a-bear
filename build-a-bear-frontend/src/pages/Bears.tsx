import { useEffect, useState } from "react";
import { MdExpandCircleDown } from "react-icons/md";
import Card from "../components/Card";
import Checkbox from "../components/Checkbox";
import Page from "../components/Page";
import Panel from "../components/Panel";
import useAxios from "../hooks/useAxios";
import { IBear } from "../interfaces/Ibear";
import { IColor } from "../interfaces/IColor";

const Bears = () => {
  const { getRequest } = useAxios();
  const [bears, setBears] = useState<IBear[] | null>(null);
  const [colors, setColors] = useState<IColor[] | null>(null);
  const [showColorFilters, setShowColorFilters] = useState<boolean>(true);

  const fetch: Fetch = (url, setFunction) => {
    getRequest(url)
      .then((response) => {
        setFunction(response);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    fetch<IBear>("bears", setBears);
    fetch<IColor>("colors", setColors);
  }, []);

  return (
    <>
      <Page style={"flex"}>
        <Panel style={"w-1/6 p-6"}>
          <div className="border-b-2 p-2 flex flex-row items-center justify-between">
            Filter by color{" "}
            <MdExpandCircleDown
              onClick={() => {
                setShowColorFilters(!showColorFilters);
              }}
              className={`text-maize cursor-pointer text-xl hover:text-dark-maize transform ${
                showColorFilters ? "rotate-180" : ""
              }`}
            />
          </div>
          {colors && showColorFilters && (
            <ul>
              {colors.map((color: IColor) => (
                <li key={color.color}>
                  <Checkbox
                    label={color.color}
                    content={color.color}
                    customCheckmark="🐻"
                  />
                </li>
              ))}
            </ul>
          )}
        </Panel>

        <Panel style={"p-6 w-5/6"}>
          {bears && (
            <ul className="grid grid-cols-3 p-4 gap-12">
              {bears.map((bear: IBear) => (
                <Card key={bear.id} bear={bear} />
              ))}
            </ul>
          )}
        </Panel>
      </Page>
    </>
  );
};

export default Bears;

interface Fetch {
  <T>(
    url: string,
    setFunction: React.Dispatch<React.SetStateAction<T[] | null>>
  ): void;
}
