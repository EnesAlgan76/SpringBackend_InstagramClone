package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.dto.PostUploadDTO;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;

public interface PostService {

    BaseResponse createPost(PostUploadDTO post);

//    PostUploadDTO getPostDTOById(Integer postId);

    Post getPostById(Integer postId);

    BaseResponse getPostHomepageById(Integer postId);
}
