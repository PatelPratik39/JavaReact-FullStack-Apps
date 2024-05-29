package com.fullstack.todo.service;

import com.fullstack.todo.dto.TodoDTO;

import java.util.List;

public interface TodoService {

//    Create Todo
    TodoDTO addTodo(TodoDTO todoDTO);

//    GET TODO
    TodoDTO getTodo(Long id);

//    GET All Todos
    List<TodoDTO> getAllTodos();

//    Update Todos
    TodoDTO updateTodo(TodoDTO todoDTO, Long id);

//    DELETE Todo
    void deleteTodo(Long id);

//    Completed Todo
    TodoDTO completeTodo(Long id);

//    InComplete Todo
    TodoDTO inCompleteTodo(Long id);
}
