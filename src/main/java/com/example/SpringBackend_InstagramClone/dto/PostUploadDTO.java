package com.example.SpringBackend_InstagramClone.dto;

public class PostUploadDTO {
    private String userId;
    private String content;
    private String creationDate;
    private int likeCount;


    public PostUploadDTO(String userId, String content, String creationDate, int likeCount) {
        this.userId = userId;
        this.content = content;
        this.creationDate = creationDate;
        this.likeCount = likeCount;
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

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }
}
