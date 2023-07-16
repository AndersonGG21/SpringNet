package com.springnet.springnet.services;
import java.util.List;

import com.springnet.springnet.models.Comment;
import com.springnet.springnet.models.Like;
import com.springnet.springnet.models.Post;

public interface PostService {
    
    List<Post> findPostByFollowing(Long userId);
    void createPost(Post post);
    void likepost(Like like);
    void comment(Comment comment);
    List<Post> findPostByUser(Long userId);
    List<Comment> findCommentByPostId(Long postId);
    List<Post> findLikedPostsByUserId(Long userId);
}
