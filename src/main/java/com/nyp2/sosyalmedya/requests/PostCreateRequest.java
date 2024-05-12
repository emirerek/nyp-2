package com.nyp2.sosyalmedya.requests;

public class PostCreateRequest {

    private Long userId;
    private String textContent;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

}
