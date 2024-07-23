import { useEffect, useRef, useState } from "react";
import Card from "../components/Card";
import Filter from "../components/Filter";
import Page from "../components/Page";
import Panel from "../components/Panel";
import useAxios from "../hooks/useAxios";
import { IBear } from "../interfaces/IBear";
import {
  IColor,
  IFurPattern,
  IFurType,
  IOutfit,
  IVoice,
} from "../interfaces/IBearProps";

const Bears = () => {
  const { getRequest } = useAxios();
  const [bears, setBears] = useState<IBear[] | null>(null);
  const [colors, setColors] = useState<IColor[] | null>(null);
  const [furTypes, setFurTypes] = useState<IFurType[] | null>(null);
  const [furPatterns, setFurPatterns] = useState<IFurPattern[] | null>(null);
  const [voices, setVoices] = useState<IVoice[] | null>(null);
  const [outfits, setOutfits] = useState<IOutfit[] | null>(null);
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
    fetch<IFurPattern>("fur-patterns", {}, setFurPatterns);
    fetch<IVoice>("voices", {}, setVoices);
    fetch<IOutfit>("outfits", {}, setOutfits);
  }, []);

  useEffect(() => {
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
          {colors && (
            <Filter
              title="Color"
              items={colors.map((color) => ({
                value: color.color,
                id: color.id,
              }))}
              label="color"
              addFilter={(
                label: string,
                target: string,
                isChecked: boolean
              ) => {
                addFilter(label, target, isChecked);
              }}
            />
          )}
          {voices && (
            <Filter
              title="Voice"
              items={voices.map((item) => ({
                value: item.voice,
                id: item.id,
              }))}
              label="voice"
              addFilter={(
                label: string,
                target: string,
                isChecked: boolean
              ) => {
                addFilter(label, target, isChecked);
              }}
            />
          )}
          {furPatterns && (
            <Filter
              title="Fur Pattern"
              items={furPatterns.map((item) => ({
                value: item.furPattern,
                id: item.id,
              }))}
              label="fur-pattern"
              addFilter={(
                label: string,
                target: string,
                isChecked: boolean
              ) => {
                addFilter(label, target, isChecked);
              }}
            />
          )}
          {furTypes && (
            <Filter
              title="Fur Type"
              items={furTypes.map((item) => ({
                value: item.furType,
                id: item.id,
              }))}
              label="fur-type"
              addFilter={(
                label: string,
                target: string,
                isChecked: boolean
              ) => {
                addFilter(label, target, isChecked);
              }}
            />
          )}
          {outfits && (
            <Filter
              title="Outfit"
              items={outfits.map((item) => ({
                value: item.name,
                id: item.id,
              }))}
              label="outfit"
              addFilter={(
                label: string,
                target: string,
                isChecked: boolean
              ) => {
                addFilter(label, target, isChecked);
              }}
            />
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
    params: {},
    setFunction: React.Dispatch<React.SetStateAction<T[] | null>>
  ): void;
}

interface AddFilter {
  (label: string, target: string, isChecked: boolean): void;
}
