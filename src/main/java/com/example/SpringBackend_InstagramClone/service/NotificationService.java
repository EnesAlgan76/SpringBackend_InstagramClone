package com.example.SpringBackend_InstagramClone.service;

import com.example.SpringBackend_InstagramClone.dto.NotificationDTO;
import com.example.SpringBackend_InstagramClone.model.Notification;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;

public interface NotificationService {
    BaseResponse addNotification(NotificationDTO notification);

    BaseResponse getAllNotificationsByUserId(String userId);

    BaseResponse deleteNotification(Integer notificationId);
}
