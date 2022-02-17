package com.service.todo.repository;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.service.todo.dto.User;

public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findByUsername(String username);
}