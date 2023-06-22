package com.springnet.springnet.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.springnet.springnet.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.repositories.FollowRepository;
import com.springnet.springnet.repositories.StoryRepository;
import com.springnet.springnet.repositories.StoryViewRepository;

@Service
public class StoryServiceImp implements StoryService {

    private final StoryRepository storyRepository;

    private final StoryViewRepository storyViewRepository;

    private final FollowRepository followRepository;

    public StoryServiceImp(StoryRepository storyRepository, StoryViewRepository storyViewRepository, FollowRepository followRepository) {
        this.storyRepository = storyRepository;
        this.storyViewRepository = storyViewRepository;
        this.followRepository = followRepository;
    }

    @Override
    public void createStory(Story story) {
        Follow followToSave =
        followRepository.findOne(Example.of(story.getRelation())).orElse(null);
        story.setRelation(followToSave);
        storyRepository.save(story);
    }

    @Override
    public Story getStoryById(Long id) {
        return storyRepository.findById(id).orElse(null);
    }

    @Override
    public boolean deleteStoryById(Long id) {
        if (storyRepository.existsById(id)) {
            storyRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Story> getStoriesByUserIdAndNotViewed(Long userId) {
        List<Story> stories = storyRepository.findByRelationFollowerId(userId);
        List<StoryView> views = storyViewRepository.findByUserId(userId);
        Set<Story> viewedStories = views.stream().map(StoryView::getStory).collect(Collectors.toSet());
        return stories.stream().filter(story -> !viewedStories.contains(story))
                .collect(Collectors.toList());

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
