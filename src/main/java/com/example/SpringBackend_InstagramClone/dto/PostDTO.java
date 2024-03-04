package com.example.SpringBackend_InstagramClone.dto;

public class PostDTO {
    private String userId;
    private String content;
    private String creationDate;

    public PostDTO(String userId, String content, String creationDate) {
        this.userId = userId;
        this.content = content;
        this.creationDate = creationDate;
    }




    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }
}
