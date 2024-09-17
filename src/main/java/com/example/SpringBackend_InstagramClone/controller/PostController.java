package com.example.SpringBackend_InstagramClone.controller;


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

    @GetMapping("pagedPosts")
    public ResponseEntity<BaseResponse> getPagedPostsByUserId(
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        try {
            BaseResponse response = postService.getUserPagedPosts(userId, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(false, "Error fetching posts", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/pagedPostsFollowed")
    public ResponseEntity<BaseResponse> getPagedPostsFromFollowedUsers(
            @RequestParam String userId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        try {
            BaseResponse response = postService.getPagedPostsFromFollowedUsers(userId, page, size);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(false, "Error fetching followed users' posts", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("getUserPostsHomePage/{userId}")
    public ResponseEntity<BaseResponse> getUserPosts(@PathVariable String userId){
        return new ResponseEntity<>(postService.getUserPostsHomePage(userId),HttpStatus.OK);
    }



}
