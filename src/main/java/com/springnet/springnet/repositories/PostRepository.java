package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Post;

public interface PostRepository extends JpaRepository<Post, Long>{
    List<Post> findByUserId(Long userId);
}
