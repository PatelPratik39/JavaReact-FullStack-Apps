package com.example.todoManagementApp.service.impl;

import com.example.todoManagementApp.dto.TodoDto;
import com.example.todoManagementApp.entity.Todo;
import com.example.todoManagementApp.repository.TodoRepository;
import com.example.todoManagementApp.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
//    add model mapper to reduce code
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
//        convert TodoDto object into JPA entity

//        Todo todo = new Todo();
//        todo.setTitle(todoDto.getTitle());
//        todo.setDescription(todoDto.getDescription());
//        todo.setCompleted(todoDto.isCompleted());

        Todo todo = modelMapper.map(todoDto,Todo.class);


//        Save Todo JPA entity
       Todo savedTodo =  todoRepository.save(todo);

//       Convert Saved TodoJPA entity object into TodoDto Object
//        TodoDto savedTodoDto = new TodoDto();
//        savedTodoDto.setId(savedTodo.getId());
//        savedTodoDto.setTitle(savedTodo.getTitle());
//        savedTodoDto.setDescription(savedTodo.getDescription());
//        savedTodoDto.setCompleted(savedTodo.isCompleted());
//        return savedTodoDto ;

        TodoDto savedTodoDto =modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }
}
