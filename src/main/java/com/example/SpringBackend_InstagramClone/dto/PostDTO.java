package com.example.SpringBackend_InstagramClone.dto;

public class PostDTO {
    private int postId;
    private String userId;
    private String content;
    private String explanation;
    private Long creationDate;
    private int likeCount;


    public PostDTO(int postId, String userId, String content, String explanation, Long creationDate, int likeCount) {
        this.postId = postId;
        this.userId = userId;
        this.content = content;
        this.explanation = explanation;
        this.creationDate = creationDate;
        this.likeCount = likeCount;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
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
}
