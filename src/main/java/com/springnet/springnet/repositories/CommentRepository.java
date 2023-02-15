package com.springnet.springnet.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
}
