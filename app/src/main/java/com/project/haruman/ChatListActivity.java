package com.project.haruman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ChatListActivity extends AppCompatActivity {

    public ArrayList<ChatRoom> chatList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        User user = new User("유저1");
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
                Toast.makeText(getApplicationContext(),
                        adapter.getItem(position).getLatestMessage().getText(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }


}