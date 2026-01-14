package com.example.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
