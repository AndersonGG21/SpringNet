package com.springnet.springnet.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;

@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private EntityManager em;

    @Override
    public Long getCountOfFollowers() {
        return (Long) em.createNativeQuery("SELECT COUNT(follower_id) FROM `follow` WHERE following_id = 12").getSingleResult();
    }

    @Override
    public Long getCountOfFollowing() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCountOfFollowing'");
    }
    
}
