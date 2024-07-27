import { createContext, useContext, useState } from "react";

const BearContext = createContext();

export const useBears = () => useContext(BearContext);

export const BearProvider = ({ children }) => {
  const [bears, setBears] = useState([]);
  // TODO make state for all customisation options

  value = {
    test: "some type of value",
  };
  return (
    <BearContext.Provider value={{ value }}>{children}</BearContext.Provider>
  );
};
