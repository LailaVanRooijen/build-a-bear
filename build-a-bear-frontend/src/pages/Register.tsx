import { useNavigate } from "react-router-dom";
import Button from "../components/Button";
import FieldInput from "../components/FieldInput";
import Page from "../components/Page";
const Register = () => {
  const navigate = useNavigate();
  return (
    <Page style={"flex flex-row justify-center items-center"}>
      <div className="bg-maize rounded-lg w-fit text-purple">
        <h2 className="font-extrabold text-xl bg-purple text-maize p-2 border-t-2 border-x-2 border-maize min-h-16 flex flex-row items-center justify-center">
          Register
        </h2>
        <div className="w-[500px]">
          <FieldInput
            label={"email"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              console.log("username: ", value);
            }}
          />
          <FieldInput
            label={"password"}
            content={""}
            style={"space-x-10 my-3  mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              console.log("password: ", value);
            }}
          />
          <FieldInput
            label={"comfirm password"}
            content={""}
            style={"space-x-10 my-3 mx-4"}
            bgAndTxt={"bg-purple text-maize"}
            handleChange={(value) => {
              console.log("password: ", value);
            }}
          />
        </div>
        <div className="flex flex-row w-full items-center justify-center">
          <Button
            content={"submit"}
            defaultColor={true}
            style={"w-30 self-center"}
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
