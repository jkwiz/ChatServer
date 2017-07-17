package com.jkwdrd.model;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

public class Chat {
    @NotNull
    private List<Message> messages = new ArrayList<>();

    public Chat() {
    }

    public Chat(List<Message> messages) {
        this.messages = messages;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "messages=" + messages +
                '}';
    }
}