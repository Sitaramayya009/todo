package com.service.todo.controller;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.todo.dto.User;
import com.service.todo.service.UserService;

@SpringBootTest
public class UserControllerTest {

	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	private static final String EMAIL_ID = "test@todo.com";
	
	@Test
	public void getUsersTest() {
		Mockito.when(userService.getUsers()).thenReturn(Collections.singletonList(getUser()));
		List<User> userList = userController.getUsers();
		Assertions.assertEquals(1, userList.size());
	}
	
	@Test
	public void addUserTest() {
		Mockito.when(userService.addUser(getUser())).thenReturn(EMAIL_ID);
		String response = userController.addUser(getUser());
		Assertions.assertEquals(EMAIL_ID, response);
	}
	
	@Test
	public void updateUserTest() {
		Mockito.when(userService.updateUser(EMAIL_ID, getUser())).thenReturn(getUser());
		User response = userController.updateUser(getUser(), EMAIL_ID);
		Assertions.assertNotNull(response);
	}
	
	@Test
	public void deleteUserTest() {
		userController.deleteUser(EMAIL_ID);
	}

	private User getUser() {
		User user = new User();
		user.setUsername(EMAIL_ID);
		return user;
	}
}
