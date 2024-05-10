package com.nyp2.sosyalmedya.requests;

public class FollowerCreateRequest {
    
    Long followingUserId;
    Long followedUserId;

    public Long getFollowingUserId() {
        return followingUserId;
    }

    public Long getFollowedUserId() {
        return followedUserId;
    }

}
