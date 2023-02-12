package com.springnet.springnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
