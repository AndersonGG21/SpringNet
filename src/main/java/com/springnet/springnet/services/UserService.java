package com.springnet.springnet.services;

import com.springnet.springnet.models.User;

public interface UserService{
    User getUserProfile(Long id);
    void createUser(User user);
}
