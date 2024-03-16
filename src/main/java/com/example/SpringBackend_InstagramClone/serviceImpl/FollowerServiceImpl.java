package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.dto.PostHomePageDto;
import com.example.SpringBackend_InstagramClone.model.Follower;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.UserFollowerRepository;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.UserFollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerServiceImpl implements UserFollowerService {
    @Autowired
    UserFollowerRepository userFollowerRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public BaseResponse followUser(String followerId, String followedId) {

        User follower = userRepository.findUserById(followerId);
        User followed = userRepository.findUserById(followedId);

        if (follower == null || followed == null) {
            return new BaseResponse(false, "User Not Found", null);
        }

        if (userFollowerRepository.existsByFollower_UserIdAndFollowed_UserId(follower.getUserId(), followed.getUserId())) {
            return new BaseResponse(false, "User is already followed", null);
        }

        Follower newFollower = new Follower();
        newFollower.setFollower(follower);
        newFollower.setFollowed(followed);
        userFollowerRepository.save(newFollower);

        return new BaseResponse(true, "User followed successfully. Follower: " + follower.getUserName() + " Followed: " + followed.getUserName(), null);
    }



    @Override
    public BaseResponse unfollowUser(String followerId, String followedId) {

        User follower = userRepository.findUserById(followerId);
        User followed = userRepository.findUserById(followedId);

        if (follower == null || followed == null) {
            return new BaseResponse(false, "Unable to unfollow user. Invalid user IDs.", null);
        }

        Follower followerEntity = userFollowerRepository.findByFollowerAndFollowed(follower, followed);
        if (followerEntity != null) {
            userFollowerRepository.delete(followerEntity);
            return new BaseResponse(true, "User unfollowed successfully", null);
        } else {
            return new BaseResponse(false, "User is not currently being followed", null);
        }
    }

    @Override
    public BaseResponse checkFollowStatus(String followerId, String followedId) {
        try {
            if (userFollowerRepository.existsByFollower_UserIdAndFollowed_UserId(followerId, followedId)) {
                return new BaseResponse(true, "Following", true);
            }else {
                return new BaseResponse(true, "Not Following", false);
            }
        } catch (Exception e) {
            return new BaseResponse(false, "Error : "+e.getMessage(), null);
        }
    }


    @Override
    public BaseResponse getFollowedUserIds(String userId) {
        List<String> userIdList;
        try {
            userIdList = userFollowerRepository.getFollowedUserIds(userId);
            return new BaseResponse(true,"All post from user: "+ userId, userIdList);
        } catch (Exception e) {
            return new BaseResponse(false,"Error getAllPostsByUserId ", null);
        }
    }


}
