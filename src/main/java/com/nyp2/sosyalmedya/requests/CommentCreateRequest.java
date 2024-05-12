package com.nyp2.sosyalmedya.requests;

import jakarta.validation.constraints.NotNull;

public class CommentCreateRequest {
    
    @NotNull
    private Long userId;
    @NotNull
    private Long postId;
    @NotNull
    private String text;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}