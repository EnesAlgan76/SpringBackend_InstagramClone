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


    @GetMapping("/checkUserExists") //http://localhost:8080/checkUserExists?userName=JohnDoe&email=johndoe@example.com&phoneNumber=05415345880"
    public boolean checkUserExists(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "email", required = false) String email,
            @RequestParam(value = "phoneNumber", required = false) String phoneNumber
    ) {
        return userService.checkUserExists(userName, email, phoneNumber);
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


    @PostMapping("/users00")
    public ResponseEntity<List<User>> getUsersByFilter(@RequestBody List<FilterDTO> filterDTOList) {
        return ResponseEntity.ok().body(userService.getUsersByFilter(filterDTOList));
    }


    @PostMapping("/users01")
    public ResponseEntity<Page<User>> getUsersByFilterWithPaggination(
            @RequestBody List<FilterDTO> filterDTOList,
            @RequestParam int page,
            @RequestParam int size) {
        return ResponseEntity.ok().body(userService.getUsersByFilterWithPaggination(filterDTOList,page,size));
    }


}