package com.fullstack.todo.controller;

import com.fullstack.todo.dto.TodoDTO;
import com.fullstack.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

//    Build GetAll Todos REST API
    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<TodoDTO> todos =  todoService.getAllTodos();
//        return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

//    Build Update Todo REST API
    @PutMapping("{id}")
    public ResponseEntity<TodoDTO> updateTodo (@RequestBody TodoDTO todoDTO, @PathVariable("id") Long todoId){
       TodoDTO updatedTodo = todoService.updateTodo(todoDTO, todoId);
       return ResponseEntity.ok(updatedTodo);
    }


//    Build DELETE TODO REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("TODO DELETED Successfully!!!!");
    }
}
