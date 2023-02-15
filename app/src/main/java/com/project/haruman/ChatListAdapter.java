package com.project.haruman;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatListAdapter extends BaseAdapter {

    public ArrayList<ChatRoom> chatList;

    private LayoutInflater inflater;

    public ChatListAdapter(Context context, ArrayList<ChatRoom> chatList) {
        this.chatList = chatList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return chatList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public ChatRoom getItem(int position) {
        return chatList.get(position);
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        ChatRoom chatRoom = chatList.get(position);
        View view = inflater.inflate(R.layout.chat_item, null);

        ImageView profileImage = (ImageView) view.findViewById(R.id.profile_image);
        TextView roomName = (TextView)view.findViewById(R.id.room_name);
        TextView latestMessage = (TextView)view.findViewById(R.id.latest_message);

        profileImage.setImageResource(R.drawable.poppy);
        roomName.setText(chatRoom.getUser().getName());
        latestMessage.setText(chatRoom.getLatestMessage().getText());

        return view;
    }
}
