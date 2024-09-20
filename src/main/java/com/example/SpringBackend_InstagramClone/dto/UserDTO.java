package com.example.SpringBackend_InstagramClone.dto;

public class UserDTO {
    private Integer id;
    private String userId;
    private String fullName;
    private String userName;
    private String email;
    private String phoneNumber;
    private String biography;
    private Integer followerCount;
    private Integer followingCount;
    private Integer postCount;
    private String profilePicture;
    private String fcmToken;

    // Constructor
    public UserDTO(Integer id, String userId, String fullName, String userName,
                   String email, String phoneNumber, String biography,
                   Integer followerCount, Integer followingCount,
                   Integer postCount, String profilePicture, String fcmToken) {
        this.id = id;
        this.userId = userId;
        this.fullName = fullName;
        this.userName = userName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.biography = biography;
        this.followerCount = followerCount;
        this.followingCount = followingCount;
        this.postCount = postCount;
        this.profilePicture = profilePicture;
        this.fcmToken = fcmToken;
    }

    public UserDTO() {

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getFollowerCount() {
        return followerCount;
    }

    public void setFollowerCount(Integer followerCount) {
        this.followerCount = followerCount;
    }

    public Integer getFollowingCount() {
        return followingCount;
    }

    public void setFollowingCount(Integer followingCount) {
        this.followingCount = followingCount;
    }

    public Integer getPostCount() {
        return postCount;
    }

    public void setPostCount(Integer postCount) {
        this.postCount = postCount;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}

