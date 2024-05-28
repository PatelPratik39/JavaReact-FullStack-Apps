/*
    Department Form
*/

import React, { useEffect } from "react";
import { useState } from "react";
import {
  createDepartment,
  getDepartmentById,
  updateDepartment
} from "../services/DepartmentService";
import { useNavigate, useParams } from "react-router-dom";

const Department = () => {
  const [departmentName, setDepartmentName] = useState("");
  const [departmentDescription, setDepartmentDescription] = useState("");
  const navigate = useNavigate();
  const { id } = useParams();

  useEffect(() => {
    getDepartmentById(id)
      .then((response) => {
        setDepartmentName(response.data.departmentName);
        setDepartmentDescription(response.data.departmentDescription);
      })
      .catch((error) => {
        console.log(error);
      });
  }, [id]);

  const saveOrUpdateDepartment = (e) => {
    e.preventDefault();
    const department = { departmentName, departmentDescription };
    console.log(department);
    if (id) {
      updateDepartment(id, department)
        .then((reponse) => {
          console.log(reponse.data);
          navigate("/departments");
        })
        .catch((error) => {
          console.log(error);
        });
    } else {
      createDepartment(department)
        .then((response) => {
          console.log(response.data);
          navigate("/departments");
        })
        .catch((error) => {
          console.log(error);
        });
    }
  };

  const pageTitle = () => {
    if (id) {
      return <h2 className="text-center">Update Department</h2>;
    } else {
      return <h2 className="text-center">Add Department</h2>;
    }
  };
  return (
    <>
      <div className="container">
        <br />
        <br />
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            {/* <h2 className="text-center">Add Department</h2> */}
            {pageTitle()}
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">
                    <b> Name : </b>
                  </label>
                  <input
                    type="text"
                    name="departmentName"
                    placeholder="Enter Department Name"
                    value={departmentName}
                    onChange={(e) => setDepartmentName(e.target.value)}
                    className="form-control"
                  />
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">
                    <b> Descriptipon : </b>
                  </label>
                  <input
                    type="text"
                    name="departmentDescription"
                    placeholder="Enter Department Description"
                    value={departmentDescription}
                    onChange={(e) => setDepartmentDescription(e.target.value)}
                    className="form-control"
                  />
                </div>
                <div className="d-flex justify-content-center mt-4">
                  <button
                    className="btn btn-success btn-lg btn-block"
                    onClick={(e) => saveOrUpdateDepartment(e)}
                  >
                    Submit
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default Department;
