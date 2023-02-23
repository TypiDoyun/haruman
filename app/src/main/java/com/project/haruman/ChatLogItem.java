package com.project.haruman;

public class ChatLogItem{
    String chatText;
    int chatImageId;

    public ChatLogItem(String chatText, int chatImageId){
        this.chatText = chatText;
        this.chatImageId = chatImageId;
    }

    public ChatLogItem(String chatText){
        this.chatText = chatText;
    }

    public void setImage(int chatImageId){
        this.chatImageId = chatImageId;
    }

    public int getImage(){
        return this.chatImageId;
    }

    public void setText(String chatText){
        this.chatText = chatText;
    }

    public String getText(){
        return this.chatText;
    }
}

//이건 채팅로그 각각의 객체임