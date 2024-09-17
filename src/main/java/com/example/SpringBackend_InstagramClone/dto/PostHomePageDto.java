package com.example.SpringBackend_InstagramClone.dto;

public class PostHomePageDto {
    private int postId;
    private String userId;
    private String userFullName;
    private String userProfileImage;
    private String content;
    private Long creationDate;
    private int likeCount;
    private String postDescription;
    private String userName;

    public PostHomePageDto() {
    }

    public PostHomePageDto(int postId, String userId, String userFullName, String userProfileImage, String content, Long creationDate, int likeCount, String postDescription, String userName) {
        this.postId = postId;
        this.userId = userId;
        this.userFullName = userFullName;
        this.userProfileImage = userProfileImage;
        this.content = content;
        this.creationDate = creationDate;
        this.likeCount = likeCount;
        this.postDescription = postDescription;
        this.userName = userName;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
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

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public String getPostDescription() {
        return postDescription;
    }

    public void setPostDescription(String postDescription) {
        this.postDescription = postDescription;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
