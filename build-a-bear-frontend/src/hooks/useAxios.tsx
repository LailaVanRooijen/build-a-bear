import axios from "axios";

const URL = "http://localhost:8080/api/v1/";

export default function useAxios(): AxiosProps {
  const getRequest = (path, params) => {
    return axios.get(URL + path, { params }).then((response) => response.data);
  };

  const postRequest = (path, postBody) => {
    return axios.post(URL + path, postBody).then((response) => response.data);
  };
  const patchRequest = (path, patchBody) => {
    return axios.patch(URL + path, patchBody);
  };

  const deleteRequest = (path, id) => {
    return axios.delete(URL + path, id);
  };

  return {
    getRequest,
    postRequest,
    patchRequest,
    deleteRequest,
  };
}

interface AxiosProps {
  getRequest: (path: string, params?: string) => Promise<Any>;
}
