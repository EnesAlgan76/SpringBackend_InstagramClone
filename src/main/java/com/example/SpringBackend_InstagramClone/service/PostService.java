package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;

public interface PostService {

    BaseResponse createPost(PostDTO post);

    PostDTO getPostDTOById(Integer postId);
}
