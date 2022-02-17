package com.service.todo.service;

import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.service.todo.dto.User;
import com.service.todo.repository.UserRepository;

@SpringBootTest
public class UserServiceTest {

	@InjectMocks
	private UserService userService;
	
	@Mock
	private UserRepository userRepository;
	
private static final String EMAIL_ID = "test@todo.com";
	
	@Test
	public void getUsersTest() {
		Mockito.when(userRepository.findAll()).thenReturn(Collections.singletonList(getUser()));
		List<User> userList = userService.getUsers();
		Assertions.assertEquals(1, userList.size());
	}
	
	@Test
	public void addUserTest() {
		Mockito.when(userRepository.save(getUser())).thenReturn(getUser());
		String response = userService.addUser(getUser());
		Assertions.assertEquals(EMAIL_ID, response);
	}
	
	@Test
	public void updateUserTest() {
		Mockito.when(userRepository.save(getUser())).thenReturn(getUser());
		User response = userService.updateUser(EMAIL_ID, getUser());
		Assertions.assertNotNull(response);
	}
	
	@Test
	public void deleteUserTest() {
		userService.deleteUser(EMAIL_ID);
	}

	private User getUser() {
		User user = new User();
		user.setUsername(EMAIL_ID);
		user.setEmailId(EMAIL_ID);
		return user;
	}
}
