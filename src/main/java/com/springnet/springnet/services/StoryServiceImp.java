package com.springnet.springnet.services;

import java.util.ArrayList;
import java.util.List;
import com.springnet.springnet.models.*;
import org.springframework.stereotype.Service;

import com.springnet.springnet.repositories.FollowRepository;
import com.springnet.springnet.repositories.StoryRepository;


@Service
public class StoryServiceImp implements StoryService {

    private final StoryRepository storyRepository;

    private final FollowRepository followRepository;

    public StoryServiceImp(StoryRepository storyRepository, FollowRepository followRepository) {
        this.storyRepository = storyRepository;
        this.followRepository = followRepository;
    }

    @Override
    public void createStory(Story story) {
        storyRepository.save(story);
    }

    @Override
    public List<Story> getStoriesByFollowing(Long userId) {
        List<Follow> followings = followRepository.findByFollowerId(userId);
        List<Story> stories = new ArrayList<>();

        for( Follow following : followings){
            List<Story> followingPosts = storyRepository.findByUserId(following.getFollowing().getId());
            stories.addAll(followingPosts);
        }

        return stories;
    }

}
