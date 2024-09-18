package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.dto.PostHomePageDto;
import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.dto.PostDTO;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.PostRepository;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.PostService;
import com.example.SpringBackend_InstagramClone.utils.ConsolePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

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
            post.setExplanation(postDTO.getExplanation());
            post.setLikeCount(0);
            postRepository.save(post);
            return new BaseResponse(true,"Post Uploaded",null);
        }


    }

//    @Override
//    public PostUploadDTO getPostDTOById(Integer postId) {
//        return postRepository.findPostDTOById(postId);
//    }


    @Override
    public Post getPostById(Integer postId) {
        return postRepository.getPostById(postId);
    }

    @Override
    public BaseResponse getPostHomepageById(Integer postId) {
        PostHomePageDto post = postRepository.getPostHomePageById(postId);
        if (post == null) {
            return new BaseResponse(false, "No post with id", null);
        }
        return new BaseResponse(true, "Succesfull", post);
    }

    @Override
    public BaseResponse getAllPostsByUserId(String userId) {
        List<PostDTO> postDTOList;
        try {
            postDTOList = postRepository.getUserAllPost(userId);
            return new BaseResponse(true,"All post from user: "+ userId, postDTOList);
        } catch (Exception e) {
            return new BaseResponse(false,"Error getAllPostsByUserId ", null);
        }
    }

    @Override
    public BaseResponse getUserPagedPosts(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("creationDate").descending());
        List<PostDTO> postDTOList;
        try {
            postDTOList = postRepository.getUserPagedPosts(userId, pageable);
            return new BaseResponse(true, "All posts from user: " + userId, postDTOList);
        } catch (Exception e) {
            return new BaseResponse(false, "Error getAllPostsByUserId ", null);
        }
    }

    @Override
    public BaseResponse getPagedPostsFromFollowedUsers(String userId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("creationDate").descending());
        List<PostHomePageDto> postDTOList;
        try {
            postDTOList = postRepository.getPagedPostsFromFollowedUsers(userId, pageable);
            return new BaseResponse(true, "All posts from user: " + userId, postDTOList);
        } catch (Exception e) {
            return new BaseResponse(false, "Error getAllPostsByUserId ", null);
        }
    }





    @Override
    public BaseResponse getUserPostsHomePage(String userId) {
        List<PostHomePageDto> postHomePageDtos;
        try {
            postHomePageDtos = postRepository.getUserPostsHomePage(userId);
            return new BaseResponse(true,"All post from user: "+ userId, postHomePageDtos);
        } catch (Exception e) {
            return new BaseResponse(false,"Error getAllPostsByUserId ", null);
        }
    }



}
