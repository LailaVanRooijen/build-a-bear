import { createContext, useContext, useState } from "react";
import useAxios from "../hooks/useAxios";

const AuthContext = createContext();

export const useAuth = () => useContext(AuthContext);

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(getCookie("token") || null);
  const [user, setUser] = useState(getCookie("user") || null);

  const login = (email: string, password: string) => {
    const body = { email: email, password: password };
    const { postRequest } = useAxios();

    return postRequest("auth/login", body).then((response) => {
      setCookie("user", email);
      setCookie("token", response.token);
      setToken(response.token);
      setUser(email);
    });
  };

  const logout = () => {
    setUser(null);
    setCookie("user", null);
    setToken("");
    setCookie("token", null);

    // TODO clear cookie
  };

  const value = {
    token,
    user,
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