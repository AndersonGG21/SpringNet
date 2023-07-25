package com.springnet.springnet.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.models.User;
import com.springnet.springnet.services.UserServiceImpl;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "*")
public class UserController {
    
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{userId}")
    public User getUserProfile(@PathVariable Long userId){
        return userService.getUserProfile(userId);
    }
    
    @PostMapping("/newUser")
    public void createUser(@RequestBody User newUser){
        userService.createUser(newUser);
    }    

    @GetMapping("/by-email/{email}")
    public User getOneByEmail(@PathVariable String email){
        return userService.getOneByEmail(email);
    }

    @GetMapping("")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
}
