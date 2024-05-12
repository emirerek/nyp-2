package com.nyp2.sosyalmedya.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyp2.sosyalmedya.requests.FollowerCreateRequest;
import com.nyp2.sosyalmedya.services.FollowerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/follower")
@Validated
public class FollowerController {
    
    private FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @PostMapping
    public void createFollower(@Valid @RequestBody FollowerCreateRequest followerCreateRequest) {
        followerService.createFollower(followerCreateRequest);
    }

    @DeleteMapping
    public void deleteFollower(@RequestParam Long followerId) {
        followerService.deleteFollower(followerId);
    }

}
