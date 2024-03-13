package com.example.SpringBackend_InstagramClone.dto;

public class NotificationDTO {
    private Integer id;
    private String userId;
    private String type;
    private String time;
    private String postPreview;
    private String fromUserId;
    private String fromUserProfilePicture;
    private String fromUserName;


    public NotificationDTO() {
    }

    public NotificationDTO(Integer id, String userId, String type, String time, String postPreview, String fromUserId, String fromUserProfilePicture, String fromUserName) {
        this.id = id;
        this.userId = userId;
        this.type = type;
        this.time = time;
        this.postPreview = postPreview;
        this.fromUserId = fromUserId;
        this.fromUserProfilePicture = fromUserProfilePicture;
        this.fromUserName = fromUserName;
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

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getFromUserProfilePicture() {
        return fromUserProfilePicture;
    }

    public void setFromUserProfilePicture(String fromUserProfilePicture) {
        this.fromUserProfilePicture = fromUserProfilePicture;
    }

    public String getFromUserName() {
        return fromUserName;
    }

    public void setFromUserName(String fromUserName) {
        this.fromUserName = fromUserName;
    }
}
