import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import { listEmployees, deleteEmployee } from "../services/EmployeeService";

const ListEmployee = () => {
  const [employees, setEmployees] = useState([]);
  const navigate = useNavigate();

  useEffect(() => {
    getAllEmployees();
  }, []);

  const getAllEmployees = () => {
    listEmployees()
      .then((response) => {
        setEmployees(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const addNewEmployee = () => {
    navigate("/addEmployee");
  };

  const updateEmployee = (id) => {
    navigate(`/updateEmployee/${id}`);
  };
  const removeEmployee = (id) => {
    console.log(id);
    deleteEmployee(id)
      .then((response) => {
        getAllEmployees();
      })
      .catch((error) => console.log(error));
  };

  //   JSX section below
  return (
    <>
      <div className="container">
        <h2 className="text-center"> List of Employees</h2>
        <button
          type="button"
          className="btn btn-success mb-3 "
          onClick={addNewEmployee}
        >
          Add Employee
        </button>
        <table className="table table-striped table-bordered table-hover ">
          <thead>
            <tr className="text-center table-info p-5">
              <th className="table-suceess"> Emp Id </th>
              <th className="table-warning"> Emp First Name </th>
              <th className="table-danger"> Emp Last Name </th>
              <th className="table-primary"> Emp Email </th>
              <th className="table-info"> Actions </th>
            </tr>
          </thead>
          <tbody className="text-center">
            {employees.map((employee) => (
              <tr key={employee.id}>
                <td>{employee.id}</td>
                <td>{employee.firstName}</td>
                <td>{employee.lastName}</td>
                <td>{employee.email}</td>
                <td>
                  <button
                    className="btn btn-warning"
                    onClick={() => updateEmployee(employee.id)}
                  >
                    Update
                  </button>
                  <button
                    className="btn btn-danger"
                    onClick={() => removeEmployee(employee.id)}
                    style={{marginLeft:'20px'}}
                  >
                    Delete
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

export default ListEmployee;
