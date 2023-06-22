package com.springnet.springnet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springnet.springnet.models.Story;
import com.springnet.springnet.services.StoryService;

@RestController
@RequestMapping("/api/stories")
public class StoryController {


    private final StoryService storyService;

    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    @GetMapping("/{userId}")
    public List<Story> getStoriesByUserIdAndNotViewed(@PathVariable Long userId){
        return storyService.getStoriesByFollowing(userId);
    }
    @PostMapping("/new-story")
    public void addStory(@RequestBody Story story) {
        storyService.createStory(story);
    }
}
