package com.nyp2.sosyalmedya.services;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Follower;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.FollowerRepository;
import com.nyp2.sosyalmedya.requests.FollowerCreateRequest;

@Service
public class FollowerService {
    
    private FollowerRepository followerRepository;
    private UserService userService;

    public FollowerService(FollowerRepository followerRepository, UserService userService) {
        this.followerRepository = followerRepository;
        this.userService = userService;
    }

    public void createFollower(FollowerCreateRequest followerCreateRequest) {
        User followingUser = userService.getUserById(followerCreateRequest.getFollowingUserId());
        User followedUser = userService.getUserById(followerCreateRequest.getFollowedUserId());
        if (followingUser == null && followedUser == null) {
            return;
        }
        Follower newFollower = new Follower();
        newFollower.setFollowed(followedUser);
        newFollower.setFollower(followingUser);
        followerRepository.save(newFollower);
    }

    public void deleteFollower(Long followerId) {
        followerRepository.deleteById(followerId);
    }

}
