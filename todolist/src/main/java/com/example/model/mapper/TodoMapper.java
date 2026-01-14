package com.example.model.mapper;

import com.example.model.dto.TodoDto;
import com.example.model.entity.Todo;

public class TodoMapper {

    public static TodoDto toDto(Todo todo) {

        TodoDto dto = new TodoDto();
        dto.setId(todo.getId());
        dto.setUsername(todo.getUsername());
        dto.setPassword(todo.getPassword());
        return dto;
    }

}
