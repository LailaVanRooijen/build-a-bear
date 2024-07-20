import { useEffect, useState } from "react";
import useAxios from "../hooks/useAxios";
const Bears = () => {
  const { getRequest } = useAxios();
  const [bears, setBears] = useState<[] | null>(null);

  const fetchBears = () => {
    getRequest("bears")
      .then((response) => {
        setBears(response);
        console.log(response);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  useEffect(() => {
    fetchBears();
  }, []);

  return (
    <>
      <div>
        <h1>PAGE FOR BEARS</h1>
        {bears && (
          <ul>
            {bears.map((bear) => (
              <li>{bear.name}</li>
            ))}
          </ul>
        )}
      </div>
    </>
  );
};

export default Bears;
