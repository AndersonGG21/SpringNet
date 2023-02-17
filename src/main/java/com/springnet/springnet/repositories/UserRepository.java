package com.springnet.springnet.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    Optional<User> findOneByEmail(String email);
}
