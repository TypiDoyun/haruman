package com.project.haruman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class ChattingActivity extends AppCompatActivity {

    private EditText edittext_chatBar;
    private Button button_send;

    private String chatBar_log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        edittext_chatBar = findViewById(R.id.chattingActivity_editText_chatbar);
        button_send = findViewById(R.id.chattingActivity_button_send);

        /*edittext_chatBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });*/

        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chatBar_log = String.valueOf(edittext_chatBar.getText());
                edittext_chatBar.setText("");
                HideKeyBoard();

            }
        });
    }

    public void HideKeyBoard(){
        InputMethodManager inputManager = (InputMethodManager) this.getSystemService(ChattingActivity.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }
}