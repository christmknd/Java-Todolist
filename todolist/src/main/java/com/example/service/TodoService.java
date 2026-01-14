package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.dto.TodoDto;
import com.example.model.entity.*;
import com.example.model.mapper.TodoMapper;
import com.example.model.repository.TodoRepository;;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private TodoMapper todoMapper;

    public TodoDto getTodoById(Long idTodo) {

        Todo todo = todoRepository.findById(idTodo).orElse(null);
        if (todo == null) {
            return null;
        }
        return todoMapper.toDto(todo);
    }

    public List<TodoDto> getAllTodos() {
        List<Todo> todos = todoRepository.findAll();
        return todos.stream().map(todoMapper::toDto).toList();
    }

    public TodoDto createTodo(TodoDto todoDto) {
        Todo todo = new Todo();
        todo.setTitle(todoDto.getTitle());
        todo.setCompleted(todoDto.getCompleted());

        Todo savedTodo = todoRepository.save(todo);
        return todoMapper.toDto(savedTodo);
    }

    public TodoDto updateTodo(TodoDto todoDto) {
        Todo todo = todoRepository.findById(todoDto.getId()).orElse(null);
        if (todo == null) {
            return null;
        }
        todo.setTitle(todoDto.getTitle());
        todo.setCompleted(todoDto.getCompleted());
        Todo updatedTodo = todoRepository.save(todo);
        return todoMapper.toDto(updatedTodo);
    }

    public void deleteTodo(Long idTodo) {
        todoRepository.deleteById(idTodo);
    }
}
