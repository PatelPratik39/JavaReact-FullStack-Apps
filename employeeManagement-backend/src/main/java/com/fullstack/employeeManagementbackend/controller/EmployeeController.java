package com.fullstack.employeeManagementbackend.controller;

import com.fullstack.employeeManagementbackend.dto.EmployeeDTO;
import com.fullstack.employeeManagementbackend.service.EmployeeService;
import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

//    let's inject dependency from Service class
    private EmployeeService employeeService;

/*
        To Build createEmployee REST API, I need to create a method from service call
        I need to generic class with type, so I have ResponseEntity with type of "EmployeeDTO" class as type in <>
        provide a method of createEmployee with employeeDTO object as parameter
        return savedEmployee object from service class method
        and savedEmployee method will return with HTTPStatus code with CREATE(201).
        now annotate this method to POST using Postmapping annotation because I am posting a new Employee to the server and database.
        Also, i need to use @requestBody annotation because i need to convert a Jason object to Java Object for Employee.
 */
//    Let's Build Add Employee REST API
    @PostMapping
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO savedEmployee = employeeService.createEmployee(employeeDTO);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
/*
    To Build REST API for get employee by id from database using ResponseEntity as return type that generics so i need to pass EmployeeDTO as Type and use menthod
    getEmployeeId with employeeID parameter. now i need to use getEmployeeId method from employeeService class where employeeDTO is there so i need to create local variable
    from employeeDTO from EmployeeDTO class.
    After that i need to return ResponseEntity with ok() method with parameter of employeeDTO that is created as local variable.
    now i need to make this method as REST API, i need to annotate this method with @getMapimg with URI template "{id}" and @pathvariable

 */

//    Let's Build "GET" Employee REST API using employeeId
    @GetMapping("{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDTO);
    }

//    Let's Build "GET" All Employee REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        List<EmployeeDTO> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

//    Let's  Build UPDATE Employee REST API
    @PutMapping("{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long employeeId,
                                                       @RequestBody EmployeeDTO updatedEmployee){
        EmployeeDTO employeeDTO = employeeService.updateEmployee(employeeId, updatedEmployee);
        return ResponseEntity.ok(employeeDTO);
    }

//    Let's Build DELETE employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee Deleted Successfully!!!");
    }

}
