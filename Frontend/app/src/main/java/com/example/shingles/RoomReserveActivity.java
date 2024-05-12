package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class RoomReserveActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView room_reserve_back_icon;
    Button reserv_button, room_reserve_checkbox;
    boolean checkbox = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_reserve);
        room_reserve_checkbox = findViewById(R.id.room_reserve_checkbox);
        reserv_button = findViewById(R.id.reserv_button);

        room_reserve_back_icon = findViewById(R.id.room_reserve_back_icon);

        reserv_button.setOnClickListener(this);
        room_reserve_back_icon.setOnClickListener(this);
        room_reserve_checkbox.setOnClickListener(this);
        checkbox = false;
    }

    @Override
    public void onClick(View view) {
        if(view == reserv_button){
            if(!checkbox){
                Toast toast = Toast.makeText(this, "확인박스를 클릭해주세요.", Toast.LENGTH_SHORT);
                toast.show();
            }else{
                Toast toast = Toast.makeText(this, "결제로 넘어갑니다.", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
        if(view == room_reserve_checkbox){
            if(!checkbox){
                checkbox = true;
                room_reserve_checkbox.setBackgroundResource(R.drawable.frame);
                reserv_button.setBackgroundResource(R.drawable.background_reserve_page);
                reserv_button.setTextColor(Color.parseColor("#FFFFFF"));
            } else{
                checkbox = false;
                room_reserve_checkbox.setBackgroundResource(R.drawable.checkbox);
                reserv_button.setBackgroundResource(R.drawable.none_background_reserve_page);
                reserv_button.setTextColor(Color.parseColor("#1C91F2"));
            }

        }
        if(view == room_reserve_back_icon){
            finish();
        }
    }
}