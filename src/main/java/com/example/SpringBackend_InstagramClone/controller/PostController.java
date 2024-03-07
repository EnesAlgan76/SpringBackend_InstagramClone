package com.example.SpringBackend_InstagramClone.controller;


import com.example.SpringBackend_InstagramClone.dto.PostUploadDTO;
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
    public BaseResponse createPost(@RequestBody PostUploadDTO post){
        try {
            return postService.createPost(post);
        }catch (Exception e){
            return new BaseResponse(true,"ERROR",e.getMessage());
        }

    }


//    @GetMapping("postDto/{postId}")
//    public PostUploadDTO getPostDtoById(@PathVariable Integer postId){
//        return postService.getPostDTOById(postId);
//    }


    @GetMapping("post/{postId}")
    public Post getPostById(@PathVariable Integer postId){
        return postService.getPostById(postId);
    }

    @GetMapping("postHome/{postId}")
    public BaseResponse getPostHomepageById(@PathVariable Integer postId){
        return postService.getPostHomepageById(postId);
    }


}
