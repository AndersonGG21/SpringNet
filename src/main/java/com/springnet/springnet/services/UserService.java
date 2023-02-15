package com.springnet.springnet.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.User;

public interface UserService{
    User findUserById(Long id);
}
