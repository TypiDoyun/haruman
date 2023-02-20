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

public class OwnPostListActivity extends AppCompatActivity {

    Button backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_own_post_list);

        backBtn = findViewById(R.id.ownPostListActivity_button_back);

        ListView ownPostListView = findViewById(R.id.ownPostListActivity_listView_ownPost);

        OwnPostListActivity.OwnPostAdapter adapter = new OwnPostListActivity.OwnPostAdapter();

        adapter.addItem(new RequestedItem("너무자고싶다", "111:111", "슈퍼유니버스", "5000"));
        adapter.addItem(new RequestedItem("삽살개졸리다", "222:222", "싱글멀티버스", "2500"));
        adapter.addItem(new RequestedItem("겁나쉬고싶다", "333:333", "광역시시내버스", "1250"));

        ownPostListView.setAdapter(adapter);

        ownPostListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                adapter.notifyDataSetChanged();

                Toast.makeText(getApplicationContext(), (i + 1) + "번째 글임.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(OwnPostListActivity.this, PostActivity.class);
                startActivity(intent);
                //데이터베이스 관련된 코드 추가예정
                //데이터베이스 관련된 코드 추가예정
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
    class OwnPostAdapter extends BaseAdapter {

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