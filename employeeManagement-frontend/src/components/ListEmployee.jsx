import React, { useEffect, useState } from "react";
import { listEmployees } from "../services/EmployeeService";

const ListEmployee = () => {
  const [employees, setEmployees] = useState([]);

  useEffect(() => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  }, []);

  //   JSX section below
  return (
    <>
      <div className="conatiner">
        <h2 className="text-center"> List of Employees</h2>
        <table className="table table-striped table-bordered">
          <thead>
            <tr>
              <th> Emp Id </th>
              <th> Emp First Name </th>
              <th> Emp Last Name </th>
              <th> Emp Email </th>
            </tr>
          </thead>
          <tbody>
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
