package com.springnet.springnet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private EntityManager em;

    @Override
    public Long getCountOfFollowers(Long id) {
        return (Long) em.createNativeQuery("SELECT COUNT(follower_id) FROM `follow` WHERE following_id = ?")
        .setParameter(1, id)
        .getSingleResult();
    }

    @Override
    public Long getCountOfFollowing(Long id) {
        return (Long) em.createNativeQuery("SELECT COUNT(following_id) FROM `follow` WHERE follower_id = ?")
        .setParameter(1, id)
        .getSingleResult();
    }
    
}
