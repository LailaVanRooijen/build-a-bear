import axios from "axios";

const URL = "http://localhost:8080/api/v1/";

export default function useAxios(): AxiosProps {
  const getRequest = (path, params) => {
    return axios
      .get(URL + path, {
        params,
        paramsSerializer: { indexes: null },
      })
      .then((response) => response.data)
      .catch((err) => console.error(err));
  };

  const postRequest = (path, data, token) => {
    return axios
      .post(URL + path, data, { headers: createHeader(token) })
      .then((response) => response.data)
      .catch((err) => console.error(err));
  };

  const patchRequest = (path, patchBody) => {
    return axios
      .patch(URL + path, patchBody, {})
      .catch((err) => console.error(err));
  };

  const deleteRequest = (path, id) => {
    return axios.delete(URL + path).catch((err) => console.error(err));
  };

  return {
    getRequest,
    postRequest,
    patchRequest,
    deleteRequest,
  };
}

const createHeader = (token) => {
  if (token !== null) {
    return {
      Authorization: `Bearer ${token}`,
      "Content-Type": "application/json",
    };
  } else {
    return {
      "Content-Type": "application/json",
    };
  }
};

interface AxiosProps {
  getRequest: (path: string, params?: {}, token?: string) => Promise<Any>;
  postRequest: (
    path: string,
    postBody?: {},
    token?: {},
    token?: string
  ) => Promise<Any>;
}
