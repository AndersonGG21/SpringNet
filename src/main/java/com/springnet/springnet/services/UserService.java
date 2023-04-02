package com.springnet.springnet.services;


import java.util.List;

import com.springnet.springnet.models.User;

public interface UserService{
    User getUserProfile(Long id);
    void createUser(User user);
    User getOneByEmail(String email);
    List<User> getAllUsers();
}
