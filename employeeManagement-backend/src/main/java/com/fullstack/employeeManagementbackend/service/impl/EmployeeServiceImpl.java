package com.fullstack.employeeManagementbackend.service.impl;

import com.fullstack.employeeManagementbackend.dto.EmployeeDTO;
import com.fullstack.employeeManagementbackend.entity.Employee;
import com.fullstack.employeeManagementbackend.exception.ResourceNotFoundException;
import com.fullstack.employeeManagementbackend.mapper.EmployeeMapper;
import com.fullstack.employeeManagementbackend.repository.EmployeeRepository;
import com.fullstack.employeeManagementbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl  implements EmployeeService {

    private EmployeeRepository employeeRepository;

    /*
    below createEmployee method I need to convert employeeDTO to Employee JPA entity
    because I need to store Employee entity to database
     */

    @Override
    public EmployeeDTO createEmployee(EmployeeDTO employeeDTO) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDTO);
//        now I want to add the employee object save into database means my employeeRepository, so I need to create
//        a variable where i will store

        Employee savedEmployee = employeeRepository.save(employee);
//        now I want to send the savedEmployee object to client using EmployeeMapper.maptoEMployeeDto method

        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }


    /*

    In order to create a method for getEmployee using employeeID, i need to check if id present or not ,
    so for that I need to create an Exception class -> exception package -> ResourceNotFoundException.

    Now to implement getEmployee Method , I need to create a local variable "employee" from Employee class
    where I am going to find an employee using employeeId from employee repository JPA, If employeeID( resource ) is not present then
    it should throw an exception message with given ID from "ResourceNotFoundException" class that extends RunTimeException class exception package.
    after that i need to return a employeeDTO so i need to convert employee JPA object into dto object using Mapper method with mapToEmployee method with JPA Entity Object (employee)
     */
    @Override
    public EmployeeDTO getEmployeeById(Long employeeId) {
       Employee employee =  employeeRepository.findById(employeeId).orElseThrow( () -> new ResourceNotFoundException ("Employee with given ID is not Exist !! : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

//    Get ALl Employees Implamentation
    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }

//    UpdateEmployee method
    @Override
    public EmployeeDTO updateEmployee(Long employeeId, EmployeeDTO updatedEmployee) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException(" Employee is not exists with given id : "+ employeeId));
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

       Employee updateEmployeeObj =  employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(updateEmployeeObj);
    }

//    DELETE Employee method using employeeId
    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException(" Employee is not exists with given id : "+ employeeId));

        employeeRepository.deleteById(employeeId);
    }


}
