import { Route, Routes } from "react-router-dom";
import "./App.css";
import NavBar from "./components/NavBar";
import { AuthProvider } from "./context/AuthContext";
import Bears from "./pages/Bears";
import BearView from "./pages/BearView";
import CreateBear from "./pages/CreateBear";
import Home from "./pages/Home";
import Login from "./pages/Login";
import Register from "./pages/Register";

function App() {
  return (
    <>
      <AuthProvider>
        <NavBar />
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/home" element={<Home />} />
          <Route path="/buy-a-bear" element={<Bears />} />
          <Route path="/build-a-bear" element={<CreateBear />} />
          <Route path="/bears/:id" element={<BearView />} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
        </Routes>
      </AuthProvider>
    </>
  );
}

export default App;
