package com.springnet.springnet.repositories;

import java.util.List;

import com.springnet.springnet.models.User;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Follow;
import org.springframework.data.repository.query.Param;

public interface FollowRepository extends JpaRepository<Follow, Long> {
    
  List<Follow> findByFollowerId(Long followerId);
  @Query("SELECT f.follower FROM Follow f WHERE f.following.id = :id")
  List<?> findFollowersByFollowingId(@Param("id") Long followingId);

  @Query("SELECT f.following FROM Follow f WHERE f.follower.id = :id")
  List<?> findFollowingByFollowerId(@Param("id") Long followerId);


}
