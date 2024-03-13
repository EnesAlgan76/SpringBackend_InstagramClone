package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.dto.NotificationDTO;
import com.example.SpringBackend_InstagramClone.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {



    @Query("SELECT new com.example.SpringBackend_InstagramClone.dto.NotificationDTO(n.id, n.user.userId, n.type, n.time, n.postPreview, n.fromUserId, n.fromUserProfilePicture, n.fromUserName) FROM Notification n WHERE n.user.userId = :userId")
   List<NotificationDTO> getUserAllNotifications(String userId);

}
