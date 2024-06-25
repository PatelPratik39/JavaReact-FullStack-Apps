import Footer from "./components/Footer";
import Header from "./components/Header";
import ListTodoComponent from "./components/ListTodoComponent";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Todo from "./components/Todo";

function App() {
  return (
    <>
      <BrowserRouter>
        <Header />
        <Routes>
          <Route path="/" element={<ListTodoComponent />} />
          <Route path="/todos" element={<ListTodoComponent />} />
          <Route path="/add-todo" element={<Todo />} />
          <Route path="/update-todo/:id" element={<Todo />} />
        </Routes>
        <Footer />
      </BrowserRouter>
    </>
  );
}

export default App;
