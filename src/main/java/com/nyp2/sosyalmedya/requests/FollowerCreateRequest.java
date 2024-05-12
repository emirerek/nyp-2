package com.nyp2.sosyalmedya.requests;

import jakarta.validation.constraints.NotNull;

public class FollowerCreateRequest {
    
    @NotNull
    private Long followingUserId;
    @NotNull
    private Long followedUserId;

    public Long getFollowingUserId() {
        return followingUserId;
    }

    public void setFollowingUserId(Long followingUserId) {
        this.followingUserId = followingUserId;
    }

    public Long getFollowedUserId() {
        return followedUserId;
    }

    public void setFollowedUserId(Long followedUserId) {
        this.followedUserId = followedUserId;
    }

}
