import { createContext, useContext, useState } from "react";
import { useNavigate } from "react-router-dom";
import useAxios from "../hooks/useAxios";

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(getCookie("token") || null);
  const [user, setUser] = useState(null); //TODO
  const navigate = useNavigate();

  const login = (email: string, password: string) => {
    const body = { email: email, password: password };
    const { postRequest } = useAxios();
    postRequest("auth/login", body).then((response) => {
      console.log(response);
      setCookie("token", response.token);
      setToken(response.token);
    });
  };

  const logout = () => {
    setUser(null);
    setToken("");
    // TODO clear cookie
    navigate("/Login");
  };

  const value = {
    token,
    login,
    logout,
  };

  return <AuthContext.Provider value={value}>{children}</AuthContext.Provider>;
};

const setCookie = (nameOfCookie, cookieContent) => {
  document.cookie = `${nameOfCookie}=${cookieContent}; SameSite=None; Secure`;
};

const getCookie = (nameOfCookie) => {
  let name = nameOfCookie + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let cookieArray = decodedCookie.split(";");
  let found = cookieArray.find((cookie) => cookie.trim().startsWith(name));
  return found ? found.trim().substring(name.length) : null;
};
