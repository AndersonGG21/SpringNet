package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{
    
    List<Comment> findByPostId(Long postId);
}
