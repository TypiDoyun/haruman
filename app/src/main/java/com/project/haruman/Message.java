package com.project.haruman;

import lombok.Getter;

@Getter
public class Message {
    private MessageType messageType;
    private String text;
    private String url;

    public Message(MessageType messageType, String text) {
        this.messageType = messageType;
        this.text = text;
    }

}
