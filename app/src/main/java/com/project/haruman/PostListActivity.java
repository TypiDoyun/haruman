package com.project.haruman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


public class PostListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_list);
    }

    public void OnClickHandler_Button(View view){
        Intent intent = new Intent(MainActivity.this, RequestActivity.class);
        startActivity(intent);
    }
}