package com.example.SpringBackend_InstagramClone.controller;

import com.example.SpringBackend_InstagramClone.dto.FilterDTO;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }





    @GetMapping("/user/{userId}")
    public BaseResponse getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @DeleteMapping("/user/{userId}")
    public ResponseEntity<BaseResponse> deleteUserById(@PathVariable String userId) {
        try {
            userService.deleteUserById(userId);
            return new ResponseEntity<>(new BaseResponse(true,"User deleted successfully", null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new BaseResponse(false,"Error deleting user", null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/checkUserExists") //http://localhost:8080/checkUserExists?userName=JohnDoe&email=johndoe@example.com&phoneNumber=05415345880"
    public boolean checkUserExists(
            @RequestParam(value = "fullName", required = false) String fullName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "tel", required = false) String tel
    ) {
        return userService.checkUserExists( fullName,  email,  tel);
    }
    

    @PostMapping
    public User createUser(@RequestBody User message){
        return userService.createUser(message);
    }




    @GetMapping("/authenticateUser")
    public ResponseEntity<BaseResponse> authenticateUser(
            @RequestParam(value = "userNameOrTelOrMail") String userNameOrTelOrMail,
            @RequestParam(value = "password") String password
    ){
        BaseResponse baseResponse = userService.authenticateUser(userNameOrTelOrMail,password);
        return new ResponseEntity<>(baseResponse, HttpStatus.OK);
    }

    @GetMapping("/searchUsersByUsername/{input}")  // kullanıcı adı girilen değeri içeren tüm kullanıcıları(SummaryDTO) getirir.
    public BaseResponse searchUsersByUsername(@PathVariable String input) {
        return new BaseResponse(true,"User list contains input :"+input, userService.searchUsersByUsername(input));
    }




    @PutMapping("/updateFcmToken")
    public BaseResponse updateFcmToken(
            @RequestParam(value = "newFcmToken") String newFcmToken,
            @RequestParam(value = "userId") String userId
    ) {
        return userService.updateFcmToken(userId, newFcmToken);
    }

//    @PUT("users/updatePostCount")
//    fun updatePostCount(@Query("userId") userId: String) : Call<BaseResponse>

    @PutMapping("/incrementPostCount")
    public BaseResponse incrementPostCount(
            @RequestParam(value = "userId") String userId
    ) {
        return userService.incrementPostCount(userId);
    }

    @GetMapping("/getFCMToken")
    public BaseResponse getFCMToken(@RequestParam(value = "userId") String userId) {
        BaseResponse response = userService.getFCMToken(userId);
        if(response.isStatus()){
            try {
                return response;
            } catch (Exception e) {
                return new BaseResponse(false, "Bilinmeyen bir hata oluştu :"+e.getMessage(),response.getData());
            }
        }else {
            return response;
        }
    }



    @PutMapping("/incrementFollowerCount")
    public ResponseEntity<BaseResponse> incrementFollowerCount(@RequestParam("userId") String userId) {
        return new ResponseEntity<>(userService.incrementFollowerCount(userId), HttpStatus.OK);
    }

    @PutMapping("/incrementFollowCount")
    public ResponseEntity<BaseResponse> incrementFollowCount(@RequestParam("userId") String userId) {
        return new ResponseEntity<>(userService.incrementFollowCount(userId), HttpStatus.OK);

    }


    @PutMapping("/updateProfile")
    public ResponseEntity<BaseResponse> updateUserProfile(
            @RequestParam String userName,
            @RequestParam(required = false) String newFullName,
            @RequestParam(required = false) String newUserName,
            @RequestParam(required = false) String newBiography,
            @RequestParam(required = false) String newSelectedImageUri) {

        return new ResponseEntity<>(userService.updateUserProfile(userName, newFullName, newUserName, newBiography, newSelectedImageUri), HttpStatus.OK);
    }





}