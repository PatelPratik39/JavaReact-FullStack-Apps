import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listEmployees } from "../services/EmployeeService";

const ListEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  const addNewEmployee = () => {
    navigate('/addEmployee')
  }

  //   JSX section below
  return (
    <>
      <div className="container">
        <h2 className="text-center"> List of Employees</h2>
        <button type="button" class="btn btn-success mb-3 " onClick={addNewEmployee}>
          Add Employee
        </button>
        <table className="table table-striped table-bordered table-hover ">
          <thead>
            <tr className="text-center table-info p-5">
              <th className="table-suceess"> Emp Id </th>
              <th className="table-warning"> Emp First Name </th>
              <th className="table-danger"> Emp Last Name </th>
              <th className="table-primary"> Emp Email </th>
            </tr>
          </thead>
          <tbody className="text-center">
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    </>
  );
};

export default ListEmployee;
