import React, { useEffect, useState } from "react";
import {
  deleteDepartment,
  getAllDepartments
} from "../services/DepartmentService";
import { Link, useNavigate } from "react-router-dom";

const ListDepartment = () => {
  const [departments, setDepartments] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listOfDepartments();
  }, []);

  const listOfDepartments = () => {
    getAllDepartments()
      .then((response) => {
        console.log(response.data);
        setDepartments(response.data);
      })
      .catch((error) => {
        console.error(error);
      });
  };

  const handleUpdate = (id) => {
    navigate(`/updateDepartment/${id}`);
  };

  const handleDelete = (id) => {
    deleteDepartment(id)
      .then((response) => {
        console.log(response.data);
        listOfDepartments();
      })
      .catch((error) => {
        console.error(error);
      });
  };

  return (
    <>
      <div className="container">
        <h2 className="text-center">List of Departments </h2>
        <Link to="/addDepartment" className="btn btn-success mb-3">
          Add Department
        </Link>
        <table className="table table-striped table-bordered table-hover ">
          <thead className="text-center">
            <tr className="text-center table-info p-5">
              <th className="table-success">Department Id</th>
              <th className="table-primary">Department Name</th>
              <th className="table-info">Department Description</th>
              <th className="table-danger">Actions</th>
            </tr>
          </thead>
          <tbody className="text-center">
            {departments.map((department) => (
              <tr key={department.id}>
                <td>{department.id}</td>
                <td>{department.departmentName}</td>
                <td>{department.departmentDescription}</td>
                <td>
                  <button
                    onClick={() => handleUpdate(department.id)}
                    className="btn btn-warning"
                  >
                    <i className="bi bi-pencil-square">
                      <img src="/pencil-square.svg" />
                    </i>
                  </button>
                  <button
                    onClick={() => handleDelete(department.id)}
                    style={{ marginLeft: "20px" }}
                    className="btn btn-danger"
                  >
                    <i className="bi bi-trash3">
                      <img src="/trash3-fill.svg" />
                    </i>
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default ListDepartment;
