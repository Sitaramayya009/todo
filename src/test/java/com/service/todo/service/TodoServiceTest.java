package com.service.todo.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.service.todo.dto.Todo;
import com.service.todo.repository.TodoRepository;

@SpringBootTest
public class TodoServiceTest {

	@InjectMocks
	private TodoService todoService;
	
	@Mock
	private TodoRepository todoRepository;
	
	@Test
	public void getTodoTest() {
		Mockito.when(todoRepository.findById(1L)).thenReturn(Optional.of(getTodo()));
		Todo todo = todoService.getTodo(1L);
		Assertions.assertNotNull(todo);
	}
	
	@Test
	public void getTodosTest() {
		Mockito.when(todoRepository.findAll()).thenReturn(Collections.singletonList(getTodo()));
		List<Todo> todoList = todoService.getTodos();
		Assertions.assertNotNull(todoList);
	}
	
	@Test
	public void addTodoTest() {
		Mockito.when(todoRepository.save(Mockito.any())).thenReturn(getTodo());
		Todo todo = todoService.addTodo(getTodo());
		Assertions.assertNotNull(todo);
	}
	
	@Test
	public void updateTodoTest() {
		Mockito.when(todoRepository.save(Mockito.any())).thenReturn(getTodo());
		Todo todo = todoService.updateTodo(1L, getTodo());
		Assertions.assertNotNull(todo);
	}
	
	@Test
	public void deleteTodoTest() {
		todoService.deleteTodo(1L);
	}
	
	@Test
	public void getTodosByUserTest() {
		Mockito.when(todoRepository.findByAuthorEmailId(Mockito.anyString())).thenReturn(Collections.singletonList(getTodo()));
		List<Todo> todoList = todoService.getTodosByUser("test@todo.com");
		Assertions.assertNotNull(todoList);
	}
	
	private Todo getTodo() {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setTask("Java");
		return todo;
	}
}
