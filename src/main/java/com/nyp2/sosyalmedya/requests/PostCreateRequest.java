package com.nyp2.sosyalmedya.requests;

import jakarta.validation.constraints.NotNull;

public class PostCreateRequest {

    @NotNull
    private Long userId;
    @NotNull
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
