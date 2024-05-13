package com.nyp2.sosyalmedya.requests;

import jakarta.validation.constraints.NotNull;

public class CommentUpdateRequest {
    
    @NotNull
    private Long id;
    @NotNull
    private String textContent;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

}
