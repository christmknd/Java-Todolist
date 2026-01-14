package com.example.model.mapper;

import org.springframework.stereotype.Component;

import com.example.model.dto.TodoDto;
import com.example.model.entity.Todo;

@Component
public class TodoMapper {

    public TodoDto toDto(Todo todo) {

        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setTitle(todo.getTitle());
        dto.setCompleted(todo.getCompleted());
        return dto;
    }

}
