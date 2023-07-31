package com.springnet.springnet.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.springnet.springnet.models.User;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.springnet.springnet.models.Follow;
import com.springnet.springnet.repositories.FollowRepository;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Service
@EnableTransactionManagement
public class FollowServiceImpl implements FollowService{

    private final FollowRepository fRepository;

    public FollowServiceImpl(FollowRepository fRepository) {
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
        List<Follow> follows = fRepository.findByFollowingId(id);
        return follows.stream().map(Follow::getFollower).toList();
    }

    @Override
    public List<?> getFollowings(Long id) {
        List<Follow> follows = fRepository.findByFollowerId(id);
        return follows.stream().map(Follow::getFollowing).toList();
    }
    
}
