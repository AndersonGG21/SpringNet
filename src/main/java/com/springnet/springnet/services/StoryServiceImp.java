package com.springnet.springnet.services;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.Follow;
import com.springnet.springnet.models.Story;
import com.springnet.springnet.models.StoryView;
import com.springnet.springnet.models.User;
import com.springnet.springnet.repositories.FollowRepository;
import com.springnet.springnet.repositories.StoryRepository;
import com.springnet.springnet.repositories.StoryViewRepository;

@Service
public class StoryServiceImp implements StoryService{

    @Autowired
    private StoryRepository storyRepository;

    @Autowired 
    private StoryViewRepository storyViewRepository;

    @Autowired
    private FollowRepository followRepository;

    @Override
    public void createStory(Story story) {
        Follow followToSave = followRepository.findOne(Example.of(story.getFollow())).orElse(null);
        story.setFollow(followToSave);
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
        List<Story> stories = storyRepository.findByFollowFollowerId(userId);
        List<StoryView> views = storyViewRepository.findByUserId(userId);
        // List<Long> followingsIds = followRepository.findFollowingIdsByFollower(userId);
        Set<Long> viewedStories = views.stream().map(StoryView::getId).collect(Collectors.toSet());

        return stories.stream().filter(story -> !viewedStories.contains(story.getFollow().getFollower().getId())).collect(Collectors.toList());
    }

    @Override
    public void createStoryView(Story story, User user) {
        StoryView storyView = new StoryView();
        storyView.setUser(user);
        storyView.setStory(story);
        storyViewRepository.save(storyView);
    }
    
}
