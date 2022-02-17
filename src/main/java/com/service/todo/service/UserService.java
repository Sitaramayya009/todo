package com.service.todo.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.service.todo.dto.User;
import com.service.todo.repository.UserRepository;

@Service
public class UserService{
    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers(){
        List<User> allUsers = new ArrayList<User>();

        userRepo.findAll().forEach(allUsers::add);

        return allUsers;
    }

    public User getUser(String id){
        Optional<User> res = userRepo.findById(id);
        return res.orElse(null);
    }

    public String addUser(User User){
        User newUser = userRepo.save(User);
        return newUser.getEmailId();
    }

    public User updateUser(String id, User User){
        User.setEmailId(id);
        return userRepo.save(User);
    }

    public void deleteUser(String id){
       userRepo.delete(getUser(id));
    }
}