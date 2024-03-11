package com.example.SpringBackend_InstagramClone.controller;


import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public BaseResponse getPostHomepageById(@PathVariable Integer postId){
        return postService.getPostHomepageById(postId);
    }

    @GetMapping("/allposts/{userId}")
    public BaseResponse getAllPostsByUserId(@PathVariable String userId) {
        return postService.getAllPostsByUserId(userId);
    }


}
