package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.config.ApiError;
import com.example.model.dto.TodoDto;
import com.example.service.TodoService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @GetMapping
    public ResponseEntity<?> getAllTodos() {
        try {
            return ResponseEntity.ok(todoService.getAllTodos());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiError(500, "Failed to retrieve todos"));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTodoById(@PathVariable Long id) {

        try {
            return ResponseEntity.ok(todoService.getTodoById(id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiError(404, e.getMessage()));
        }
    }

    @PostMapping
    public ResponseEntity<?> createTodo(@RequestBody TodoDto todo) {
        try {
            TodoDto created = todoService.createTodo(todo);
            return ResponseEntity.status(HttpStatus.CREATED).body(created);
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new ApiError(400, "Failed to create todo"));
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateTodo(@PathVariable Long id, @RequestBody TodoDto todo) {
        try {
            return ResponseEntity.ok(todoService.updateTodo(todo, id));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiError(404, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Long id) {

        try {
            todoService.deleteTodo(id);
            return ResponseEntity.ok("Todo deleted successfully");
        } catch (EntityNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiError(404, e.getMessage()));
        }
    }

}
