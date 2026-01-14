package com.example.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    List<Todo> findByCompleted(Boolean completed);

}
