package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.PostRepository;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.PostService;
import com.example.SpringBackend_InstagramClone.utils.ConsolePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    PostRepository postRepository;
    UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse createPost(PostDTO postDTO) {
        String userIdString = postDTO.getUserId();
        User user = userRepository.findUserById(userIdString);
        if (user == null) {
            return new BaseResponse(true,"USER Not FOUND..",null);
        }else {
            ConsolePrinter.printYellow("USER FOUND..");
            Post post = new Post();
            post.setUser(user);
            post.setContent(postDTO.getContent());
            post.setCreationDate(postDTO.getCreationDate());
            postRepository.save(post);
            return new BaseResponse(true,"Post Uploaded",null);
        }
    }

    @Override
    public PostDTO getPostDTOById(Integer postId) {
        return postRepository.findPostDTOById(postId);
    }


//    @Override
//    public Post getPostById2(Integer postId) {
//        return postRepository.getPostById(postId);
//    }



}
