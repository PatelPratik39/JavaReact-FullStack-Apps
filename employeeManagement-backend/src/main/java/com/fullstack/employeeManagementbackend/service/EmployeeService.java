package com.fullstack.employeeManagementbackend.service;

import com.fullstack.employeeManagementbackend.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {
//    Creeta a method for createEmployee where I am passing employeeDTO object
    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

//    Create a method for getEmployee where i am passing parameter as employeeId so i can get emaployee from database
//    through employee id next i need to go to ServiceImpl class for implementation

    EmployeeDTO getEmployeeById(Long employeeId);

//    GetAll Employee Method
        List<EmployeeDTO> getAllEmployees();

//        Update Employee Method
//     I am using 2 parameters where 1 parameter is employeeId abd second paramenter is EmployeeDTO
    EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee);

//    DELETE Employee method
    void deleteEmployee(Long employeeId);

}
