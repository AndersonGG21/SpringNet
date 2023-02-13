package com.springnet.springnet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Like;
import com.springnet.springnet.models.Post;
import com.springnet.springnet.models.User;

public interface LikeRepository extends JpaRepository<Like, Long>{

    Like findByPostAndUser(Post post, User user);
    
    
}
