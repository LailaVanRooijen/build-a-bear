import { useEffect, useRef, useState } from "react";
import { MdExpandCircleDown } from "react-icons/md";
import Card from "../components/Card";
import Checkbox from "../components/Checkbox";
import Page from "../components/Page";
import Panel from "../components/Panel";
import useAxios from "../hooks/useAxios";
import { IBear } from "../interfaces/IBear";
import { IColor, IFurType } from "../interfaces/IBearProps";

const Bears = () => {
  const { getRequest } = useAxios();
  const [bears, setBears] = useState<IBear[] | null>(null);
  const [colors, setColors] = useState<IColor[] | null>(null);
  const [furTypes, setFurTypes] = useState<IFurType[] | null>(null);
  const [showFurTypes, setShowFurTypes] = useState<boolean>(true);
  const [showColorFilters, setShowColorFilters] = useState<boolean>(true);
  const [filters, setFilters] = useState<{ [key: string]: string[] }>({});
  const refFilters = useRef<{ [key: string]: string }>({});

  const fetch: Fetch = (url, params, setFunction) => {
    getRequest(url, params).then((response) => {
      setFunction(response);
    });
  };

  useEffect(() => {
    fetch<IColor>("colors", {}, setColors);
    fetch<IFurType>("fur-types", {}, setFurTypes);
  }, []);

  useEffect(() => {
    console.log(filters);
    fetch<IBear>("bears", filters, setBears);
  }, [filters]);

  const addFilter: AddFilter = (label, target, isChecked) => {
    if (isChecked) {
      if (!refFilters.current[label]) {
        refFilters.current[label] = [];
      }
      refFilters.current[label].push(target);
    } else {
      if (refFilters.current[label]) {
        refFilters.current[label] = refFilters.current[label].filter(
          (filter: string) => filter !== target
        );
      }
    }
    setFilters({ ...refFilters.current });
  };

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
            <ul className={showColorFilters ? "" : "hidden"}>
              {colors.map((color: IColor) => (
                <li key={color.color}>
                  <Checkbox
                    label={"colors"}
                    content={color.color}
                    customCheckmark="🐻"
                    handleChange={(label, target, isChecked) => {
                      addFilter(label, target, isChecked);
                    }}
                  />
                </li>
              ))}
            </ul>
          )}
          <div className="border-b-2 p-2 flex flex-row items-center justify-between">
            Filter by Fur Type{" "}
            <MdExpandCircleDown
              onClick={() => {
                setShowFurTypes(!showFurTypes);
              }}
              className={`text-maize cursor-pointer text-xl hover:text-dark-maize transform ${
                showFurTypes ? "rotate-180" : ""
              }`}
            />
          </div>
          {furTypes && showFurTypes && (
            <ul>
              {furTypes.map((item: IFurType) => (
                <li key={item.furType}>
                  <Checkbox
                    label={"Fur Type"}
                    content={item.furType}
                    customCheckmark="🐻"
                    handleChange={(label, target, isChecked) => {
                      addFilter(label, target, isChecked);
                    }}
                  />
                </li>
              ))}
            </ul>
          )}

          {/* {colors && (
            <Filter
              title="Color"
              items={colors.map((color) => ({ value: color.color }))}
              label="colors"
              addFilter={(label, target, isChecked) => {
                addFilter(label, target, isChecked);
              }}
            />
          )} */}
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
    params: {},
    setFunction: React.Dispatch<React.SetStateAction<T[] | null>>
  ): void;
}

interface AddFilter {
  (label: string, target: string, isChecked: boolean): void;
}
