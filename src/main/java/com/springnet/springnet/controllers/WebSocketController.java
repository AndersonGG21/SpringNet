package com.springnet.springnet.controllers;

import com.springnet.springnet.models.ChatMessage;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Controller
@AllArgsConstructor
public class WebSocketController {
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat.sendMessageV1")
    public ChatMessage sendMessageV1(@Payload ChatMessage chatMessage) {
        String dynamicSession = chatMessage.getSessionID();
        String destination = "/direct/" + dynamicSession;
        messagingTemplate.convertAndSend(destination, chatMessage);
        return chatMessage;
    }
}
