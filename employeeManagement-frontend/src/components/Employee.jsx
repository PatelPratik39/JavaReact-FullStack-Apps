import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import { createEmployee } from "../services/EmployeeService";

const Employee = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    lastName: "",
    email: ""
  });
  const [error, setError] = useState({});

  const navigate = useNavigate();

  const validate = () => {
    let errors = {};
    errors.firstName = formData.firstName ? "" : "First Name is required.";
    errors.lastName = formData.lastName ? "" : "Last Name is required.";
    errors.email = formData.email ? "" : "Email is required.";
    setError(errors);
    return Object.values(errors).every((x) => x === "");
  };

  const saveEmployee = (e) => {
    e.preventDefault();
    if (validate()) {
      const employee = { ...formData };
      console.log(employee);
      createEmployee(employee)
        .then((response) => {
          console.log(response.data);
          navigate("/employees");
          alert("User Registered Successfully!!!");
          setFormData({
            firstName: "",
            lastName: "",
            email: ""
          });
        })
        .catch((error) => {
          console.log(error);
          alert("An error occurred while registering the user.");
        });
    }
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value
    });
    setError({
      ...error,
      [name]: ""
    });
  };

  return (
    <>
      <div className="container">
        <br />
        <br />
        <div className="row">
          <div className="card col-md-6 offset-md-3 offset-md-3">
            <h2 className="text-center"> Add Employee</h2>
            <div className="card-body">
              <form>
                <div className="form-group mb-2">
                  <label className="form-label">
                    <b>First Name : </b>
                  </label>
                  <input
                    type="text"
                    placeholder="Enter First Name of Employee"
                    name="firstName"
                    value={formData.firstName}
                    className="form-control"
                    onChange={handleChange}
                  />
                  {error.firstName && (
                    <div className="text-danger">{error.firstName}</div>
                  )}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">
                    <b>Last Name : </b>
                  </label>
                  <input
                    type="text"
                    placeholder="Enter Last Name of Employee"
                    name="lastName"
                    value={formData.lastName}
                    className="form-control"
                    onChange={handleChange}
                  />
                  {error.lastName && (
                    <div className="text-danger">{error.lastName}</div>
                  )}
                </div>
                <div className="form-group mb-2">
                  <label className="form-label">
                    <b>Email : </b>
                  </label>
                  <input
                    type="text"
                    placeholder="Enter Email of Employee"
                    name="email"
                    value={formData.email}
                    className="form-control"
                    onChange={handleChange}
                  />
                  {error.email && (
                    <div className="text-danger">{error.email}</div>
                  )}
                </div>
                <div>
                  <button
                    type="submit"
                    className="btn btn-success col-md-6 offset-md-3"
                    onClick={saveEmployee}
                  >
                    Add Employee
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

export default Employee;
