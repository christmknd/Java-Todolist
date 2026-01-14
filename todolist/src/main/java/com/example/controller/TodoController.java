package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.dto.TodoDto;
import com.example.service.TodoService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/")
    public List<TodoDto> getAllTodos() {
        return todoService.getAllTodos();
    }

    @GetMapping("/{id}")
    public TodoDto getTodoById(@PathVariable Long id) {
        return todoService.getTodoById(id);
    }

    @PostMapping("/")
    public TodoDto createTodo(@RequestBody TodoDto todo) {
        return todoService.createTodo(todo);
    }

    @PutMapping("/{id}")
    public TodoDto updateTodo(@PathVariable Long id, @RequestBody TodoDto todo) {
        return todoService.updateTodo(todo, id);
    }

    @DeleteMapping("/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }

}
