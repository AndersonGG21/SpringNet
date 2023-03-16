package com.springnet.springnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<String> commentPost(@RequestBody Comment comment){
        if (postService.countSameComment(comment) >= 1 ) {
            return new ResponseEntity<>("Ya has hecho este comentario", HttpStatus.OK);
        }

        postService.comment(comment);

        return new ResponseEntity<>("Ok", HttpStatus.OK);
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
}
