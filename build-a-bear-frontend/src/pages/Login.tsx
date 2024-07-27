import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import FieldInput from "../components/FieldInput";
import Page from "../components/Page";
import { useAuth } from "../context/AuthContext";

const Login = () => {
  const navigate = useNavigate();
  const { login } = useAuth();
  const { token } = useAuth();
  const [email, setEmail] = useState<string>();
  const [password, setPassword] = useState<string>();
  const [showMsg, setShowMsg] = useState<boolean>(false);

  useEffect(() => {}, [token, showMsg]);

  const showError = () => {
    setShowMsg(true);
    setTimeout(() => {
      setShowMsg(false);
    }, 3000);
  };

  const handleLogin = () => {
    login(email, password)
      .then((response) => {
        console.log(response);
        if (response === undefined) {
          navigate("/build-a-bear");
        }
      })
      .catch((err) => {
        console.log(err.message);
        showError();
      });
  };
  return (
    <Page style={"flex flex-row justify-center items-center"}>
      <div className="bg-maize text-purple rounded-lg">
        <h2 className="font-extrabold text-xl bg-purple text-maize p-2 border-t-2 border-x-2 border-maize min-h-16 flex flex-row items-center justify-center">
          Login
        </h2>
        <p className="text-center text-red-900 p-2 min-h-10">
          {showMsg && "Invalid email or password"}
        </p>
        <div className="w-[500px]">
          <FieldInput
            label={"email"}
            content={""}
            style={"space-x-10 my-3  mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              setEmail(value);
            }}
          />
          <FieldInput
            label={"password"}
            type={"password"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              setPassword(value);
            }}
          />
        </div>
        <div className="flex flex-row w-full items-center justify-center">
          <Button
            content={"submit"}
            defaultColor={true}
            style={"w-30 self-center"}
            handleClick={handleLogin}
          />
        </div>
        <div className="py-4 px-2 text-center font-bold">
          <p>
            Don't have an account? {""}
            <span
              onClick={() => {
                navigate("/register");
              }}
              className="font-extrabold text-lg border-b-2 border-purple cursor-pointer"
            >
              Sign up
            </span>
          </p>
        </div>
      </div>
    </Page>
  );
};

export default Login;
