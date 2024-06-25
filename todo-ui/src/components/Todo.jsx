import { useEffect, useState } from "react";
import { getTodo, saveTodo, updateTodo } from "../services/TodoService";
import { useNavigate, useParams } from "react-router-dom";

const Todo = () => {
  const [title, setTitle] = useState("");
  const [description, setDescription] = useState("");
  const [completed, setCompleted] = useState(false);
  const navigate = useNavigate();
  const { id } = useParams();

  const saveOrUpdateTodo = (e) => {
    e.preventDefault();
    const todo = { title, description, completed };
    console.log(todo);

    if (id) {
      updateTodo(id, todo)
        .then((response) => {
          console.log(response.data);
          navigate("/todos");
        })
        .catch((error) => {
          console.error(error);
        });
    } else {
      saveTodo(todo)
        .then((response) => {
          console.log(response.data);
          navigate("/todos");
        })
        .catch((error) => {
          console.error(error);
        });
    }
  };

  const pageTitle = () => {
    if (id) {
      return <h2 className="text-center">Update Todo </h2>;
    } else {
      return <h2 className="text-center">Add Todo </h2>;
    }
  };

  useEffect(() => {
    if (id) {
      getTodo(id)
        .then((response) => {
          console.log(response.data);
          setTitle(response.data.title);
          setDescription(response.data.description);
          setCompleted(response.data.completed);
        })
        .catch((error) => console.error(error));
    }
  }, [id]);

  return (
    <>
      <div className="container">
        <br /> <br />
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {pageTitle()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">
                    <b> Title : </b>
                  </label>
                  <input
                    type="text"
                    placeholder="Enter Todo Title"
                    className="form-control"
                    name="title"
                    value={title}
                    onChange={(e) => setTitle(e.target.value)}
                  />
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">
                    <b> Description : </b>
                  </label>
                  <input
                    className="form-control"
                    type="text"
                    placeholder="Enter Todo Title"
                    name="description"
                    value={description}
                    onChange={(e) => setDescription(e.target.value)}
                  />
                </div>

                <div className="form-group mb-2">
                  <label className="form-label">
                    <b> Completed : </b>
                  </label>
                  <select
                    className="form-control"
                    value={completed}
                    onChange={(e) => setCompleted(e.target.value)}
                  >
                    <option value="false">No</option>
                    <option value="true">Yes</option>
                  </select>
                </div>

                <button
                  className="btn btn-success w-100 mt-3"
                  onClick={(e) => saveOrUpdateTodo(e)}
                >
                  Submit{" "}
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Todo;
