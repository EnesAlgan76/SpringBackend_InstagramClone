package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.dto.FilterDTO;
import com.example.SpringBackend_InstagramClone.dto.UserSummaryDTO;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    BaseResponse getUserById(String userId);

    List<UserSummaryDTO> searchUsersByUsername(String username);

    User createUser(User user);

    boolean checkUserExists(String fullName, String email, String tel);

    BaseResponse authenticateUser(String userNameOrTelOrMail, String password);


    List<User> getUsersByFilter(List<FilterDTO> filterDTOList);

    Page<User> getUsersByFilterWithPaggination(List<FilterDTO> filterDTOList, int page, int size);

    BaseResponse updateFcmToken(String userId, String newFcmToken);

    BaseResponse incrementPostCount(String userId);

    BaseResponse getFCMToken(String userId);


    BaseResponse incrementFollowerCount(String userId);
    BaseResponse incrementFollowCount(String userId);


    void deleteUserById(String userId);

    BaseResponse updateUserProfile(String userName, String newFullName, String newUserName, String newBiography, String newSelectedImageUri);
}
