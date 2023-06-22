package com.springnet.springnet.services;

import java.util.List;

import com.springnet.springnet.models.Story;
import com.springnet.springnet.models.User;

public interface StoryService {
    void createStory(Story story);
    Story getStoryById(Long id);
    boolean deleteStoryById(Long id);
    List<Story> getStoriesByUserIdAndNotViewed(Long userId);
    List<Story> getStoriesByFollowing(Long userId);
    //List<Story> findStoriesById(Long userId);
}
