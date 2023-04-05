package com.springnet.springnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.models.SavedPosts;
import com.springnet.springnet.services.SavedPostsService;

@RestController
@RequestMapping("/api/saved-posts")
public class SavedPostsController {
    
    @Autowired
    private SavedPostsService savedPostsService;

    @GetMapping("/{userId}")
    public List<SavedPosts> getSavedPosts(@PathVariable Long userId){
        return savedPostsService.getSavedPostsByUserId(userId);
    }

    @PostMapping("/save-post")
    public void savePost(@RequestBody SavedPosts post){
        savedPostsService.savePost(post);
    }

    @PostMapping("check")
    public boolean checkIfSaved(@RequestBody SavedPosts post){
        return savedPostsService.checkIfSaved(post);
    }
}
