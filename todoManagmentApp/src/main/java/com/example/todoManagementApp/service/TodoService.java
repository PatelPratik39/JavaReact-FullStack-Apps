package com.example.todoManagementApp.service;

import com.example.todoManagementApp.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo( Long id);

    List <TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);
}
