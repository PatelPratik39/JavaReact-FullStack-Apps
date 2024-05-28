import "./App.css";
import Department from "./components/Department";
import Employee from "./components/Employee";
import Footer from "./components/Footer";
import Header from "./components/Header";
import ListDepartment from "./components/ListDepartment";
import ListEmployee from "./components/ListEmployee";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          {/* Employee */}
          <Route path="/" element={<ListEmployee />} />
          <Route path="/employees" element={<ListEmployee />} />
          <Route path="/addEmployee" element={<Employee />} />
          <Route path="/updateEmployee/:id" element={<Employee />} />
          {/* Department */}
          <Route path="/departments" element={<ListDepartment />} />
          <Route path="/addDepartment" element={<Department />} />
          <Route path="/updateDepartment/:id" element={<Department />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
