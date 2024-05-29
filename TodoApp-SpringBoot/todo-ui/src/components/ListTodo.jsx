import React, { useState, useEffect } from "react";
import { completedTodo, deleteTodo, getAllTodos, inCompletedTodo } from "../services/TodoService";
import { useNavigate } from "react-router-dom";

const ListTodo = () => {
  const [todos, setTodos] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listTodos();
  }, []);

  const listTodos = () => {
    getAllTodos()
      .then((resposne) => {
        console.log(resposne.data);
        setTodos(resposne.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const addNewTodo = () => {
    navigate("/addTodo");
  };
  const updateTodo = (id) => {
    console.log(id);
    navigate(`/updateTodo/${id}`);
  };

  // DELETE Todo
  const removeTodo = (id) => {
    deleteTodo(id)
      .then((response) => {
        listTodos();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  // Complete Todo

  const completeTodo = (id) => {
    completedTodo(id)
      .then((response) => {
        listTodos();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  // In-Complete Todo

  const notCompleted = (id) => {
    inCompletedTodo(id)
      .then((response) => {
        listTodos();
      })
      .catch((error) => {
        console.error(error);
      });
  };
  return (
    <>
      <div className="container-fluid">
        <h2 className="text-center"> List of Todos </h2>
        <button className="btn btn-info mb-3" onClick={addNewTodo}>
          Add Todo
        </button>
        <div>
          <table className="table table-bordered table-striped">
            <thead>
              <tr className="text-center">
                <td> ID</td>
                <td> Title</td>
                <td> Description</td>
                <td> Completed Status</td>
                <td> Actions </td>
              </tr>
            </thead>
            <tbody>
              {todos.map((todo) => (
                <tr key={todo.id} className="text-center">
                  <td>{todo.id}</td>
                  <td>{todo.title}</td>
                  <td>{todo.description}</td>
                  <td>{todo.completed ? "Yes" : "No"}</td>
                  <td>
                    <button
                      className="btn btn-warning"
                      onClick={() => updateTodo(todo.id)}
                    >
                      {" "}
                      Update{" "}
                    </button>
                    <button
                      className="btn btn-danger"
                      onClick={() => removeTodo(todo.id)}
                      style={{ marginLeft: "10px" }}
                    >
                      {" "}
                      Delete{" "}
                    </button>
                    <button
                      className="btn btn-success"
                      onClick={() => completeTodo(todo.id)}
                      style={{ marginLeft: "10px" }}
                    >
                      {" "}
                      Complete{" "}
                    </button>
                    <button
                      className="btn btn-primary"
                      onClick={() => notCompleted(todo.id)}
                      style={{ marginLeft: "10px" }}
                    >
                      {" "}
                      InComplete{" "}
                    </button>
                  </td>
                </tr>
              ))}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default ListTodo;
