package com.nyp2.sosyalmedya.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nyp2.sosyalmedya.requests.FollowerCreateRequest;
import com.nyp2.sosyalmedya.services.FollowerService;

@Controller
@RequestMapping("/follower")
public class FollowerController {
    
    private FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping
    public void createFollower(@RequestParam FollowerCreateRequest followerCreateRequest) {
        followerService.createFollower(followerCreateRequest);
    }

    @DeleteMapping
    public void deleteFollower(@RequestParam Long followerId) {
        followerService.deleteFollower(followerId);
    }

}
