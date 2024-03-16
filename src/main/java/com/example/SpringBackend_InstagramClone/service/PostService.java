package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;

public interface PostService {

    BaseResponse createPost(PostDTO post);

    Post getPostById(Integer postId);

    BaseResponse getPostHomepageById(Integer postId);

    BaseResponse getAllPostsByUserId(String userId);

    BaseResponse getUserPostsHomePage(String userId);
}
