package com.springnet.springnet.controllers;

import com.springnet.springnet.models.ChatMessage;
import com.springnet.springnet.models.MessageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import java.util.ArrayList;


@Controller
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/chat.onlineUsers")
    //@SendTo("/topic/online")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        messagingTemplate.convertAndSend("/topic/online", chatMessage);
        return chatMessage;
    }


    @MessageMapping("/chat.sendMessageV1")
    public ChatMessage sendMessageV1(@Payload ChatMessage chatMessage) {
        String dynamicSession = chatMessage.getSessionID();
        String destination = "/direct/" + dynamicSession;
        messagingTemplate.convertAndSend(destination, chatMessage);
        return chatMessage;
    }
}
