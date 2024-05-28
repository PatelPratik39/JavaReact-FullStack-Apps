package com.fullstack.employeeManagementbackend.service.impl;

import com.fullstack.employeeManagementbackend.dto.DepartmentDTO;
import com.fullstack.employeeManagementbackend.entity.Department;
import com.fullstack.employeeManagementbackend.exception.ResourceNotFoundException;
import com.fullstack.employeeManagementbackend.mapper.DepartmentMapper;
import com.fullstack.employeeManagementbackend.repository.DepartmentRepository;
import com.fullstack.employeeManagementbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private DepartmentRepository departmentRepository;

/*
 below method, I need to convert DepartmentDTO object to Department JPA entity
 */

    @Override
    public DepartmentDTO createDepartment(DepartmentDTO departmentDTO) {
        Department department = DepartmentMapper.mapToDepartment(departmentDTO);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
    }

    @Override
    public DepartmentDTO getDepartmentById(Long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not Exist with given ID : " + departmentId)
        );
//        I need to convert the department JPA entity to DTO, so I need to use departmentMapper()
        return DepartmentMapper.mapToDepartmentDTO(department);
    }

    @Override
    public List<DepartmentDTO> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map(
                (department) -> DepartmentMapper.mapToDepartmentDTO(department)
        ).collect(Collectors.toList());
    }
    //    Update

    @Override
    public DepartmentDTO updatedDepartment(Long departmentId, DepartmentDTO updateDepartment) {
         Department department = departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exist with Given ID : " +  departmentId)
        );
         department.setDepartmentName(updateDepartment.getDepartmentName());
         department.setDepartmentDescription(updateDepartment.getDepartmentDescription());

         Department savedDepartment = departmentRepository.save(department);

        return DepartmentMapper.mapToDepartmentDTO(savedDepartment);
    }


//    DELETE Department Implementation
    @Override
    public void deleteDepartment(Long departmentId) {
         departmentRepository.findById(departmentId).orElseThrow(
                () -> new ResourceNotFoundException("Department is not exist with Given ID : " +  departmentId)
        );
        departmentRepository.deleteById(departmentId);
    }

}
