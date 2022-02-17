package com.service.todo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.service.todo.dto.Todo;
import com.service.todo.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepo;

    public TodoService(TodoRepository todorepo) {
        this.todoRepo = todorepo;
    }

    public List<Todo> getTodos() {
        List<Todo> allTodos = new ArrayList<>();

        todoRepo.findAll().forEach(allTodos::add);

        return allTodos;
    }

    public Todo getTodo(Long id){
        Optional<Todo> res = todoRepo.findById(id);
        return res.orElse(null);
    }

    public Todo addTodo(Todo todo){
    	return todoRepo.save(todo);
    }

    public Todo updateTodo(Long id, Todo todo){
        todo.setId(id);
        return todoRepo.save(todo);
    }

    public void deleteTodo(Long id){
        todoRepo.delete(getTodo(id));
    }

    public List<Todo> getTodosByUser(String user_id){
        return todoRepo.findByAuthorEmailId(user_id);
    }
}
