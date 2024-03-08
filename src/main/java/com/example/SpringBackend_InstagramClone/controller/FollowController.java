package com.example.SpringBackend_InstagramClone.controller;


import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.UserFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/follow")
public class FollowController {

    @Autowired
    private UserFollowerService userFollowerService;

    @PostMapping("/follow")
    public ResponseEntity<BaseResponse> followUser(@RequestParam String followerId, @RequestParam String followedId) {
        BaseResponse response = userFollowerService.followUser(followerId, followedId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/unfollow")
    public ResponseEntity<BaseResponse> unfollowUser(@RequestParam String followerId, @RequestParam String followedId) {
        BaseResponse response = userFollowerService.unfollowUser(followerId, followedId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
