package com.project.haruman.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.project.haruman.R;


public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Button signupbtn = findViewById(R.id.settingActivity_button_signup);

        signupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

        ImageButton alarmbtn = findViewById(R.id.settingActivity_imageButton_alarm);
        alarmbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
                startActivity(intent);
            }
        });

    }
}