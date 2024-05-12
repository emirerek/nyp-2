package com.nyp2.sosyalmedya.requests;

import jakarta.validation.constraints.NotNull;

public class PostUpdateRequest {

    @NotNull
    private String textContent;

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

}
