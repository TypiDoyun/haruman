package com.project.haruman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.mainActivity_post_list);

        MainActivity.PostAdapter adapter = new MainActivity.PostAdapter();

        adapter.addItem(new RequestedItem("자고싶다","11:11","유니버스","500"));
        adapter.addItem(new RequestedItem("개졸리다","22:22","멀티버스","250"));
        adapter.addItem(new RequestedItem("쉬고싶다","33:33","시내버스","125"));

        listView.setAdapter(adapter);

        Button chattingbtn = (Button) findViewById(R.id.mainActivity_button_chat);
        Button settingbtn = (Button) findViewById(R.id.mainActivity_button_setting);
        Button profilebtn = (Button) findViewById(R.id.mainActivity_button_profile);
        Button requestbtn = (Button) findViewById(R.id.mainActivity_button_request);

        chattingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatListActivity.class);
                startActivity(intent);
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                startActivity(intent);
            }
        });
        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,RequestActivity.class);
                Intent intent = new Intent(MainActivity.this,RequestActivity.class);
                startActivity(intent);
            }
        });
    }

    class PostAdapter extends BaseAdapter {

        private ArrayList<RequestedItem> items = new ArrayList<>();

        public void addItem(RequestedItem item){
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
            RequestedItemView view = new RequestedItemView(getApplicationContext());

            RequestedItem item = items.get(position);
            view.setTitle(item.getTitle());
            view.setTime(item.getTime());
            view.setLocation(item.getLocation());
            view.setPay(item.getPay());

            return view;
        }
    }
}