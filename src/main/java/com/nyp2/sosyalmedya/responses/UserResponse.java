package com.nyp2.sosyalmedya.responses;

public class UserResponse {

    private Long id;
    private String username;
    private int followerCount;
    private int followCount;

    public UserResponse(Long id, String username, int followerCount, int followCount) {
        this.id = id;
        this.username = username;
        this.followerCount = followerCount;
        this.followCount = followCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(int followerCount) {
        this.followerCount = followerCount;
    }

    public int getFollowCount() {
        return followCount;
    }

    public void setFollowCount(int followCount) {
        this.followCount = followCount;
    }
    
}
