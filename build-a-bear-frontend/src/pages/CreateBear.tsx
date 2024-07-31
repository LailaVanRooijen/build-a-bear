import { useEffect, useRef, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import DisplayRow from "../components/DisplayRow";
import DropdownSelect from "../components/DropdownSelect";
import FieldInput from "../components/FieldInput";
import ImageUpload from "../components/ImageUpload";
import Page from "../components/Page";
import { useAuth } from "../context/AuthContext";
import useAxios from "../hooks/useAxios";
import {
  IColor,
  IFurPattern,
  IFurType,
  IOutfit,
  IVoice,
} from "../interfaces/IBearProps";

const CreateBear = () => {
  const navigate = useNavigate();
  const { token } = useAuth();
  const { getRequest, postRequest } = useAxios();
  const [colors, setColors] = useState<IColor[] | null>(null);
  const [voices, setVoices] = useState<IVoice[] | null>(null);
  const [furTypes, setFurTypes] = useState<IFurType[] | null>(null);
  const [furPatterns, setFurPatterns] = useState<IFurPattern[] | null>(null);
  const [outfits, setOutfits] = useState<IOutfit[] | null>(null);
  const [selectedOutfit, setSelectedOutfit] = useState<IOutfit | null>(null);
  const [image, setImage] = useState<>(null);
  const formRef = useRef<Form>({
    name: "",
    color: "",
    voice: "",
    furType: "",
    furPattern: "",
    outfit: "",
  });
  const [showMsg, setShowMsg] = useState<boolean>(false);

  const showError = () => {
    setShowMsg(true);
    setTimeout(() => {
      setShowMsg(false);
    }, 3000);
  };

  const fetch: Fetch = (url, setFunction) => {
    getRequest(url, {}, token).then((response) => {
      setFunction(response);
    });
  };

  const post: BuildBear = (url) => {
    if (
      formRef.current.name === "" ||
      formRef.current.color === "" ||
      formRef.current.voice === "" ||
      formRef.current.furType === "" ||
      formRef.current.furPattern === "" ||
      formRef.current.outfit === ""
    ) {
      showError();
      return;
    }
    const params = {
      name: formRef.current.name,
      color: formRef.current.color,
      voice: formRef.current.voice,
      furType: formRef.current.furType,
      furPattern: formRef.current.furPattern,
      outfit: formRef.current.outfit,
    };
    postRequest(url, params, token)
      .then((response) => {
        console.log(response);
        navigate(`/bears/${response.id}`);
      })
      .catch((err) => {
        if (err.message.includes("status code 403")) {
          navigate("/login");
        } else if (err.message.includes("status code 404")) {
          showError();
        }
        console.error("Failed to create bear, ", err.message);
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
    post("bears");
  };

  return (
    <Page style="flex flex-col items-center justify-center">
      <h1 className="cursor-pointer my-12 text-5xl font-extrabold text-purple h-fit p-6 rounded-lg bg-gradient-to-br from-sand from-10% to-maize to-90% border-4 border-white hover:bg-gradient-to-tr hover:shadow-card-hover-sand">
        Build-a-bear
      </h1>
      <div className="border-2 bg-maize text-purple font-extrabold border-purple rounded-lg p-12 w-1/2">
        <p className="h-10 text-red-900 font-extrabold">
          {showMsg ? "Fill in all fields" : ""}
        </p>
        <ImageUpload />
        <FieldInput
          label={"Name"}
          content={""}
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
            }}
          />
        )}

        {outfits && (
          <DropdownSelect
            options={outfits.map((outfit) => outfit.name)}
            label={"outfit"}
            style={"border-b-2 border-purple border-dotted"}
            bgAndTxt={"bg-maize text-purple border-purple"}
            handleChange={(value) => {
              formRef.current.outfit = value;
              const selected = outfits.find((outfit) => outfit.name === value);
              setSelectedOutfit(selected || null);
            }}
          />
        )}

        <div className="w-full min-h-72 rounded-lg p-3 mt-6">
          <h1 className="text-center p-4 font-extrabold text-2xl">
            {selectedOutfit ? "Selected outfit" : "No outfit selected"}
          </h1>
          {selectedOutfit && (
            <>
              <div>
                <DisplayRow
                  label={"Head"}
                  content={selectedOutfit.head}
                  isDefaultStyle={true}
                />
                <DisplayRow label={"Chest"} content={selectedOutfit.chest} />
                <DisplayRow
                  label={"Feet"}
                  content={selectedOutfit.feet}
                  isDefaultStyle={true}
                />
              </div>
            </>
          )}
        </div>
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
  outfit: string;
}

interface Fetch {
  <T>(url: string, setFunction: (data: T[]) => void): void;
}
