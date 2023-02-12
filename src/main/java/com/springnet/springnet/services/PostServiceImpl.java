package com.springnet.springnet.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springnet.springnet.models.Follow;
import com.springnet.springnet.models.Post;
import com.springnet.springnet.repositories.PostRepository;
import com.springnet.springnet.repositories.FollowRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private FollowRepository followRepo;

    @Autowired
    private PostRepository postRepo;

    @Override
    public List<Post> findPostByFollowing(Long userId) {
        List<Follow> followings = followRepo.findByFollowerId(userId);
        List<Post> posts = new ArrayList<>();
        
        for( Follow following : followings){
            List<Post> followingPosts = postRepo.findByUserId(following.getFollowing().getId());
            posts.addAll(followingPosts);
        }
    
        return posts;
    }
    
}
