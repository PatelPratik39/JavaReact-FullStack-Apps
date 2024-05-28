package com.fullstack.employeeManagementbackend.controller;

import com.fullstack.employeeManagementbackend.dto.DepartmentDTO;

import com.fullstack.employeeManagementbackend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

    private DepartmentService departmentService;

//    Build Create or Add Department REST API

    @PostMapping
    public ResponseEntity<DepartmentDTO> createDepartment(@RequestBody DepartmentDTO departmentDTO){
        DepartmentDTO department = departmentService.createDepartment(departmentDTO);
        return new ResponseEntity<>(department, HttpStatus.CREATED);
    }

//    Build GET Department by ID REST API
    @GetMapping("{id}")
    public  ResponseEntity<DepartmentDTO> getDepartmentById(@PathVariable("id") Long departmentId){
        DepartmentDTO departmentDTO = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(departmentDTO);
    }

//    Build GET ALl department REST API
    @GetMapping
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {
        List<DepartmentDTO> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

//    Build UPDATE Department REST API
    @PutMapping("{id}")
    public  ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable("id") Long departmentId,
                                                           @RequestBody DepartmentDTO updatedDepartment){
        DepartmentDTO departmentDTO = departmentService.updatedDepartment(departmentId, updatedDepartment);
        return ResponseEntity.ok(departmentDTO);
    }

    //    Build DELETE Department REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long departmentId) {
        departmentService.deleteDepartment(departmentId);
        return ResponseEntity.ok("Department DELETED Successfully!!!");
    }
}


