package com.nyp2.sosyalmedya.requests;

public class CommentCreateRequest {
    
    Long userId;
    Long postId;
    String text;

    public Long getUserId() {
        return userId;
    }

    public Long getPostId() {
        return postId;
    }
    
    public String getText() {
        return text;
    }

}
