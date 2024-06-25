package com.example.todoManagementApp.service.impl;

import com.example.todoManagementApp.dto.TodoDto;
import com.example.todoManagementApp.entity.Todo;
import com.example.todoManagementApp.exception.ResourceNotFoundException;
import com.example.todoManagementApp.repository.TodoRepository;
import com.example.todoManagementApp.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
//    add model mapper to reduce code
    private ModelMapper modelMapper;

    @Override
    public TodoDto addTodo(TodoDto todoDto) {
//        convert TodoDto object into JPA entity

        Todo todo = modelMapper.map(todoDto,Todo.class);

//        Save Todo JPA entity
       Todo savedTodo =  todoRepository.save(todo);
//       Convert Saved TodoJPA entity object into TodoDto Object
        TodoDto savedTodoDto =modelMapper.map(savedTodo, TodoDto.class);
        return savedTodoDto;
    }

    @Override
    public TodoDto getTodo(Long id) {
       Todo todo  = todoRepository.findById(id)
               .orElseThrow(()-> new ResourceNotFoundException("Todo not found with id : " + id));
       return modelMapper.map(todo, TodoDto.class);
    }

    @Override
    public List <TodoDto> getAllTodos () {
       List<Todo> todos =  todoRepository.findAll();

        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoDto updateTodo ( TodoDto todoDto, Long id ) {
//       let's retrieve the todos from repository for update
        Todo todo  = todoRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Todo not found with id : " + id));

       todo.setTitle(todoDto.getTitle());
       todo.setDescription(todoDto.getDescription());
       todo.setCompleted(todoDto.isCompleted());

       Todo updatedTodo = todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDto.class);
    }

    @Override
    public void deleteTodo ( Long id ) {
       Todo todo =  todoRepository.findById(id)
               .orElseThrow(() -> new RuntimeException("Todo not found with id : " + id));
       todoRepository.deleteById(id);

    }


}
