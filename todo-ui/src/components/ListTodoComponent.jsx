// eslint-disable-next-line no-unused-vars
import React, { useEffect, useState } from "react";
import {
  deleteTodo,
  getAllTodos,
  completeTodo,
  inCompleteTodo
} from "../services/TodoService";
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
    // console.log(id);
    navigate(`/update-todo/${id}`);
  };

  const removeTodo = (id) => {
    // console.log(id);
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

  const completedTodo = (id) => {
    completeTodo(id)
      .then((response) => {
        console.log(response.data);
        listTodos();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const InCompletedTodo = (id) => {
    inCompleteTodo(id)
      .then((response) => {
        console.log(response.data);
        listTodos();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div className="container" >
      <h2 className="text-center">List of Todos</h2>
      <button className="btn btn-success mb-2" onClick={addTodo}>
        Add Todos
      </button>
      <div style={{ overflowX: "auto" }}>
        <table
          className="table table-bordered table-striped text-center"

        >
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
                  <td style={{ whiteSpace: "nowrap" }}>
                    {" "}
                    {/* Prevent wrapping */}
                    <button
                      className="btn btn-warning"
                      onClick={() => updateTodo(todo.id)}
                      style={{ margin: "0 5px" }}
                    >
                      Update
                    </button>
                    <button
                      className="btn btn-danger"
                      onClick={() => removeTodo(todo.id)}
                      style={{ margin: "0 5px" }}
                    >
                      Delete
                    </button>
                    <button
                      className="btn btn-success"
                      onClick={() => completedTodo(todo.id)}
                      style={{ margin: "0 5px" }}
                    >
                      Complete
                    </button>
                    <button
                      className="btn btn-info"
                      onClick={() => InCompletedTodo(todo.id)}
                      style={{ margin: "0 5px" }}
                    >
                      InComplete
                    </button>
                  </td>
                </tr>
              ))
            ) : (
              <tr>
                <td colSpan="5">No Todos Available !! 🤷🏻‍♂️</td>
              </tr>
            )}
          </tbody>
        </table>
      </div>
    </div>
  );
};

export default ListTodoComponent;
