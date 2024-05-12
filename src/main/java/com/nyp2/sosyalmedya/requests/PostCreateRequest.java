package com.nyp2.sosyalmedya.requests;

public class PostCreateRequest {

    Long userId;
    String textContent;

    public String getTextContent() {
        return textContent;
    }

    public Long getUserId() {
        return userId;
    }

}