import { useEffect, useRef, useState } from "react";
import Button from "../components/Button";
import DropdownSelect from "../components/DropdownSelect";
import FieldInput from "../components/FieldInput";
import Page from "../components/Page";
import useAxios from "../hooks/useAxios";
import {
  IColor,
  IFurPattern,
  IFurType,
  IOutfit,
  IVoice,
} from "../interfaces/IBearProps";

const CreateBear = () => {
  const { getRequest } = useAxios();
  const [colors, setColors] = useState<IColor[] | null>(null);
  const [voices, setVoices] = useState<IVoice[] | null>(null);
  const [furTypes, setFurTypes] = useState<IFurType[] | null>(null);
  const [furPatterns, setFurPatterns] = useState<IFurPattern[] | null>(null);
  const [outfits, setOutfits] = useState<IOutfit[] | null>(null);
  const formRef = useRef<Form>({
    name: "",
    color: "",
    voice: "",
    furType: "",
    furPattern: "",
  });

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
    fetch<IColor>("colors", setColors);
    fetch<IVoice>("voices", setVoices);
    fetch<IFurType>("fur-types", setFurTypes);
    fetch<IFurPattern>("fur-patterns", setFurPatterns);
    fetch<IOutfit>("outfits", setOutfits);
  }, []);

  const submitForm = () => {
    console.log("submitForm: ", formRef);
  };

  return (
    <Page style="flex flex-col items-center justify-center">
      <div className="border-2 bg-maize text-purple font-extrabold border-purple rounded-lg p-12 w-1/2">
        <FieldInput
          label={"name"}
          content={"McFluffyButt"}
          style={"border-b-2 border-purple border-dotted"}
          bgAndTxt={"bg-maize text-purple border-purple"}
          handleChange={(value) => {
            formRef.current.name = value;
          }}
        />
        {colors && (
          <DropdownSelect
            options={colors.map((color) => color.color)}
            label={"color"}
            style={"border-b-2 border-purple border-dotted"}
            bgAndTxt={"bg-maize text-purple  border-purple"}
            handleChange={(value) => {
              formRef.current.color = value;
              console.log("ref: ", formRef);
            }}
          />
        )}
        {voices && (
          <DropdownSelect
            options={voices.map((voice) => voice.voice)}
            label={"voice"}
            style={"border-b-2 border-purple border-dotted"}
            bgAndTxt={"bg-maize text-purple border-purple"}
            handleChange={(value) => {
              formRef.current.voice = value;
              console.log("ref: ", formRef);
            }}
          />
        )}
        {furTypes && (
          <DropdownSelect
            options={furTypes.map((type) => type.furType)}
            label={"fur type"}
            style={"border-b-2 border-purple border-dotted"}
            bgAndTxt={"bg-maize text-purple border-purple"}
            handleChange={(value) => {
              formRef.current.furType = value;
              console.log("ref: ", formRef);
            }}
          />
        )}
        {furPatterns && (
          <DropdownSelect
            options={furPatterns.map((pattern) => pattern.furPattern)}
            label={"fur Pattern"}
            style={"border-b-2 border-purple border-dotted"}
            bgAndTxt={"bg-maize text-purple border-purple"}
            handleChange={(value) => {
              formRef.current.furPattern = value;
              console.log("ref: ", formRef);
            }}
          />
        )}
      </div>
      <Button handleClick={submitForm} content={"Submit"} />
    </Page>
  );
};

export default CreateBear;

interface Form {
  name: string;
  color: string;
  voice: string;
  furType: string;
  furPattern: string;
}

interface Fetch {
  <T>(url: string, setFunction: (data: T[]) => void): void;
}
