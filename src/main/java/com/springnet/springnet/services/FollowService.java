package com.springnet.springnet.services;

public interface FollowService {
    
    Long getCountOfFollowers(Long id);
    Long getCountOfFollowing(Long id);
}
