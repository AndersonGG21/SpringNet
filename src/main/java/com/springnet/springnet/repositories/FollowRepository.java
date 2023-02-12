package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Follow;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    List<Follow> findByFollowerId(Long followerId);
  }
