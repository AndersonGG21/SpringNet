package com.springnet.springnet.services;

import java.util.List;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.SavedPosts;
import com.springnet.springnet.repositories.SavedPostsRepository;

@Service
@AllArgsConstructor
public class SavedPostsServiceImpl implements SavedPostsService{

    private final SavedPostsRepository savedRepository;

    @Override
    public void savePost(SavedPosts post) {
        
        if (savedRepository.exists(Example.of(post))) {
            SavedPosts postToSave = savedRepository.findOne(Example.of(post)).orElse(null);
            assert postToSave != null;
            savedRepository.delete(postToSave);
        }else{
            savedRepository.save(post);
        }

    }

    @Override
    public List<SavedPosts> getSavedPostsByUserId(Long userId) {
        return savedRepository.findAllByUserId(userId);
    }

    @Override
    public boolean checkIfSaved(SavedPosts post) {
        return savedRepository.exists(Example.of(post));
    }
    
}
