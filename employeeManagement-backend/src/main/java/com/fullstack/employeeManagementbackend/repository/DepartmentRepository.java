package com.fullstack.employeeManagementbackend.repository;

import com.fullstack.employeeManagementbackend.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
