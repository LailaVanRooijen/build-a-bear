import { useEffect, useState } from "react";
import { useAuth } from "../context/AuthContext";
import useAxios from "../hooks/useAxios";

const ImageUpload = () => {
  const { getRequest, postRequest } = useAxios();
  const [image, setImage] = useState();
  const { token } = useAuth();

  const fetch: Fetch = (url, params, token) => {
    getRequest(url, params, token).then((response) => {
      console.log(response);
      setImage(response);
    });
  };

  useEffect(() => {
    fetch("images/paw.png", {}, token);
  }, [token]);

  return (
    <>
      <div className="border-2 rounded-lg border-black h-48 w-56 m-2">
        <img src={""} alt="" />
      </div>
      <input type="file" />
    </>
  );
};

export default ImageUpload;

interface Fetch {
  <T>(url: string, setFunction: (data: T[]) => void): void;
}
