package com.example.SpringBackend_InstagramClone.controller;


import com.example.SpringBackend_InstagramClone.dto.NotificationDTO;
import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }



    @PostMapping
    public BaseResponse createPost(@RequestBody PostDTO post){
        return postService.createPost(post);
    }


    @GetMapping("post/{postId}")
    public Post getPostById(@PathVariable Integer postId){
        return postService.getPostById(postId);
    }

    @GetMapping("postHome/{postId}")
    public ResponseEntity<BaseResponse> getPostHomepageById(@PathVariable Integer postId){
        return new ResponseEntity<>(postService.getPostHomepageById(postId),HttpStatus.OK);
    }

    @GetMapping("/allposts/{userId}")
    public ResponseEntity<BaseResponse> getAllPostsByUserId(@PathVariable String userId) {
        return new ResponseEntity<>(postService.getAllPostsByUserId(userId),HttpStatus.OK);
    }

    @GetMapping("getUserPostsHomePage/{userId}")
    public ResponseEntity<BaseResponse> getUserPosts(@PathVariable String userId){
        return new ResponseEntity<>(postService.getUserPostsHomePage(userId),HttpStatus.OK);
    }



}
