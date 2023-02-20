package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.project.haruman.ChatLogItem;
import com.project.haruman.ChatLogItemView;
import com.project.haruman.Message;
import com.project.haruman.R;
import com.project.haruman.RequestedItem;
import com.project.haruman.RequestedItemView;

import java.util.ArrayList;
import java.util.List;


public class ChattingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        //xml => 객체
        EditText edittext_chatBar = findViewById(R.id.chattingActivity_editText_chatbar);
        ListView chatListView = findViewById(R.id.chattingActivity_chatList);
        Button button_send = findViewById(R.id.chattingActivity_button_send);

        //어댑터 생성 & 소환
        ChattingActivity.ChatLogAdapter adapter = new ChattingActivity.ChatLogAdapter();
        chatListView.setAdapter(adapter);

        //보내기 버튼을 눌렀을때 실행되는 코드
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String chatBar_log = String.valueOf(edittext_chatBar.getText());  //입력칸의 글을 가져옴
                adapter.addItem(new ChatLogItem(chatBar_log)); //어댑터에 방금 가져온 글을 추가함
                edittext_chatBar.setText(""); //입력칸을 깨끗하게 비움
                adapter.notifyDataSetChanged(); //어댑터를 새로고침 함
            }
        });
    }


    class ChatLogAdapter extends BaseAdapter {      //어댑터임

        private ArrayList<ChatLogItem> items = new ArrayList<ChatLogItem>();

        public void addItem(ChatLogItem item){
            items.add(item);
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ChatLogItemView view = new ChatLogItemView(getApplicationContext());

            ChatLogItem item = items.get(position);
            view.setImage(item.getImage());
            view.setText(item.getText());

            return view;
        }
    }
}