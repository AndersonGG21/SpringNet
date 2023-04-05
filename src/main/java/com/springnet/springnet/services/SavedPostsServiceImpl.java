package com.springnet.springnet.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.SavedPosts;
import com.springnet.springnet.repositories.SavedPostsRepository;

@Service
public class SavedPostsServiceImpl implements SavedPostsService{


    @Autowired
    private SavedPostsRepository savedRepository;

    @Override
    public void savePost(SavedPosts post) {

        if (savedRepository.exists(Example.of(post))) {
            savedRepository.delete(post);
        }else{
            savedRepository.save(post);
        }

    }

    @Override
    public List<SavedPosts> getSavedPostsByUserId(Long userId) {
        return savedRepository.findAllByUserId(userId);
    }
    
}
