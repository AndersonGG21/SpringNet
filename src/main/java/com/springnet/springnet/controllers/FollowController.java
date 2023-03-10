package com.springnet.springnet.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springnet.springnet.services.FollowService;

@RestController
@RequestMapping("/api/follows")
public class FollowController {
    
    @Autowired
    private FollowService followService;

    @GetMapping("/count-followers/{id}")
    public Long getCountOfFollowers(@PathVariable Long id){
        return followService.getCountOfFollowers(id);
    }

    @GetMapping("/count-following/{id}")
    public Long getCountOfFollowing(@PathVariable Long id){
        return followService.getCountOfFollowing(id);
    }
}
