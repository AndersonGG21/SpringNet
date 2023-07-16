package com.springnet.springnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.models.Comment;
import com.springnet.springnet.models.Like;
import com.springnet.springnet.models.Post;
import com.springnet.springnet.services.PostServiceImpl;

@RestController
@RequestMapping("/api/posts")
public class PostController {
 
    @Autowired
    private PostServiceImpl postService;


    @GetMapping("/{userId}")
    public List<Post> getPostByFollowing(@PathVariable Long userId){
        return postService.findPostByFollowing(userId);
    }

    @PostMapping("/new-post")
    public void createPost(@RequestBody Post post){
        postService.createPost(post);
    }

    @PostMapping("/like")
    public void likePost(@RequestBody Like like){
        postService.likepost(like);
    }

    @PostMapping("/comment")
    public void commentPost(@RequestBody Comment comment){
        postService.comment(comment);
    }

    @GetMapping("/user-posts/{user}")
    public List<Post> getUserPost(@PathVariable Long user){
        return postService.findPostByUser(user);
    }

    @PostMapping("/liked")
    public Long checkLike(@RequestBody Like like){
        return postService.countLike(like);
    }
    
    @GetMapping("/{postId}/comments")
    public List<Comment> getComments(@PathVariable Long postId){
        return postService.findCommentByPostId(postId);
    }

    @GetMapping("/{postId}/likes")
    public Long getPostLikes(@PathVariable Long postId){
        return postService.countLikes(postId);
    }

    @GetMapping("/liked-posts/{userId}")
    public  List<Post> getLikedPosts(@PathVariable Long userId){
        return postService.findLikedPostsByUserId(userId);
    }
}
