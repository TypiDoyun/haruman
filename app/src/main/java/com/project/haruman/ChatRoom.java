package com.project.haruman;

import lombok.Getter;

@Getter
public class ChatRoom {
    private User user;
    private Message latestMessage;

    public ChatRoom(User user, Message message) {
        this.user = user;
        this.latestMessage = message;
    }
}
