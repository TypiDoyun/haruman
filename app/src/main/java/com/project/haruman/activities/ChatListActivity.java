package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.project.haruman.ChatListAdapter;
import com.project.haruman.ChatRoom;
import com.project.haruman.Gender;
import com.project.haruman.Message;
import com.project.haruman.MessageType;
import com.project.haruman.R;
import com.project.haruman.User;

import java.util.ArrayList;


public class ChatListActivity extends AppCompatActivity {

    private String id;

    public ArrayList<ChatRoom> chatList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        try {
            // handOveredActivity = 현재 액티비티의 이전 액티비티
            // 이전 액티비티에서 ID 등의 정보를 얻어오는 코드. 성공 & 실패.
            Intent handOveredActivity = getIntent();
            id = handOveredActivity.getStringExtra("Id");
        }finally {
            Toast.makeText(this, "아이디 가져옴 :" + id, Toast.LENGTH_SHORT).show();
        }

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