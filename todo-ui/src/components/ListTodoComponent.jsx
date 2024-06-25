// eslint-disable-next-line no-unused-vars
import React, { useEffect, useState } from "react";
import { deleteTodo, getAllTodos } from "../services/TodoService";
import { useNavigate } from "react-router-dom";

const ListTodoComponent = () => {
  const [todos, setTodos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listTodos();
  }, []);

  const listTodos = () => {
    getAllTodos()
      .then((response) => setTodos(response.data))
      .catch((error) => console.error(error));
  };

  const addTodo = () => {
    navigate("/add-todo");
  };
  const updateTodo = (id) => {
    console.log(id);
    navigate(`/update-todo/${id}`);
  };

  const removeTodo = (id) => {
    console.log(id);
    deleteTodo(id)
      .then((response) => {
        console.log(response.data);
        listTodos();
      })
      .catch((error) => {
        console.error(error);
      });
    alert("Todo deleted successfully");
  };

  return (
    <div className="container">
      <h2 className="text-center">List of Todos</h2>
      <button className="btn btn-success mb-2" onClick={addTodo}>
        Add Todos
      </button>
      <div>
        <table className="table table-bordered table-striped text-center">
          <thead>
            <tr>
              <th>Todo ID</th>
              <th>Todo Title</th>
              <th>Todo Description</th>
              <th>Todo Completed</th>
              <th>Actions</th>
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
                  <td>
                    <button
                      className="btn btn-warning"
                      onClick={() => updateTodo(todo.id)}
                    >
                      Update
                    </button>
                    <button
                      className="btn btn-danger"
                      onClick={() => removeTodo(todo.id)}
                      style={{ marginLeft: "10px" }}
                    >
                      Delete
                    </button>
                  </td>
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
