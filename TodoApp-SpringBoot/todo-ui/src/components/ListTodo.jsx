import React, { useState, useEffect } from "react";
import { getAllTodos } from "../services/TodoService";

const ListTodo = () => {
  const [todos, setTodos] = useState([]);

  useEffect(() => {
    listTods();
  }, []);

  const listTods = () => {
    getAllTodos()
      .then((resposne) => {
        console.log(resposne.data);
        setTodos(resposne.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <>
      <div className="container">
        <h2 className="text-center"> List of Todos </h2>
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
                  <td>{todo.action}</td>
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
