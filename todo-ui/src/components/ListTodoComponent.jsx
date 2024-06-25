// eslint-disable-next-line no-unused-vars
import React, { useState } from "react";

const ListTodoComponent = () => {
  const dumyData = [
    {
      id: 1,
      title: "Learn SpringBoot Learning",
      description: "SpringBoot is the future of AI world Tech",
      completed: true
    },
    {
      id: 2,
      title: "Learn React Learning",
      description: "React is the future of AI world Tech",
      completed: true
    },
    {
      id: 3,
      title: "Learn Machine Learning",
      description: "MachineLearning is the future of AI world Tech",
      completed: true
    }
  ];
  const [todos, setTodos] = useState(dumyData);

  return (
    <>
      <div className="container">
        <h2 className="text-center">List of Todos</h2>
        <div>
          <table className="table table-bordered table-striped text-center">
            <thead>
              <tr>
                <th style={{ background: "primary" }}>Todo id</th>
                <th>Todo Title</th>
                <th>Todo Descriotion</th>
                <th>Todo Completed</th>
              </tr>
            </thead>
            <tbody>
              {todos.map((todo) => 
                <tr key={todo.id}>
                  <td>{todo.id}</td>
                  <td>{todo.title}</td>
                  <td>{todo.description}</td>
                  <td>{todo.completed ? "Yes" : "No"}</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </div>
    </>
  );
};

export default ListTodoComponent;
