package com.springnet.springnet.services;

import java.time.LocalDate;
import java.util.List;

import com.springnet.springnet.models.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.Follow;
import com.springnet.springnet.repositories.FollowRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Service
@EnableTransactionManagement
public class FollowServiceImpl implements FollowService{

    private final EntityManager em;

    private final FollowRepository fRepository;

    public FollowServiceImpl(EntityManager em, FollowRepository fRepository) {
        this.em = em;
        this.fRepository = fRepository;
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
        assert deleteFollow != null;
        fRepository.delete(deleteFollow);
    }

    @Override
    public List<User> getFollowers(Long id) {
        String hql = "SELECT f.follower FROM Follow f WHERE f.following.id = :id";
        Query query = em.createQuery(hql);
        query.setParameter("id", id);
        return query.getResultList();
    }

    @Override
    public List<User> getFollowings(Long id) {
        String hql = "SELECT f.following FROM Follow f WHERE f.follower.id = :id";
        Query query = em.createQuery(hql);
        query.setParameter("id", id);
        return query.getResultList();
    }
    
}
