package com.fullstack.employeeManagementbackend.mapper;

import com.fullstack.employeeManagementbackend.dto.DepartmentDTO;
import com.fullstack.employeeManagementbackend.entity.Department;

public class DepartmentMapper {

//    This Mapper class is used to convert department JPA entity into department DTO
    public  static DepartmentDTO mapToDepartmentDTO(Department department){
//        the return statement returns departmentDTO object by getter method department entity class
        return  new DepartmentDTO(
                department.getId(), department.getDepartmentName(), department.getDepartmentDescription()
        );
    }
    //    This Mapper class is used to convert departmentDTO into department JPA entity
    public static Department mapToDepartment(DepartmentDTO departmentDTO){
        return new Department(
                departmentDTO.getId(), departmentDTO.getDepartmentName(), departmentDTO.getDepartmentDescription()
        );
    }
}
