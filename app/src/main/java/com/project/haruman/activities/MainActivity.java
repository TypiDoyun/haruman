package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.project.haruman.R;
import com.project.haruman.RequestedItem;
import com.project.haruman.RequestedItemView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            // handOveredActivity = 현재 액티비티의 이전 액티비티
            // 이전 액티비티에서 ID 등의 정보를 얻어오는 코드. 성공 & 실패.
            Intent handOveredActivity = getIntent();
            id = handOveredActivity.getStringExtra("Id");
        }finally {
            Toast.makeText(this, "아이디 가져옴 :" + id, Toast.LENGTH_SHORT).show();
        }

        ListView postListView = findViewById(R.id.mainActivity_post_list);

        MainActivity.PostAdapter adapter = new MainActivity.PostAdapter();

        adapter.addItem(new RequestedItem("야붕이 조졌다","11:11","맘스터치 고림점","500"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","22:22","GS25 고림점","250"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));
        adapter.addItem(new RequestedItem("편붕이 조졌다","33:33","CU 고림점","125"));

        postListView.setAdapter(adapter);

        postListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), (i+1)+"번째 글.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, PostActivity.class);
                intent.putExtra("Id",id);
                startActivity(intent);
                //데이터베이스 관련된 코드 추가예정
                //데이터베이스 관련된 코드 추가예정
            }
        });

        Button chattingbtn = (Button) findViewById(R.id.mainActivity_button_chat);
        Button settingbtn = (Button) findViewById(R.id.mainActivity_button_setting);
        Button profilebtn = (Button) findViewById(R.id.mainActivity_button_profile);
        Button requestbtn = (Button) findViewById(R.id.mainActivity_button_request);

        chattingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ChatListActivity.class);
                intent.putExtra("Id",id);
                startActivity(intent);
            }
        });
        settingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SettingActivity.class);
                intent.putExtra("Id",id);
                startActivity(intent);
            }
        });
        profilebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,ProfileActivity.class);
                intent.putExtra("Id",id);
                startActivity(intent);
            }
        });
        requestbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(MainActivity.this,RequestActivity.class);
                Intent intent = new Intent(MainActivity.this,RequestActivity.class);
                intent.putExtra("Id",id);
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