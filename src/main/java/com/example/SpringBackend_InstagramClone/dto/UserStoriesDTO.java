package com.example.SpringBackend_InstagramClone.dto;

import java.util.List;

public class UserStoriesDTO {
    private String username;
    private String fullName;
    private String profilePicture;
    private List<StoryDTO> stories;

    public UserStoriesDTO(String username, String fullName, String profilePicture, List<StoryDTO> stories) {
        this.username = username;
        this.fullName = fullName;
        this.profilePicture = profilePicture;
        this.stories = stories;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public List<StoryDTO> getStories() {
        return stories;
    }

    public void setStories(List<StoryDTO> stories) {
        this.stories = stories;
    }
}
