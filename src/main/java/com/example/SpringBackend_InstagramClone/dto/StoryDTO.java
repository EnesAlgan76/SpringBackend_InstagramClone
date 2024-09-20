package com.example.SpringBackend_InstagramClone.dto;

public class StoryDTO {
    private Integer storyId;
    private String storyImage;
    private Long creationDate;

    public StoryDTO(Integer storyId, String storyImage, Long creationDate) {
        this.storyId = storyId;
        this.storyImage = storyImage;
        this.creationDate = creationDate;
    }

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public String getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(String storyImage) {
        this.storyImage = storyImage;
    }

    public Long getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Long creationDate) {
        this.creationDate = creationDate;
    }
}
