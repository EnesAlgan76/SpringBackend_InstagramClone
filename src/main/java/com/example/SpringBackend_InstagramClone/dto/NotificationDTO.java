package com.example.SpringBackend_InstagramClone.dto;

public class NotificationDTO {
    private Integer id;
    private String userId;
    private String profileImage;
    private String userName;
    private String type;
    private String time;
    private String postPreview;


    public NotificationDTO() {
    }

    public NotificationDTO(Integer id, String userId, String profileImage, String userName, String type, String time, String postPreview) {
        this.id = id;
        this.userId = userId;
        this.profileImage = profileImage;
        this.userName = userName;
        this.type = type;
        this.time = time;
        this.postPreview = postPreview;
    }


    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostPreview() {
        return postPreview;
    }

    public void setPostPreview(String postPreview) {
        this.postPreview = postPreview;
    }
}
