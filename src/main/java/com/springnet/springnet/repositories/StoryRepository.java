package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Story;

public interface StoryRepository extends JpaRepository<Story, Long >{
    List<Story> findByUserId(Long userId);
}
