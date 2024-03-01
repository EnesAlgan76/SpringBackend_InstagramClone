package com.example.SpringBackend_InstagramClone.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "stories")
public class Story {
    @Id
    @Column(name = "story_id")
    private Integer storyId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "story_image")
    private String storyImage;

    @Column(name = "story_date")
    private String storyDate;

    @Column(name = "storiescol")
    private String storiescol;

    public Integer getStoryId() {
        return storyId;
    }

    public void setStoryId(Integer storyId) {
        this.storyId = storyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getStoryImage() {
        return storyImage;
    }

    public void setStoryImage(String storyImage) {
        this.storyImage = storyImage;
    }

    public String getStoryDate() {
        return storyDate;
    }

    public void setStoryDate(String storyDate) {
        this.storyDate = storyDate;
    }

    public String getStoriescol() {
        return storiescol;
    }

    public void setStoriescol(String storiescol) {
        this.storiescol = storiescol;
    }
}
