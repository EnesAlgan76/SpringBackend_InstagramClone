package com.example.SpringBackend_InstagramClone.repository;

import com.example.SpringBackend_InstagramClone.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

  // List<Message> findByConversationId(String conversationId);
}
