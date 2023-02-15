package com.springnet.springnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.models.User;
import com.springnet.springnet.services.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public User getUserProfile(@RequestParam Long id){
        return userService.getUserProfile(id);
    }
    
    @PostMapping("/new-user")
    public void createUser(@RequestBody User newUser){
        userService.createUser(newUser);
    }    
}
