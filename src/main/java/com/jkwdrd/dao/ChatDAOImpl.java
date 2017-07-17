package com.jkwdrd.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jkwdrd.model.Chat;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;

@Component
public class ChatDAOImpl implements ChatDAO {
    private static final String CHAT_FILE_NAME = "/tmp/chats.json";

    @Override
    public void writeChat(Chat chat) throws IOException {
        FileWriter fw = null;
        try {
            Gson gson = new GsonBuilder().create();
            fw = new FileWriter(CHAT_FILE_NAME);
            gson.toJson(chat, fw);
        } finally {
            IOUtils.closeQuietly(fw);
        }
    }

    @Override
    public Chat getChat() throws IOException {
        Chat chat;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(CHAT_FILE_NAME));
            Gson gson = new GsonBuilder().create();
            chat = gson.fromJson(br, Chat.class);
            Collections.sort(chat.getMessages());
        } finally {
            IOUtils.closeQuietly(br);
        }
        return chat;
    }
}