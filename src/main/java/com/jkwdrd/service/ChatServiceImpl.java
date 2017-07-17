package com.jkwdrd.service;

import com.jkwdrd.dao.ChatDAOImpl;
import com.jkwdrd.model.Chat;
import com.jkwdrd.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChatServiceImpl implements ChatService {
    private final ChatDAOImpl chatDAO;

    @Autowired
    public ChatServiceImpl(ChatDAOImpl chatDAO) {
        this.chatDAO = chatDAO;
    }

    @Override
    public void addMessage(Message message) {
        try {
            Chat chat = getChat();
            if (chat == null) {
                chat = new Chat();
            }
            chat.getMessages().add(message);
            chatDAO.writeChat(chat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Chat getChat() {
        try {
            return chatDAO.getChat();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}