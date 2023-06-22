package com.springnet.springnet.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.springnet.springnet.models.Story;

public interface StoryRepository extends JpaRepository<Story, Long >{
    // List<Story> findByUserId(Long userId);

    @Query("SELECT s FROM Story s JOIN FETCH s.follow f WHERE f.follower.id = :followerId")
    List<Story> findByRelationFollowerId(@Param("followerId") Long followerId);

    List<Story> findByUserId(Long userId);
}
