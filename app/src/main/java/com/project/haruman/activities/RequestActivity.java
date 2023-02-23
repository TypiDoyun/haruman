package com.project.haruman.activities;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.project.haruman.R;

import java.sql.Time;

public class RequestActivity extends AppCompatActivity {

    private View button_upload;
    private EditText edittext_title;
    private EditText edittext_address;
    private EditText edittext_ageMin;
    private EditText edittext_ageMax;
    private CheckBox checkBox_allGen;
    private CheckBox checkbox_male;
    private CheckBox checkbox_female;
    private TextView date_front;
    private TextView date_back;
    private TextView time_front;
    private TextView time_back;
    private EditText edittext_detail;

    private String title;
    private String address;
    private int ageMin;
    private int ageMax;
    private boolean[] gender = {false,false,false}; //성별 (성별무관, 남자, 여자)
    private int[] front_date = {0,0,0}; //시작 날짜
    private int[] back_date = {0,0,0}; //끝 날짜
    private int[] front_time = {0,0}; //시작시간
    private int[] back_time = {0,0}; //끝 시간
    private String detail;

    private DatePickerDialog.OnDateSetListener callbackMethod_date_front;
    private DatePickerDialog.OnDateSetListener callbackMethod_date_back;
    private TimePickerDialog.OnTimeSetListener callbackMethod_time_front;
    private TimePickerDialog.OnTimeSetListener callbackMethod_time_back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);

        this.UpdateDateValue(); // 154번 줄
        this.InitializeView(); // 125번 줄
        this.UpdateTimeValue(); // 248번 줄

        // 게시물 올리기를 누르면 RequestActivity 를 종료함. (추후에 서버로 넘기는 기능을 추가해야하긴 함)
        button_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        // 제목을 입력할때 실시간으로 title 문자열 변수에 내용을 입력함.
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

        // 주소를 입력할때 실시간으로 address 문자열 변수에 내용을 입력함.
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

        // 최소 나이를 입력할때 실시간으로 ageMin 정수 변수에 내용을 입력함.
        edittext_ageMin.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String bowl = edittext_ageMin.getText().toString();
                if(bowl == null || bowl.length() == 0){
                    ageMin = 0;
                }
                else{
                    ageMin = Integer.parseInt(edittext_ageMin.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // 최대 나이를 입력할때 실시간으로 ageMax 정수 변수에 내용을 입력함.
        edittext_ageMax.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String bowl = edittext_ageMax.getText().toString();
                if(bowl == null || bowl.length() == 0){
                    ageMax = 0;
                }
                else{
                    ageMax = Integer.parseInt(edittext_ageMax.getText().toString());
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // 세부사항을 입력할때 실시간으로 detail 문자열 변수에 내용을 입력함.
        edittext_detail.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                detail = String.valueOf(edittext_detail.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "http://127.0.0.1:3000/requestCreatePost";

        StringRequest stringRequest = new StringRequest(
                Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(RequestActivity.this, response, Toast.LENGTH_SHORT).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(RequestActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
        );

        queue.add(stringRequest);
    }

    //xml Id를 각각 변수에 집어넣는 함수..
    public void InitializeView(){
        button_upload = findViewById(R.id.requestActivity_button_upload);
        edittext_title = (EditText) findViewById(R.id.requestActivity_edittext_title);
        edittext_address = (EditText) findViewById(R.id.requestActivity_edittext_address);
        edittext_ageMin = (EditText) findViewById(R.id.requestActivity_edittext_age_min);
        edittext_ageMax = (EditText) findViewById(R.id.requestActivity_edittext_age_max);
        checkBox_allGen = (CheckBox) findViewById(R.id.requestActivity_checkbox_allGen);
        checkbox_male = (CheckBox)findViewById(R.id.requestActivity_checkbox_male);
        checkbox_female = (CheckBox)findViewById(R.id.requestActivity_checkbox_female);
        date_front = findViewById(R.id.requestActivity_edittext_date_front);
        date_back = findViewById(R.id.requestActivity_edittext_date_back);
        time_front = findViewById(R.id.requestActivity_edittext_time_front);
        time_back = findViewById(R.id.requestActivity_edittext_time_back);
        edittext_detail = (EditText) findViewById(R.id.requestActivity_edittext_detail);
    }

    // "날짜 지정" 버튼을 누를때 callbackMethod_date 변수에 선택된 날짜를 집어넣음.
    public void OnClickHandlerDatePickup(View view){
        switch (view.getId()){
            case R.id.requestActivity_front_datePicker:
                DatePickerDialog dialog_front = new DatePickerDialog(this, callbackMethod_date_front, 2023, 5, 24);
                dialog_front.show();
                break;

            case R.id.requestActivity_back_datePicker:
                DatePickerDialog dialog_back = new DatePickerDialog(this, callbackMethod_date_back, 2023, 5, 24);
                dialog_back.show();
                break;
        }
    }

    // callbackMethod_date 변수에 저장된 날짜를 뷰에 표시하고
    // 각각 front_date[년, 월, 일], back_date[년, 월, 일] 정수 배열에 입력함.
    public void UpdateDateValue(){
        callbackMethod_date_front = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date_front.setText(year + "-" + month + "-" + dayOfMonth);
                front_date[0] = year;
                front_date[1] = month;
                front_date[2] = dayOfMonth;
            }
        };

        callbackMethod_date_back = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                date_back.setText(year + "-" + month + "-" + dayOfMonth);
                back_date[0] = year;
                back_date[1] = month;
                back_date[2] = dayOfMonth;
            }
        };
    }

    // "시간 지정" 버튼을 누를때 callbackMethod_time 변수에 선택된 날짜를 집어넣음.
    public void OnClickHandlerTimePickup(View view){
        switch (view.getId()){
            case R.id.requestActivity_front_timePicker:
                TimePickerDialog dialog_front = new TimePickerDialog(this, callbackMethod_time_front, 12, 00, true);
                dialog_front.show();
                break;

            case R.id.requestActivity_back_timePicker:
                TimePickerDialog dialog_back = new TimePickerDialog(this, callbackMethod_time_back, 12, 00, true);
                dialog_back.show();
                break;
        }
    }

    // callbackMethod_time 변수에 저장된 시간을 뷰에 표시하고
    // 각각 front_time[시, 분], back_time[시, 분] 정수 배열에 입력함
    public void UpdateTimeValue(){
        callbackMethod_time_front = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time_front.setText(hourOfDay + ":" + minute);
                front_time[0] = hourOfDay;
                front_time[1] = minute;
            }
        };
        callbackMethod_time_back = new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                time_back.setText(hourOfDay + ":" + minute);
                back_time[0] = hourOfDay;
                back_time[1] = minute;
            }
        };
    }

    // 성별 체크박스를 선택하고 gender[전부, 남, 여] 배열에 true,false 형태로 입력함.
    public void OnClickHandlerCheckbox(View view){
        boolean checked = ((CheckBox) view).isChecked();
        int selectedCheckbox = 3;

        switch(view.getId()){
            case R.id.requestActivity_checkbox_allGen:
                if(checked){
                    selectedCheckbox = 0;

                    this.checkbox_male.setChecked(false);
                    this.checkbox_female.setChecked(false);

                }
                break;
            case R.id.requestActivity_checkbox_male:
                if(checked){
                    selectedCheckbox = 1;
                    this.checkbox_female.setChecked(false);
                    this.checkBox_allGen.setChecked(false);
                }
                break;
            case R.id.requestActivity_checkbox_female:
                if(checked){
                    selectedCheckbox = 2;
                    this.checkbox_male.setChecked(false);
                    this.checkBox_allGen.setChecked(false);
                }
                break;
        }
        AllFalseGender();
        this.gender[selectedCheckbox] = true;

        /*String a = "a = " + gender[0] + gender[1] + gender[2];
        edittext_address.setText(a);*/
    }

    // OnClickHandlerCheckbox 함수에서 사용하는 gender[] 배열을 초기화해주는 함수.
    public void AllFalseGender(){
        this.gender[0] = false;
        this.gender[1] = false;
        this.gender[2] = false;
    }



}
