package com.springnet.springnet.controllers;

import com.springnet.springnet.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.models.Follow;
import com.springnet.springnet.services.FollowService;

import java.util.List;

@RestController
@RequestMapping("/api/follows")
public class FollowController {
    
    @Autowired
    private FollowService followService;

    @PostMapping("/follow-user")
    public void setFollow(@RequestBody Follow follow){
        if (followService.countFollow(follow) == 1) {
            followService.removeFollow(follow);
        }else{
            followService.setFollow(follow);
        }
    }

    @PostMapping("/check-follow")
    public Long checkFollow(@RequestBody Follow follow) {
        return followService.countFollow(follow);
    }

    @GetMapping("/{id}/followers")
    public List<User> getFollowers(@PathVariable Long id){
        return (List<User>) followService.getFollowers(id);
    }
    @GetMapping("/{id}/followings")
    public List<User> getFollowings(@PathVariable Long id){
        return (List<User>) followService.getFollowings(id);
    }
}
