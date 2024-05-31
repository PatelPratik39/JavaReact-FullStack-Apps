import "./App.css";
import Footer from "./components/Footer";
import Header from "./components/Header";
import ListTodo from "./components/ListTodo";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Todo from "./components/Todo";
import Register from "./components/Register";
import Login from "./components/Login";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<ListTodo />} />
          <Route path="/todos" element={<ListTodo />} />
          <Route path="/addTodo" element={<Todo />} />
          <Route path="/updateTodo/:id" element={<Todo />} />
          <Route path="/register" element={<Register />} />
          <Route path="/login" element={<Login />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
