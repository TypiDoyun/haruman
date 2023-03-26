package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.project.haruman.R;


public class ProfileActivity extends AppCompatActivity {

    private String id;

    Button ownPostListBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        try {
            // handOveredActivity = 현재 액티비티의 이전 액티비티
            // 이전 액티비티에서 ID 등의 정보를 얻어오는 코드. 성공 & 실패.
            Intent handOveredActivity = getIntent();
            id = handOveredActivity.getStringExtra("Id");
        }finally {
            Toast.makeText(this, "아이디 가져옴 :" + id, Toast.LENGTH_SHORT).show();
        }

        ownPostListBtn = findViewById(R.id.profileActivity_button_ownPost);

        ownPostListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProfileActivity.this, OwnPostListActivity.class);
                intent.putExtra("Id",id);
                startActivity(intent);
            }
        });
    }




}