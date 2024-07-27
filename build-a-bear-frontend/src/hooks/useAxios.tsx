import axios from "axios";

const URL = "http://localhost:8080/api/v1/";

export default function useAxios(): AxiosProps {
  const getRequest = (path, params) => {
    return axios
      .get(URL + path, {
        params,
        paramsSerializer: { indexes: null },
      })
      .then((response) => response.data);
  };

  const postRequest = (path, data, token) => {
    if (token) {
      return axios
        .post(URL + path, data, { headers: createHeader(token) })
        .then((response) => response.data);
    } else {
      return axios.post(URL + path, data).then((response) => response.data);
    }
  };

  const patchRequest = (path, patchBody) => {
    return axios.patch(URL + path, patchBody, {});
  };

  const deleteRequest = (path, id) => {
    return axios.delete(URL + path);
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
    return {};
  }
};

interface AxiosProps {
  getRequest: (path: string, params?: {}, token?: string) => Promise<Any>;
  postRequest: (path: string, data?: {}, token?: string) => Promise<Any>;
}
