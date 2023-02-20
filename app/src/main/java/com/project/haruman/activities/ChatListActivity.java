package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.haruman.ChatListAdapter;
import com.project.haruman.ChatRoom;
import com.project.haruman.Gender;
import com.project.haruman.Message;
import com.project.haruman.MessageType;
import com.project.haruman.R;
import com.project.haruman.User;

import java.util.ArrayList;


public class ChatListActivity extends AppCompatActivity {

    public ArrayList<ChatRoom> chatList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        User user = new User("유저1", 19, Gender.Male, "01012344321");
        Message message = new Message(MessageType.Text, "안녕하세요");

        chatList.add(new ChatRoom(user, message));
        chatList.add(new ChatRoom(user, message));
        chatList.add(new ChatRoom(user, message));
        chatList.add(new ChatRoom(user, message));

        ListView listView = (ListView) findViewById(R.id.chatListActivity_chat_list);
        ChatListAdapter adapter = new ChatListAdapter(this, chatList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent intent = new Intent(ChatListActivity.this, ChattingActivity.class);
                startActivity(intent);
            }
        });
    }


}