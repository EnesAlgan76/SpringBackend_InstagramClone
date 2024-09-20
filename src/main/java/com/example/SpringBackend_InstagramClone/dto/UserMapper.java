package com.example.SpringBackend_InstagramClone.dto;

import com.example.SpringBackend_InstagramClone.model.Notification;
import com.example.SpringBackend_InstagramClone.model.User;

public class UserMapper {

    public static UserDTO mapUserToDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUserId(user.getUserId());
        userDTO.setFullName(user.getFullName());
        userDTO.setUserName(user.getUserName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhoneNumber(user.getPhoneNumber());
        userDTO.setBiography(user.getBiography());
        userDTO.setFollowerCount(user.getFollowerCount());
        userDTO.setFollowingCount(user.getFollowingCount());
        userDTO.setPostCount(user.getPostCount());
        userDTO.setProfilePicture(user.getProfilePicture());
        userDTO.setFcmToken(user.getFcmToken());
        return userDTO;
    }


    public static UserSummaryDTO mapUserToListItemDTO(User user) {
        UserSummaryDTO userDTO = new UserSummaryDTO();
        userDTO.setUserId(user.getUserId());
        userDTO.setFullName(user.getFullName());
        userDTO.setUserName(user.getUserName());
        userDTO.setProfilePicture(user.getProfilePicture());
        return userDTO;
    }


}
