import { useEffect, useState } from "react";
import { useAuth } from "../context/AuthContext";
import useAxios from "../hooks/useAxios";

const ImageUpload = () => {
  const { getRequest, postRequest } = useAxios();
  const [imageSrc, setImageSrc] = useState<string>("");
  const { token } = useAuth();

  const fetch: Fetch = (url, params, token) => {
    getRequest(url, params, token).then((response) => {
      console.log(response);
      setImage(response);
    });
  };

  const handleChange = () => {
    const file = event?.target.files[0];
    if (file) {
      const reader = new FileReader();
      reader.onloadend = () => {
        setImageSrc(reader.result);
        getImage(file);
      };
      reader.readAsDataURL(file);
    }
  };

  useEffect(() => {
    fetch("images/paw.png", {}, token);
  }, [token]);

  return (
    <>
      <div className="border-2 rounded-lg border-black h-48 w-56 m-2 flex items-center justify-center p-2">
        <img src={imageSrc.toString()} className="h-full" />
      </div>
      <input
        type="file"
        id="img"
        name="img"
        accept="image/*"
        onChange={handleChange}
      />
    </>
  );
};

export default ImageUpload;

interface Fetch {
  <T>(url: string, setFunction: (data: T[]) => void): void;
}
