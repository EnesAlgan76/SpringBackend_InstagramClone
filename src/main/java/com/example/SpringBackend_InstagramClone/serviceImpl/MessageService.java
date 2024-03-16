package com.example.SpringBackend_InstagramClone.serviceImpl;

import com.example.SpringBackend_InstagramClone.model.Message;
import com.example.SpringBackend_InstagramClone.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }


    public Message createMessage(Message message) {
        return messageRepository.save(message);
    }

//    public List<Message> getAllMessagesByConversationId(String conversationId){
//        return messageRepository.findByConversationId(conversationId);
//    }
}
