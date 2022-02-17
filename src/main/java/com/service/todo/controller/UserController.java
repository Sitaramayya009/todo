package com.service.todo.controller;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.todo.dto.User;
import com.service.todo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @PostMapping
    public String addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping("/{user_id}")
    public User updateUser(@RequestBody User user, @PathVariable String user_id){
        return userService.updateUser(user_id, user);
    }

    @DeleteMapping("/{user_id}")
    public void deleteUser(@PathVariable String user_id){
        userService.deleteUser(user_id);
    }




}
