package com.springnet.springnet.services;

import java.util.List;

import com.springnet.springnet.models.Story;

public interface StoryService {
    void createStory(Story story);
    List<Story> getStoriesByFollowing(Long userId);
}
