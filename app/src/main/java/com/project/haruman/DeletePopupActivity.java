package com.project.haruman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class DeletePopupActivity extends AppCompatActivity {

    Button yesBtn;
    Button noBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_popup);

        yesBtn = findViewById(R.id.deletePopupActivity_button_yes);
        noBtn = findViewById(R.id.deletePopupActivity_button_no);

        yesBtn.setOnClickListener(new View.OnClickListener() {
            // '예' 버튼을 눌렀을때 발생하는 클릭 이벤트
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "예쓰", Toast.LENGTH_SHORT).show();
            }
        });

        noBtn.setOnClickListener(new View.OnClickListener() {
            // '아니오' 버튼을 눌렀을때 발생하는 클릭 이벤트
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //바깥레이어 클릭시 안닫히게
        if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
            return false;
        }
        return true;
    }

    @Override
    public void onBackPressed() {
        //안드로이드 백버튼 막기
        return;
    }
}