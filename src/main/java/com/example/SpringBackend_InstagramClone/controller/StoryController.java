package com.example.SpringBackend_InstagramClone.controller;

import com.example.SpringBackend_InstagramClone.dto.StoryDTO;
import com.example.SpringBackend_InstagramClone.dto.UserStoriesDTO;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.serviceImpl.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stories")
public class StoryController {

    private final StoryService storyService;

    @Autowired
    public StoryController(StoryService storyService) {
        this.storyService = storyService;
    }

    // Get user with stories by userId
    @GetMapping("/{userId}")
    public ResponseEntity<BaseResponse> getUserStories(@PathVariable String userId) {
        try {
            List<UserStoriesDTO> storyDTO = storyService.getStoriesOfFollowedUsers(userId);
            BaseResponse response = new BaseResponse(true, "User stories retrieved successfully.", storyDTO);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            BaseResponse response = new BaseResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }


    @PostMapping("/{userId}")
    public ResponseEntity<BaseResponse> addStory(
            @PathVariable String userId,
            @RequestParam String storyImage,
            @RequestParam Long creationDate) {
        try {
            storyService.addStory(userId, storyImage, creationDate);
            BaseResponse response = new BaseResponse(true, "Story added successfully.", null);
            return ResponseEntity.ok(response);
        } catch (IllegalArgumentException e) {
            BaseResponse response = new BaseResponse(false, e.getMessage(), null);
            return ResponseEntity.badRequest().body(response);
        }
    }
}
