package com.springnet.springnet.services;

import com.springnet.springnet.models.Follow;
import com.springnet.springnet.models.User;

import java.util.List;

public interface FollowService {
    void setFollow(Follow follow);
    Long countFollow(Follow follow);
    void removeFollow(Follow follow);
    List<?> getFollowers(Long id);
    List<?> getFollowings(Long id);
}
