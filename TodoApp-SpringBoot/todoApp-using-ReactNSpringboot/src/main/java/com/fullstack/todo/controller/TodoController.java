package com.fullstack.todo.controller;

import com.fullstack.todo.dto.TodoDTO;
import com.fullstack.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

//  Build  addTodo REST API

    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO){
        TodoDTO savedTodo = todoService.addTodo(todoDTO);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

//    Build getTodo REST API
    @GetMapping("{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable("id") Long todoId){
       TodoDTO todoDTO = todoService.getTodo(todoId);
       return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }
}
