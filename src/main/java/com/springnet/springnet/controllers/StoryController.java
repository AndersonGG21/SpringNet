package com.springnet.springnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.models.Story;
import com.springnet.springnet.services.StoryService;

@RestController
@RequestMapping("/api/stories")
public class StoryController {
    
    @Autowired
    private StoryService storyService;

    @GetMapping("/{userId}")
    public List<Story> getStoriesByUserIdAndNotViewed(@PathVariable Long userId){
        return storyService.getStoriesByUserIdAndNotViewed(userId);
    }
}
