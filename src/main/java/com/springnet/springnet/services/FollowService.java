package com.springnet.springnet.services;

import com.springnet.springnet.models.Follow;

public interface FollowService {
    
    Long getCountOfFollowers(Long id);
    Long getCountOfFollowing(Long id);
    void setFollow(Follow follow);
    Long countFollow(Follow follow);
    void removeFollow(Follow follow);
}
