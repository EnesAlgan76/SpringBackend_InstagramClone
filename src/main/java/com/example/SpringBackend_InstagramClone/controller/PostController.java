package com.example.SpringBackend_InstagramClone.controller;


import com.example.SpringBackend_InstagramClone.dto.PostDTO;
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
        try {
            return postService.createPost(post);
        }catch (Exception e){
            return new BaseResponse(true,"ERROR",e.getMessage());
        }

    }


    @GetMapping("/post/{postId}")
    public PostDTO getPostById(@PathVariable Integer postId){
        return postService.getPostDTOById(postId);
    }


}
