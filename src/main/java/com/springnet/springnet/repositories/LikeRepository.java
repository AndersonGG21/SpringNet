package com.springnet.springnet.repositories;


import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import com.springnet.springnet.models.Like;
import com.springnet.springnet.models.Post;
import com.springnet.springnet.models.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long>{
    Like findByPostAndUser(Post post, User user);
    @Query("SELECT COUNT(l.post) FROM Like l WHERE l.post.id = :postId")
    int countLikesByPostId(@Param("postId") Long postId);

    @Query("SELECT l.post FROM Like l WHERE l.user.id = :userId")
    List<?> findPostsLikedByUserId(@Param("userId") Long userId);
}
