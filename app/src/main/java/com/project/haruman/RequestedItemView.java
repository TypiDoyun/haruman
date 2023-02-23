package com.project.haruman;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class RequestedItemView extends LinearLayout {
    TextView titleView, timeView, locationView, payView;

    public RequestedItemView(Context context) {
        super(context);
        init(context);
    }

    public RequestedItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.requested_item, this, true);

        titleView = findViewById(R.id.RequestedItem_textView_title);
        timeView = findViewById(R.id.RequestedItem_textView_time);
        locationView = findViewById(R.id.RequestedItem_textView_location);
        payView = findViewById(R.id.RequestedItem_textView_pay);
    }

    public void setTitle(String title){
        titleView.setText(title);
    }
    public void setTime(String time){
        timeView.setText(time);
    }
    public void setLocation(String location){
        locationView.setText(location);
    }
    public void setPay(String pay){
        payView.setText(pay);
    }
}
