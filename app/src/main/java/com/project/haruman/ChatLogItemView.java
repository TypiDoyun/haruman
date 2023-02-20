package com.project.haruman;


import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChatLogItemView extends LinearLayout {
    TextView chatTextView;
    ImageView chatImageView;

    public ChatLogItemView(Context context) {
        super(context);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.chat_log_item, this, true);

        chatImageView = findViewById(R.id.chatLogItem_image);
        chatTextView = findViewById(R.id.chatLogItem_chatText);
    }

    public void setImage(int resId){
        chatImageView.setImageResource(resId);
    }
    public void setText(String text){
        chatTextView.setText(text);
    }
}

//이건 ChatLogItemView 의 inflater 임