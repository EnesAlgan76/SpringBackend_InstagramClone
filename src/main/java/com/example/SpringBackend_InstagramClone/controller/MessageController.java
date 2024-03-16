package com.example.SpringBackend_InstagramClone.controller;

import com.example.SpringBackend_InstagramClone.model.Message;
import com.example.SpringBackend_InstagramClone.serviceImpl.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MessageController {
    private final MessageService messageService;

    @Autowired
    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


//    @GetMapping("/conversation/{conversationId}") //localhost:8080/messages/conversation/conv1234
//    public List<Message> getAllMessagesByConversationId(@PathVariable String conversationId) {
//        return messageService.getAllMessagesByConversationId(conversationId);
//    }

    @PostMapping
    public Message createMessage(@RequestBody Message message){
        return messageService.createMessage(message);
    }
}
