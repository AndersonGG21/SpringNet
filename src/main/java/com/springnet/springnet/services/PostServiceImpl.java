package com.springnet.springnet.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Query;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.Comment;
import com.springnet.springnet.models.Follow;
import com.springnet.springnet.models.Like;
import com.springnet.springnet.models.Post;
import com.springnet.springnet.repositories.PostRepository;

import jakarta.persistence.EntityManager;

import com.springnet.springnet.repositories.CommentRepository;
import com.springnet.springnet.repositories.FollowRepository;
import com.springnet.springnet.repositories.LikeRepository;

@Service
public class PostServiceImpl implements PostService{

    private final FollowRepository followRepo;

    private final PostRepository postRepo;

    private final CommentRepository commentRepo;

    private final LikeRepository likeRepo;


    public PostServiceImpl(FollowRepository followRepo, PostRepository postRepo, CommentRepository commentRepo, LikeRepository likeRepo) {
        this.followRepo = followRepo;
        this.postRepo = postRepo;
        this.commentRepo = commentRepo;
        this.likeRepo = likeRepo;
    }

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
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        post.setPublicationDate(LocalDateTime.of(date, time));
        postRepo.save(post);
    }

    @Override
    public void likepost(Like like) {
        Like newLike = likeRepo.findByPostAndUser(like.getPost(), like.getUser());
        System.out.println(newLike);

        if (newLike == null) {
            likeRepo.save(like);
        }else{
            likeRepo.delete(newLike);
        }

    }

    @Override
    public void comment(Comment comment) {
        LocalDate date = LocalDate.now();
        LocalTime time = LocalTime.now();

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        comment.setDate(dateTime);
        commentRepo.save(comment);
    }

    public Long countSameComment(Comment comment){
        return commentRepo.count(Example.of(comment));
    }

    public Long countLike(Like like){
        return likeRepo.count(Example.of(like));
    }

    public int countLikes(Long postId) {
        //String sqlQuery = "SELECT COUNT(post_id) FROM `likes` WHERE post_id = ?";
        //return (Long) em.createNativeQuery(sqlQuery).setParameter(1,postId).getSingleResult();
        return likeRepo.countLikesByPostId(postId);
    }

    @Override
    public List<Post> findPostByUser(Long userId) {
        return postRepo.findByUserId(userId);
    }

    @Override
    public List<Comment> findCommentByPostId(Long postId) {
        return commentRepo.findByPostId(postId);
    }

    @Override
    public List<Post> findLikedPostsByUserId(Long userId) {
        //String sqlQuery = "SELECT l.post FROM Like l WHERE l.user.id = :userId";

        //Query query = em.createQuery(sqlQuery).setParameter("userId",userId);
        return (List<Post>)likeRepo.findPostsLikedByUserId(userId);
    }
}
