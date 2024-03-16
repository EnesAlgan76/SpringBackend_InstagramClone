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
    @Column(name = "storyId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer storyId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
