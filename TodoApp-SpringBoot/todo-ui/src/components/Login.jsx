import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { loginAPICall, storeToken } from "../services/AuthService";

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const navigate = useNavigate();

  const handleLogin = (e) => {
    e.preventDefault();
    loginAPICall(username, password)
      .then((response) => {
        console.log(response.data);

        // const token = "Basic" + window.btoa(username + ":" + password);
        // storeToken(token);

        navigate("/todos");
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <>
      <div className="container">
        <br />
        <br />
        <div className="row">
          <div className="col-md-6 offset-md-3">
            <div className="card">
              <div className="card-header">
                <h2 className="text-center"> User Login 🪪 </h2>
              </div>
              <div className="card-body">
                <form>
                  <div className="row mb-3">
                    <label className="col-md-3 control-label">
                      Username :{" "}
                    </label>
                    <div className="col-md-9">
                      <input
                        type="text"
                        placeholder="Enter Username or Email"
                        name="username"
                        className="form-control"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                      />
                    </div>
                  </div>

                  <div className="row mb-3">
                    <label className="col-md-3 control-label">
                      Password :{" "}
                    </label>
                    <div className="col-md-9">
                      <input
                        type="password"
                        placeholder="Enter Password"
                        name="password"
                        className="form-control"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                      />
                    </div>
                  </div>
                  <div className="form-group mt-5 mb-3 d-flex justify-content-center">
                    <button
                      className="btn btn-success w-50 "
                      onClick={(e) => handleLogin(e)}
                    >
                      {" "}
                      Login{" "}
                    </button>
                  </div>
                </form>
              </div>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Login;
