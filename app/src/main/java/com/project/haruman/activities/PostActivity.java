package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.haruman.R;


public class PostActivity extends AppCompatActivity {

    private String id;

    private String title;
    private String address;
    private int ageMin;
    private int ageMax;
    private boolean[] gender = {false,false,false}; //성별 (성별무관, 남자, 여자)
    private int[] front_date = {0,0,0}; //시작 날짜
    private int[] back_date = {0,0,0}; //끝 날짜
    private int[] front_time = {0,0}; //시작시간
    private int[] back_time = {0,0}; //끝 시간
    private String detail; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);

        try {
            // handOveredActivity = 현재 액티비티의 이전 액티비티
            // 이전 액티비티에서 ID 등의 정보를 얻어오는 코드. 성공 & 실패.
            Intent handOveredActivity = getIntent();
            id = handOveredActivity.getStringExtra("Id");
        }finally {
            Toast.makeText(this, "아이디 가져옴 :" + id, Toast.LENGTH_SHORT).show();
        }

        Button mainBtn = findViewById(R.id.postActivity_button_back);
        Button chatBtn = findViewById(R.id.postActivity_button_chat);
        Button deleteBtn = findViewById(R.id.postActivity_button_delete);

        //특정 조건에 의해서 삭제버튼을 숨기거나 보이게하기
        if(true){
            deleteBtn.setVisibility(View.VISIBLE);
        }
        else{
            deleteBtn.setVisibility(View.GONE);
        }

        chatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostActivity.this,ChattingActivity.class);
                startActivity(intent);
            }
        });

        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostActivity.this,DeletePopupActivity.class);
                startActivity(intent);
            }
        });
    }
}