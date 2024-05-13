package com.nyp2.sosyalmedya.responses;

import java.time.LocalDateTime;

public class PostResponse {

    private Long id;
    private UserResponse user;
    private String textContent;
    private LocalDateTime creationDate;
    private int likeCount;
    private int commentCount;

    public PostResponse(Long id, UserResponse user, String textContent, LocalDateTime creationDate, int likeCount, int commentCount) {
        this.id = id;
        this.user = user;
        this.textContent = textContent;
        this.creationDate = creationDate;
        this.likeCount = likeCount;
        this.commentCount = commentCount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public int getLikeCount() {
        return this.likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getCommentCount() {
        return this.commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

}
