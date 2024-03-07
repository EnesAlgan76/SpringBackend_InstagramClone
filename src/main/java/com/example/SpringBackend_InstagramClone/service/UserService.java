package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;

public interface UserService {

    BaseResponse getUserById(String userId);

    User createUser(User user);

    boolean checkUserExists(String fullName, String email, String tel);

    BaseResponse authenticateUser(String userNameOrTelOrMail, String password);


    BaseResponse updateFcmToken(String userId, String newFcmToken);
}
