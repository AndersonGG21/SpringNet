package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.StoryView;

public interface StoryViewRepository extends JpaRepository<StoryView,Long>{
    List<StoryView> findByUserId(Long userId);
}
