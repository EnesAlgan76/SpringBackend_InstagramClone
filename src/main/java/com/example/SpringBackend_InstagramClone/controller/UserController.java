package com.example.SpringBackend_InstagramClone.controller;

import com.example.SpringBackend_InstagramClone.model.Message;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }




    @GetMapping("/user/{userId}")
    public User getUserById(@PathVariable Integer userId) {
        return userService.getUserById(userId);
    }



    @GetMapping("/checkUserExists") //http://localhost:8080/checkUserExists?userName=JohnDoe&email=johndoe@example.com"
    public boolean  findUserByUserNameOrEmail(
            @RequestParam(value = "userName", required = false) String userName,
            @RequestParam(value = "email", required = false) String email
    ) {
        return userService.findUserByUserNameOrEmail(userName, email);
    }
    

    @PostMapping
    public User createUser(@RequestBody User message){
        return userService.createUser(message);
    }
}