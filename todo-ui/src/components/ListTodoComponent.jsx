// eslint-disable-next-line no-unused-vars
import React, { useEffect, useState } from "react";
import { getAllTodos } from "../services/TodoService";
import { useNavigate } from "react-router-dom";


const ListTodoComponent = () => {
  const [todos, setTodos] = useState([]);
  const naviagte = useNavigate();

  useEffect(() => {
    const fetchData = () => {
      getAllTodos()
        .then((response) => setTodos(response.data))
        .catch((error) => console.error(error));
    };
    fetchData();
  }, []);

  const addTodo = () => {
    naviagte('/add-todo');
  }


  return (
    <div className="container">
      <h2 className="text-center">List of Todos</h2>
      <button className="btn btn-primary mb-2" onClick={addTodo}>Add Todos</button>
      <div>
        <table className="table table-bordered table-striped text-center">
          <thead>
            <tr>
              <th>Todo ID</th>
              <th>Todo Title</th>
              <th>Todo Description</th>
              <th>Todo Completed</th>
            </tr>
          </thead>
          <tbody>
            {todos.length > 0 ? (
              todos.map((todo) => (
                <tr key={todo.id}>
                  <td>{todo.id}</td>
                  <td>{todo.title}</td>
                  <td>{todo.description}</td>
                  <td>{todo.completed ? "Yes" : "No"}</td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="4">No todos available</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListTodoComponent;
