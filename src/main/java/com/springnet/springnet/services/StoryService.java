package com.springnet.springnet.services;

import java.util.List;

import com.springnet.springnet.models.Story;
import com.springnet.springnet.models.User;

public interface StoryService {
    void createStory(Story story);
    Story getStoryById(Long id);
    boolean deleteStoryById(Long id);
    List<Story> getStoriesByUserIdAndNotViewed(Long userId);
    void createStoryView(Story story, User user);
}
