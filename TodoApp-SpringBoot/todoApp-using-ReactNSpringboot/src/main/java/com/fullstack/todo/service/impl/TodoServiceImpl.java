package com.fullstack.todo.service.impl;

import com.fullstack.todo.dto.TodoDTO;
import com.fullstack.todo.entity.Todo;
import com.fullstack.todo.exceptions.ResourceNotFoundException;
import com.fullstack.todo.repository.TodoRepository;
import com.fullstack.todo.service.TodoService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

//    Get todo using ID
    @Override
    public TodoDTO getTodo(Long id) {
       Todo todo = todoRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("Todo Not found with this ID : " + id));
       return modelMapper.map(todo, TodoDTO.class); //convert todo jpa object to TodoDTO object
    }

//    Get All Todos
    @Override
    public List<TodoDTO> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map((todo) -> modelMapper.map(todo, TodoDTO.class)).collect(Collectors.toList());
    }

//    Update TODO
    @Override
    public TodoDTO updateTodo(TodoDTO todoDTO, Long id) {

       Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo Not found with this ID : " + id));
       todo.setTitle(todoDTO.getTitle());
       todo.setDescription(todoDTO.getDescription());
       todo.setCompleted(todoDTO.isCompleted());

       Todo updatedTodo =  todoRepository.save(todo);
        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

//    DELETE TODO method
    @Override
    public void deleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo Not found with this ID : " + id) );
        todoRepository.deleteById(id);
    }

    @Override
    public TodoDTO completeTodo(Long id) {

        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo Not found with this ID : " + id) );
        todo.setCompleted(Boolean.TRUE);
        Todo updatedTodo = todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }

    @Override
    public TodoDTO inCompleteTodo(Long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Todo Not found with this ID : " + id) );
        todo.setCompleted(Boolean.FALSE);
        Todo updatedTodo =todoRepository.save(todo);

        return modelMapper.map(updatedTodo, TodoDTO.class);
    }


}
