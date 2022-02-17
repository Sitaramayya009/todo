package com.service.todo.controller;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.service.todo.dto.Todo;
import com.service.todo.service.TodoService;

@SpringBootTest
public class TodoControllerTest {

	@InjectMocks
	private TodoController todoController;
	
	@Mock
	private TodoService todoService;
	
	@Test
	public void getTodoTest() {
		Mockito.when(todoService.getTodo(1L)).thenReturn(getTodo());
		Todo todo = todoController.getTodo(1L);
		Assertions.assertNotNull(todo);
	}
	
	@Test
	public void getTodosTest() {
		Mockito.when(todoService.getTodos()).thenReturn(Collections.singletonList(getTodo()));
		List<Todo> todoList = todoController.getTodos();
		Assertions.assertNotNull(todoList);
	}
	
	@Test
	public void addTodoTest() {
		Mockito.when(todoService.addTodo(Mockito.any())).thenReturn(getTodo());
		ResponseEntity responseEntity = todoController.addTodo(getTodo());
		Assertions.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
	
	@Test
	public void updateTodoTest() {
		Mockito.when(todoService.updateTodo(1L, getTodo())).thenReturn(getTodo());
		Todo todo = todoController.updateTodo(1L, getTodo());
		Assertions.assertNotNull(todo);
	}
	
	@Test
	public void deleteTodoTest() {
		todoController.deleteTodo(1L);
	}
	
	@Test
	public void getTodosByUserTest() {
		Mockito.when(todoService.getTodosByUser(Mockito.anyString())).thenReturn(Collections.singletonList(getTodo()));
		List<Todo> todoList = todoController.getTodosByUser("test@todo.com");
		Assertions.assertNotNull(todoList);
	}
	
	private Todo getTodo() {
		Todo todo = new Todo();
		todo.setId(1);
		todo.setTask("Java");
		return todo;
	}
	
}
