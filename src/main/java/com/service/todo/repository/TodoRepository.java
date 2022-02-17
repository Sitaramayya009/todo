package com.service.todo.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.service.todo.dto.Todo;

public interface TodoRepository extends CrudRepository<Todo, Long> {
    public List<Todo> findByAuthorEmailId(String user_id);
}
