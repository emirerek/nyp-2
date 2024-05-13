package com.nyp2.sosyalmedya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyp2.sosyalmedya.entities.Follower;

public interface FollowerRepository extends JpaRepository<Follower, Long> {
    
    Follower findByFollowingUserIdAndFollowedUserId(Long followedUserId, Long followingUserId);

    boolean existsByFollowingUserIdAndFollowedUserId(Long followingUserId, Long followedUserId);

}
