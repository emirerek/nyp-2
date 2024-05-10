package com.nyp2.sosyalmedya.requests;

public class PostCreateRequest {

    Long userId;
    String text;

    public String getText() {
        return text;
    }

    public Long getUserId() {
        return userId;
    }

}