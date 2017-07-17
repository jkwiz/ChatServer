package com.jkwdrd.model;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class Message implements Comparable<Message> {
    @NotNull
    private Date time = new Date();
    private String name;
    private String text;

    public Message() {
    }

    public Message(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Message{" +
                "name='" + name + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    @Override
    public int compareTo(Message o) {
        return time.compareTo(o.getTime());
    }
}