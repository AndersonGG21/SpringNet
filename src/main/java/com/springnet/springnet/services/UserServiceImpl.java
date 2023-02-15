package com.springnet.springnet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.User;
import com.springnet.springnet.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepo;

    @Override
    public User getUserProfile(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
}
