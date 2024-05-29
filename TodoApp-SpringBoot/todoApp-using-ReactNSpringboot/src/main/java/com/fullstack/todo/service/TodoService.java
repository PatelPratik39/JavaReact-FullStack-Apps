package com.fullstack.todo.service;

import com.fullstack.todo.dto.TodoDTO;

public interface TodoService {

//    Create Todo
    TodoDTO addTodo(TodoDTO todoDTO);

//    GET TODO
    TodoDTO getTodo(Long id);
}
