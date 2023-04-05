package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.SavedPosts;

public interface SavedPostsRepository extends JpaRepository<SavedPosts, Long>{
    List<SavedPosts> findAllByUserId(Long userId);
}
