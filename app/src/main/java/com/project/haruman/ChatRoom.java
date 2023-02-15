package com.project.haruman;

public class ChatRoom {
    private User user;
    private Message latestMessage;

    public ChatRoom(User user, Message message) {
        this.user = user;
        this.latestMessage = message;
    }

    public User getUser() {
        return this.user;
    }

    public Message getLatestMessage() {
        return this.latestMessage;
    }
}
