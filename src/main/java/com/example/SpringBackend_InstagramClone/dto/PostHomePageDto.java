package com.example.SpringBackend_InstagramClone.dto;

public class PostHomePageDto {
    private String userId;
    private String userFullName;
    private String userProfileImage;
    private String content;
    private String creationDate;
    private int likeCount;

    public PostHomePageDto() {
    }

    public PostHomePageDto(String userId, String userFullName, String userProfileImage, String content, String creationDate, int likeCount) {
        this.userId = userId;
        this.userFullName = userFullName;
        this.userProfileImage = userProfileImage;
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

    public String getUserFullName() {
        return userFullName;
    }

    public void setUserFullName(String userFullName) {
        this.userFullName = userFullName;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
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
