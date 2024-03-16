package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.model.Follower;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;

public interface UserFollowerService {
    BaseResponse followUser(String followerId, String followedId);

    BaseResponse unfollowUser(String followerId, String followedId);

    BaseResponse checkFollowStatus(String followerId, String followedId);


    BaseResponse getFollowedUserIds(String userId);
}
