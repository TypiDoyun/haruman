package com.project.haruman;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class PostActivity extends AppCompatActivity {

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

        Button mainbtn = findViewById(R.id.postActivity_button_back);
        Button chatbtn = findViewById(R.id.postActivity_button_chat);

        chatbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PostActivity.this,ChattingActivity.class);
                startActivity(intent);
            }
        });

        mainbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}