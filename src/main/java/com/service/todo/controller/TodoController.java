package com.service.todo.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.todo.dto.Todo;
import com.service.todo.service.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping("/{id}")
	public Todo getTodo(@PathVariable Long id) {
		return todoService.getTodo(id);
	}

	@GetMapping
	public List<Todo> getTodos() {
		return todoService.getTodos();
	}

	@PostMapping
	public ResponseEntity addTodo(@RequestBody Todo todo) {
		try {
			return new ResponseEntity(todoService.addTodo(todo), HttpStatus.OK);
		} catch(Exception ex) {
			return new ResponseEntity(HttpStatus.UNAUTHORIZED);
		}
	}

	@PutMapping("/{id}")
	public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
		return todoService.updateTodo(id, todo);
	}

	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable Long id) {
		todoService.deleteTodo(id);
	}

	@GetMapping("/user/{user_id}")
	public List<Todo> getTodosByUser(@PathVariable String user_id) {
		return todoService.getTodosByUser(user_id);
	}

}