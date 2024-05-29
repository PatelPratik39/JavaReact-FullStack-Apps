package com.fullstack.todo.service.impl;

import com.fullstack.todo.dto.TodoDTO;
import com.fullstack.todo.entity.Todo;
import com.fullstack.todo.exceptions.ResourceNotFoundException;
import com.fullstack.todo.repository.TodoRepository;
import com.fullstack.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class TodoServiceImpl implements TodoService {

    private TodoRepository todoRepository;
    private ModelMapper modelMapper;

    @Override
    public TodoDTO addTodo(TodoDTO todoDTO) {

//        convert TodoDTO into Todo JPA entity
        Todo todo = modelMapper.map(todoDTO, Todo.class);
//        Todo JPA entity
       Todo savedTodo =  todoRepository.save(todo);

//       convert saved TODO jpa entity into TodoDTO object
        TodoDTO savedTodoDTO = modelMapper.map(savedTodo, TodoDTO.class);
        return savedTodoDTO;
    }

    @Override
    public TodoDTO getTodo(Long id) {
       Todo todo = todoRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Todo Not found with this ID : " + id));
       return modelMapper.map(todo, TodoDTO.class); //convert todo jpa object to TodoDTO object
    }
}
