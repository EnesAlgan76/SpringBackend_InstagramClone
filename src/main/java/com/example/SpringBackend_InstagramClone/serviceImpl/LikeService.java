package com.example.SpringBackend_InstagramClone.serviceImpl;


import com.example.SpringBackend_InstagramClone.model.Like;
import com.example.SpringBackend_InstagramClone.model.Post;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.LikeRepository;
import com.example.SpringBackend_InstagramClone.repository.PostRepository;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;


    // Add like to a post using userId and postId, returning BaseResponse
    @Transactional
    public BaseResponse addLike(String userId, Integer postId) {
        if (likeRepository.existsByUserIdAndPostId(userId, postId)) {
            return new BaseResponse(false, "User already liked this post", null);
        } else {
            Like like = new Like();
            like.setUserId(userId);
            like.setPostId(postId);
            likeRepository.save(like);
            postRepository.incrementLikeCount(postId);
            return new BaseResponse(true, "Post liked successfully", null);
        }
    }



    // Remove like from a post using userId and postId, returning BaseResponse
    @Transactional
    public BaseResponse removeLike(String userId, Integer postId) {
        try {
            likeRepository.deleteByUserIdAndPostId(userId,postId);
            postRepository.decrementLikeCount(postId);
            return new BaseResponse(true, "Like removed succesfully", null);
        }catch (Throwable e){
            return new BaseResponse(false, e.getMessage(), null);
        }
    }

    // Check if a user has liked a post using userId and postId, returning BaseResponse
    public BaseResponse isLiked(String userId, Integer postId) {
        boolean liked = likeRepository.existsByUserIdAndPostId(userId, postId);
        String message = liked ? "User has liked this post" : "User has not liked this post";
        return new BaseResponse(true, message, liked);
    }
}

