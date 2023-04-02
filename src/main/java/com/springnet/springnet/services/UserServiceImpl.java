package com.springnet.springnet.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    @Override
    public void createUser(User user) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();
        user.setRegistrationDate(LocalDateTime.of(date, time));

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userRepo.save(user);
    }

    @Override
    public User getOneByEmail(String email) {
        return userRepo.findOneByEmail(email).orElse(null);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
}
