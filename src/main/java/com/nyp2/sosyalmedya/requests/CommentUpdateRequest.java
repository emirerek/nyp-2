package com.nyp2.sosyalmedya.requests;

import jakarta.validation.constraints.NotNull;

public class CommentUpdateRequest {
    
    @NotNull
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
