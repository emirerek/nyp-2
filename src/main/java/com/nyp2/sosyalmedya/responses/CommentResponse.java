package com.nyp2.sosyalmedya.responses;

import java.time.LocalDateTime;

public class CommentResponse {
    private Long id;
    private UserResponse user;
    private String textContent;
    private LocalDateTime creationDate;

    public CommentResponse(Long id, UserResponse user, String textContent, LocalDateTime creationDate) {
        this.id = id;
        this.user = user;
        this.textContent = textContent;
        this.creationDate = creationDate;
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
}

