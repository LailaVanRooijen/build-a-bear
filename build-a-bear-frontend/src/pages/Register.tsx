import { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import FieldInput from "../components/FieldInput";
import Page from "../components/Page";
import { useAuth } from "../context/AuthContext";

const Register = () => {
  const navigate = useNavigate();
  const [firstName, setfirstName] = useState<string>();
  const [lastName, setLastName] = useState<string>();
  const [email, setEmail] = useState<string>();
  const [password, setPassword] = useState<string>();
  const [comfirmPassword, setComfirmPassword] = useState<string>();
  const { register } = useAuth();
  const [showMsg, setShowMsg] = useState<boolean>(false);
  const [errorMsg, setErrorMsg] = useState<string>("");

  useEffect(() => {}, [showMsg]);

  const showError = () => {
    setShowMsg(true);
    setTimeout(() => {
      setShowMsg(false);
    }, 3000);
  };

  const handleRegister = () => {
    if (password !== comfirmPassword) {
      setErrorMsg("passwords don't match");
      showError();
      return;
    }
    if (
      firstName === "" ||
      lastName === "" ||
      email === "" ||
      password === "" ||
      comfirmPassword === ""
    ) {
      showError();
      return;
    }
    register(firstName, lastName, email, password, comfirmPassword)
      .then((response) => {
        if (response === undefined) {
          navigate("/home");
        }
      })
      .catch((err) => {
        setErrorMsg("a user with that email already exists");
        showError();
        console.log(err.message);
      });
  };

  return (
    <Page style={"flex flex-row justify-center items-center"}>
      <div className="bg-maize rounded-lg w-fit text-purple">
        <h2 className="font-extrabold text-xl bg-purple text-maize p-2 border-t-2 border-x-2 border-maize min-h-16 flex flex-row items-center justify-center">
          Register
        </h2>
        <div className="w-[500px]">
          <p className="text-center h-10 text-red-900 font-extrabold">
            {showMsg ? `${errorMsg}` : ""}
          </p>
          <FieldInput
            label={"firstname"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              setfirstName(value);
            }}
          />
          <FieldInput
            label={"lastname"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              setLastName(value);
            }}
          />
          <FieldInput
            label={"email"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              setEmail(value);
            }}
          />
          <FieldInput
            label={"password"}
            content={""}
            style={"space-x-10 my-3  mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            type={"password"}
            handleChange={(value) => {
              setPassword(value);
            }}
          />
          <FieldInput
            label={"comfirm password"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            type={"password"}
            handleChange={(value) => {
              setComfirmPassword(value);
            }}
          />
        </div>
        <div className="flex flex-row w-full items-center justify-center">
          <Button
            content={"submit"}
            defaultColor={true}
            style={"w-30 self-center"}
            handleClick={handleRegister}
          />
        </div>
        <div className="p-2 text-center font-bold">
          <p>
            Already have an account? {""}
            <span
              onClick={() => {
                navigate("/login");
              }}
              className="font-extrabold text-lg border-b-2 border-purple cursor-pointer"
            >
              Sign in
            </span>
          </p>
        </div>
      </div>
    </Page>
  );
};

export default Register;
