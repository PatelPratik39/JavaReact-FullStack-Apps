package com.fullstack.employeeManagementbackend.service;

import com.fullstack.employeeManagementbackend.dto.DepartmentDTO;

import java.util.List;

public interface DepartmentService {
//    Create Department method using departmentDTO as parameter
    DepartmentDTO createDepartment(DepartmentDTO departmentDTO);

//    Get Department by ID method
    DepartmentDTO getDepartmentById(Long departmentId);

//    GET All Departments
    List<DepartmentDTO> getAllDepartments();

//    UPDATE (PUT) Department
    DepartmentDTO updatedDepartment(Long departmentId, DepartmentDTO updateDepartment);

//    DELETE Department
    void deleteDepartment(Long departmentId);
}
