package com.springnet.springnet.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springnet.springnet.models.Follow;
import com.springnet.springnet.models.Like;
import com.springnet.springnet.models.Post;
import com.springnet.springnet.models.User;
import com.springnet.springnet.repositories.PostRepository;
import com.springnet.springnet.repositories.UserRepository;
import com.springnet.springnet.repositories.FollowRepository;
import com.springnet.springnet.repositories.LikeRepository;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private FollowRepository followRepo;

    @Autowired
    private PostRepository postRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LikeRepository likeRepo;



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

    @Override
    public void createPost(Post post) {
        postRepo.save(post);
    }

    @Override
    public void likepost(Like like) {
        System.out.println(like.toString());
        // Post post = postRepo.findById(like.getPost().getId()).orElse(null);
        // User user = userRepo.findById(like.getUser().getId()).orElse(null);
        
        Like newLike = likeRepo.findByPostAndUser(like.getPost(), like.getUser());

        if (newLike == null) {
            likeRepo.save(like);
        }else{
            likeRepo.delete(like);
        }
    }
    
}
