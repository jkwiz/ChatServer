package com.jkwdrd.service;

import com.jkwdrd.model.Chat;
import com.jkwdrd.model.Message;

interface ChatService {
    void addMessage(Message message);

    Chat getChat();
}