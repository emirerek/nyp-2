package com.nyp2.sosyalmedya.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nyp2.sosyalmedya.entities.Follower;
import com.nyp2.sosyalmedya.entities.User;
import com.nyp2.sosyalmedya.repositories.FollowerRepository;
import com.nyp2.sosyalmedya.repositories.UserRepository;
import com.nyp2.sosyalmedya.requests.FollowerCreateRequest;

@Service
public class FollowerService {
    
    private FollowerRepository followerRepository;
    private UserRepository userRepository;

    public FollowerService(FollowerRepository followerRepository, UserRepository userRepository) {
        this.followerRepository = followerRepository;
        this.userRepository = userRepository;
    }

    public boolean isFollowing(Long followingUserId, Long followedUserId) {
        return followerRepository.existsByFollowingUserIdAndFollowedUserId(followingUserId, followedUserId);
    }

    public void createFollower(FollowerCreateRequest followerCreateRequest) {
        if (followerCreateRequest.getFollowingUserId() == followerCreateRequest.getFollowedUserId()) {
            return;
        }
        Optional<User> followingUser = userRepository.findById(followerCreateRequest.getFollowingUserId());
        Optional<User> followedUser = userRepository.findById(followerCreateRequest.getFollowedUserId());
        if ((!followingUser.isPresent() || !followedUser.isPresent())) {
            return;
        }
        Follower newFollower = new Follower();
        newFollower.setFollowedUser(followedUser.get());
        newFollower.setFollowingUser(followingUser.get());
        followerRepository.save(newFollower);
    }

    public void deleteFollower(Long followingUserId, Long followedUserId) {
        Follower follower = followerRepository.findByFollowingUserIdAndFollowedUserId(followingUserId, followedUserId);
        if (follower == null) {
            return;
        }
        followerRepository.deleteById(follower.getId());
    }

}
