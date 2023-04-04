package com.springnet.springnet.services;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.Follow;
import com.springnet.springnet.repositories.FollowRepository;

import jakarta.persistence.EntityManager;

@Service
public class FollowServiceImpl implements FollowService{

    @Autowired
    private EntityManager em;

    @Autowired
    private FollowRepository fRepository;

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

    @Override
    public void setFollow(Follow follow) {
        follow.setFollowDate(LocalDate.now());
        fRepository.save(follow);
    }

    @Override
    public Long countFollow(Follow follow) {
        return fRepository.count(Example.of(follow));
    }

    @Override
    public void removeFollow(Follow follow) {
        Follow deleteFollow = fRepository.findOne(Example.of(follow)).orElse(null);
        fRepository.delete(deleteFollow);
    }
    
}
