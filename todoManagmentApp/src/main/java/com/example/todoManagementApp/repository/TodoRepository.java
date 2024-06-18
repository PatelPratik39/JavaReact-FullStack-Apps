package com.example.todoManagementApp.repository;

import com.example.todoManagementApp.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Long> {


}
