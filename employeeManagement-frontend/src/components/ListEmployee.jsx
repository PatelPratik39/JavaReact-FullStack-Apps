import React from "react";

const ListEmployee = () => {
  const dumyData = [
    {
      id: 1,
      firstName: "Gaddha",
      lastName: "Prasad",
      email: "gaddha@email.com"
    },
    {
      id: 2,
      firstName: "Mangoo",
      lastName: "Mochie",
      email: "mangoo@email.com"
    },
    {
      id: 3,
      firstName: "lallu Lal",
      lastName: "Singh",
      email: "lallu@email.com"
    }
  ];
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
            {dumyData.map((employee) => (
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
