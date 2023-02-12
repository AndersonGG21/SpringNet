package com.springnet.springnet.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
