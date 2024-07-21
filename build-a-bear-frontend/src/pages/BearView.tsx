import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import Field from "../components/Field";
import NotFound from "../components/NotFound";
import Page from "../components/Page";
import Panel from "../components/Panel";
import useAxios from "../hooks/useAxios";
import { IBear } from "../interfaces/Ibear";

const BearView = () => {
  const { id } = useParams();
  const { getRequest } = useAxios();
  const [bear, setBear] = useState<IBear | null>(null);

  const fetch: Fetch = (url, setFunction) => {
    getRequest(url)
      .then((response) => {
        setFunction(response);
        console.log(response);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    fetch<IBear>(`bears/${id}`, setBear);
  }, []);
  return (
    <>
      {bear == null ? (
        <NotFound />
      ) : (
        <Page style={"flex flex-col items-center pt-12"}>
          {bear && (
            <>
              <h1 className="text-5xl font-extrabold bg-maize text-purple h-fit p-6 rounded-lg">
                {bear.name}
              </h1>
              <div className="flex justify-between gap-6 py-12 px-6 w-full">
                <Panel style="p-6 w-1/2 min-h-96 bg-maize rounded-lg">
                  <Field
                    style={"bg-purple"}
                    textColor={"text-maize"}
                    label={"Color"}
                    content={bear.color}
                  />
                  <Field
                    style={"bg-maize"}
                    textColor={"text-purple"}
                    label={"Pattern"}
                    content={"TODO"}
                  />
                  <Field
                    style={"bg-purple"}
                    textColor={"text-maize"}
                    label={"Fur Type"}
                    content={"TODO"}
                  />
                </Panel>
                <Panel style="p-6 w-1/2 min-h-96">
                  <Field
                    style={"bg-maize"}
                    textColor={"text-purple"}
                    label={"Outfit"}
                    content={bear.outfit}
                  />
                  <Field
                    style={"bg-purple"}
                    textColor={"text-maize"}
                    label={"Head"}
                    content={bear.head}
                  />
                  <Field
                    style={"bg-maize"}
                    textColor={"text-purple"}
                    label={"Chest"}
                    content={bear.chest}
                  />
                  <Field
                    style={"bg-purple"}
                    textColor={"text-maize"}
                    label={"Feet"}
                    content={bear.feet}
                  />
                </Panel>
              </div>
            </>
          )}
        </Page>
      )}
    </>
  );
};

export default BearView;

interface Fetch {
  <T>(
    url: string,
    setFunction: React.Dispatch<React.SetStateAction<T | null>>
  ): void;
}
