package com.project.haruman;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RequestActivity extends AppCompatActivity {

    View button_upload;
    EditText edittext_title;
    EditText edittext_address;
    EditText edittext_age;
    View checkbox_male;
    View checkbox_female;
    TextView date_front;
    TextView date_back;
    EditText edittext_information;

    String title;
    String address;
    int age;
    boolean gender;
    int[] front_date = {0,0,0};
    int[] back_date = {0,0,0};
    int[] front_time = {0,0};
    int[] back_time = {0,0};
    String information;

    private DatePickerDialog.OnDateSetListener callbackMethod;
    private TextView textView_Date;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        this.

        button_upload.setOnClickListener(view -> Toast.makeText(RequestActivity.this, "업로드", Toast.LENGTH_SHORT).show());

        edittext_title.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                title = String.valueOf(edittext_title.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edittext_address.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                address = String.valueOf(edittext_address.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        edittext_age.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String bowl = edittext_age.getText().toString();
                if(bowl == null || bowl.length() == 0){
                    age = 0;
                }
                else{
                    age = Integer.parseInt(edittext_age.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        this.InitializeListener();
    }

    public void InitializeView(){
        button_upload = findViewById(R.id.requestActivity_button_upload);
        edittext_title = (EditText) findViewById(R.id.requestActivity_edittext_title);
        edittext_address = (EditText) findViewById(R.id.requestActivity_edittext_address);
        edittext_age = (EditText) findViewById(R.id.requestActivity_edittext_age);
        checkbox_male = findViewById(R.id.requestActivity_checkbox_male);
        checkbox_female = findViewById(R.id.requestActivity_checkbox_female);
        date_front = findViewById(R.id.requestActivity_edittext_date_front);
        date_back = findViewById(R.id.requestActivity_back_datePicker);
        edittext_information = (EditText) findViewById(R.id.requestActivity_edittext_information);
    }

    public void InitializeListener(){
        callbackMethod = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date_front.setText(year + "-" + month + "-" + dayOfMonth);
            }
        };
    }

    public void OnClickHandler_Front(View view){
        DatePickerDialog dialog = new DatePickerDialog(this, callbackMethod, 2023, 5, 24);

        dialog.show();
    }

}
