package com.springnet.springnet.services;

import java.util.List;
import com.springnet.springnet.models.SavedPosts;

public interface SavedPostsService {
    void savePost(SavedPosts post);
    boolean checkIfSaved(SavedPosts post);
    List<SavedPosts> getSavedPostsByUserId(Long userId);
}
