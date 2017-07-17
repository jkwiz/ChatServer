package com.jkwdrd.controllers;

import com.jkwdrd.model.Chat;
import com.jkwdrd.model.Message;
import com.jkwdrd.service.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {
    private final ChatServiceImpl chatService;

    @Autowired
    public ChatController(ChatServiceImpl chatService) {
        this.chatService = chatService;
    }

    @PostMapping(value = "/message", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void addMessage(@RequestBody Message message) {
        chatService.addMessage(message);
    }

    @GetMapping("/chat")
    public Chat getChat() {
        return chatService.getChat();
    }
}