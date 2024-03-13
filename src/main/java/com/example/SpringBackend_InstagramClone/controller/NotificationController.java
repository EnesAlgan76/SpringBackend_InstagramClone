package com.example.SpringBackend_InstagramClone.controller;


import com.example.SpringBackend_InstagramClone.dto.NotificationDTO;
import com.example.SpringBackend_InstagramClone.model.Notification;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.NotificationService;
import com.example.SpringBackend_InstagramClone.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/notifications")
public class NotificationController {

    private final NotificationService notificationService;

    @Autowired
    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping
    public ResponseEntity<BaseResponse> addNotification(@RequestBody NotificationDTO notificationDto){
        return new ResponseEntity<>(notificationService.addNotification(notificationDto), HttpStatus.OK);
    }


    @GetMapping("/getAllUserNotifications")
    public ResponseEntity<BaseResponse> getAllUserNotifications(@RequestParam(value = "userId") String userId){
        return new ResponseEntity<>(notificationService.getAllNotificationsByUserId(userId), HttpStatus.OK);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> deleteNotification(@RequestParam(value = "notificationId") Integer notificationId) {
        return new ResponseEntity<>(notificationService.deleteNotification(notificationId), HttpStatus.OK);
    }
}
