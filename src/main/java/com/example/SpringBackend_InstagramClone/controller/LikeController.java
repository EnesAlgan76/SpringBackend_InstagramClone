package com.example.SpringBackend_InstagramClone.controller;

import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.serviceImpl.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    // Add like
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> addLike(@RequestParam String userId, @RequestParam Integer postId) {
        BaseResponse response = likeService.addLike(userId, postId);
        return ResponseEntity.ok(response);
    }

    // Remove like
    @DeleteMapping("/remove")
    public ResponseEntity<BaseResponse> removeLike(@RequestParam String userId, @RequestParam Integer postId) {
        BaseResponse response = likeService.removeLike(userId, postId);
        return ResponseEntity.ok(response);
    }

    // Check if post is liked by user
    @GetMapping("/checkLikeStatus")
    public ResponseEntity<BaseResponse> isLiked(@RequestParam String userId, @RequestParam Integer postId) {
        BaseResponse response = likeService.isLiked(userId, postId);
        return ResponseEntity.ok(response);
    }
}