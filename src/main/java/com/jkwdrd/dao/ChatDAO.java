package com.jkwdrd.dao;

import com.jkwdrd.model.Chat;

import java.io.IOException;

interface ChatDAO {
    void writeChat(Chat chat) throws IOException;

    Chat getChat() throws IOException;
}