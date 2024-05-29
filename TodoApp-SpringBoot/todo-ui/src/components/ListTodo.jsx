import React, { useState } from "react";

const ListTodo = () => {
  const dumyData = [
    {
      id: 1,
      title: "Learn SpringBoot",
      description:
        "SpringBoot is essential to learn for Full stack App Development",
      completed: true
    },
    {
      id: 2,
      title: "Learn MERN / PERN",
      description:
        "MERN is essential to learn for Full stack Skill Development for WEB Developers",
      completed: true
    },
    {
      id: 3,
      title: "Learn ReactJs",
      description: "React JS is best technologu for Front ENd Development",
      completed: false
    }
  ];
  const [todos, setTodos] = useState(dumyData);

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
