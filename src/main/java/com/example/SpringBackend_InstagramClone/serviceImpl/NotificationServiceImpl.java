package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.dto.NotificationDTO;
import com.example.SpringBackend_InstagramClone.model.Notification;
import com.example.SpringBackend_InstagramClone.model.User;
import com.example.SpringBackend_InstagramClone.repository.NotificationRepository;
import com.example.SpringBackend_InstagramClone.repository.UserRepository;
import com.example.SpringBackend_InstagramClone.request_response.BaseResponse;
import com.example.SpringBackend_InstagramClone.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    NotificationRepository notificationRepository;
    UserRepository userRepository;

    @Autowired
    public NotificationServiceImpl(NotificationRepository notificationRepository,UserRepository userRepository) {
        this.notificationRepository = notificationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public BaseResponse addNotification(NotificationDTO notificationDTO) {
        try {
            User user = userRepository.findUserById(notificationDTO.getUserId());
          if (user == null) {
             return new BaseResponse(false,"SPRING addNotification: USER Not FOUND..",null);
         }else {
            Notification notification = new Notification();
            notification.setUser(user);
            notification.setTime(notificationDTO.getTime());
            notification.setType(notificationDTO.getType());
            notification.setPostPreview(notificationDTO.getPostPreview());
            notification.setFromUserId(notificationDTO.getFromUserId());
            notification.setFromUserName(notificationDTO.getFromUserName());
            notification.setFromUserProfilePicture(notificationDTO.getFromUserProfilePicture());
            notificationRepository.save(notification);

            return new BaseResponse(true,"SPRING addNotification: Notification added succesfully",notification);
        }

        } catch (Exception e) {
            return new BaseResponse(false,"SPRING addNotification: Error when adding notification: "+e.getMessage(), null);
        }
    }

    @Override
    public BaseResponse getAllNotificationsByUserId(String userId) {
       List<NotificationDTO> notificationList = notificationRepository.getUserAllNotifications(userId);
        return new BaseResponse(true,"All post from user: "+ userId, notificationList);
    }

    @Override
    public BaseResponse deleteNotification(Integer notificationId) {
        try {
            notificationRepository.deleteById(notificationId);
            return new BaseResponse(true,"Notification deleted successfully. Id: "+notificationId,null);
        } catch (Exception e) {
            return new BaseResponse(true,"Error while deleting. Error:"+e.getMessage(),null);
        }

    }

}
