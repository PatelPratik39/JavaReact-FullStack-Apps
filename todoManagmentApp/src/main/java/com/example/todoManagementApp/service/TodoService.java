package com.example.todoManagementApp.service;

import com.example.todoManagementApp.dto.TodoDto;

import java.util.List;

public interface TodoService {

    TodoDto addTodo(TodoDto todoDto);

    TodoDto getTodo( Long id);

    List <TodoDto> getAllTodos();

    TodoDto updateTodo(TodoDto todoDto, Long id);

    void deleteTodo(Long id);

//    Complete Todos
    TodoDto completeTodo(Long id);

//    inComplete Todo
    TodoDto inCompleteTodo(Long id);

}
