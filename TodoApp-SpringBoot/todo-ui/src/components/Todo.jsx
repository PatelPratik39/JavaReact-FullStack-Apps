import React from "react";
import { useState } from "react";
import { saveTodo } from "../services/TodoService";
import { useNavigate } from "react-router-dom";

const Todo = () => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [completed, setCompleted] = useState(false);
  const navigate = useNavigate();

  const saveOrUpdateTodo = (e) => {
    e.preventDefault();
    const todo = { title, description, completed };
    console.log(todo);
    saveTodo(todo)
      .then((response) => {
        console.log(response.data);
        navigate("/todos");
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <div className="container">
      {" "}
      <br />
      <br />
      <div className="row">
        <div className="card col-md-6 offset-md-3 offset-md-3">
          <h2 className="text-center">Add Todo </h2>
          <div className="card-body">
            <form>
              <div className="form-group mb-2">
                <label className="form-label">
                  {" "}
                  <b>Title : </b>
                </label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Title"
                  name="title"
                  value={title}
                  onChange={(e) => setTitle(e.target.value)}
                />
              </div>

              <div className="form-group mb-2">
                <label className="form-label">
                  {" "}
                  <b>Description : </b>
                </label>
                <input
                  type="text"
                  className="form-control"
                  placeholder="Enter Description"
                  name="description"
                  value={description}
                  onChange={(e) => setDescription(e.target.value)}
                />
              </div>

              <div className="form-group mb-2">
                <label className="form-label">
                  {" "}
                  <b>Completed : </b>
                </label>
                <select
                  className="form-control"
                  value={completed}
                  onChange={(e) => setCompleted(e.target.value === "true")}
                >
                  <option value="false">NO</option>
                  <option value="true">YES</option>
                </select>
              </div>
              <div className="d-flex justify-content-center">
                <button className="btn btn-info" onClick={saveOrUpdateTodo}>
                  {" "}
                  Submit
                </button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Todo;
