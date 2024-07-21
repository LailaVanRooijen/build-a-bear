import { Route, Routes } from "react-router-dom";
import "./App.css";
import NavBar from "./components/NavBar";
import Bears from "./pages/Bears";
import BearView from "./pages/BearView";
import Home from "./pages/Home";

function App() {
  return (
    <>
      <NavBar />
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/home" element={<Home />} />
        <Route path="/bears" element={<Bears />} />
        <Route path="/bears/:id" element={<BearView />} />
      </Routes>
    </>
  );
}

export default App;
