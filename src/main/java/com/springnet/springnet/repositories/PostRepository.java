package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springnet.springnet.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    
    List<Post> findByUserId(Long userId);

    @Query ("SELECT COUNT(follower_id) FROM `follow` WHERE following_id = 12")
    List<Object> countFollowers();
}
