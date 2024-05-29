package com.fullstack.todo.controller;

import com.fullstack.todo.dto.TodoDTO;
import com.fullstack.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api/todos")
public class TodoController {

    private TodoService todoService;

//  Build  addTodo REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<TodoDTO> addTodo(@RequestBody TodoDTO todoDTO){
        TodoDTO savedTodo = todoService.addTodo(todoDTO);
        return new ResponseEntity<>(savedTodo, HttpStatus.CREATED);
    }

//    Build getTodo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping("{id}")
    public ResponseEntity<TodoDTO> getTodo(@PathVariable("id") Long todoId){
       TodoDTO todoDTO = todoService.getTodo(todoId);
       return new ResponseEntity<>(todoDTO, HttpStatus.OK);
    }

//    Build GetAll Todos REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @GetMapping
    public ResponseEntity<List<TodoDTO>> getAllTodos() {
        List<TodoDTO> todos =  todoService.getAllTodos();
//        return new ResponseEntity<>(todos, HttpStatus.OK);
        return ResponseEntity.ok(todos);
    }

//    Build Update Todo REST API
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("{id}")
    public ResponseEntity<TodoDTO> updateTodo (@RequestBody TodoDTO todoDTO, @PathVariable("id") Long todoId){
       TodoDTO updatedTodo = todoService.updateTodo(todoDTO, todoId);
       return ResponseEntity.ok(updatedTodo);
    }


//    Build DELETE TODO REST API
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTodo(@PathVariable("id") Long todoId){
        todoService.deleteTodo(todoId);
        return ResponseEntity.ok("TODO DELETED Successfully!!!!");
    }

//    Complete Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/complete")
    public ResponseEntity<TodoDTO> completedTodo(@PathVariable("id") Long todoId){
       TodoDTO updatedTodoDTO = todoService.completeTodo(todoId);
       return ResponseEntity.ok(updatedTodoDTO);
    }


//    Build In Complete Todo REST API
    @PreAuthorize("hasAnyRole('ADMIN','USER')")
    @PatchMapping("{id}/in-complete")
    public  ResponseEntity<TodoDTO> inCompleteTodo(@PathVariable("id")Long todoId){
        TodoDTO updatedTodo = todoService.inCompleteTodo(todoId);
        return  ResponseEntity.ok(updatedTodo);
    }

}
