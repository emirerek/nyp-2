package com.nyp2.sosyalmedya.controllers;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nyp2.sosyalmedya.requests.FollowerCreateRequest;
import com.nyp2.sosyalmedya.services.FollowerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/followers")
@Validated
@CrossOrigin(origins = "http://localhost:5173")
public class FollowerController {
    
    private FollowerService followerService;

    public FollowerController(FollowerService followerService) {
        this.followerService = followerService;
    }

    @GetMapping
    public boolean isFollowing(@RequestParam Long followingUserId, @RequestParam Long followedUserId) {
        return followerService.isFollowing(followingUserId, followedUserId);
    }

    @PostMapping
    public void createFollower(@Valid @RequestBody FollowerCreateRequest followerCreateRequest) {
        followerService.createFollower(followerCreateRequest);
    }

    @DeleteMapping
    public void deleteFollower(@RequestParam Long followingUserId, @RequestParam Long followedUserId) {
        followerService.deleteFollower(followingUserId, followedUserId);
    }

}
