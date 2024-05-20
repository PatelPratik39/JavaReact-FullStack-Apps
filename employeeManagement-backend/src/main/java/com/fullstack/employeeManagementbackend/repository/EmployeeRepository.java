package com.fullstack.employeeManagementbackend.repository;

import com.fullstack.employeeManagementbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
