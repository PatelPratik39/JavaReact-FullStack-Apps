package com.example.todoManagementApp.repository;

import com.example.todoManagementApp.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository< Role, Long > {

}
