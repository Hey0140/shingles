package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class RoomActivity extends AppCompatActivity {
    private StudioData studioData;
    private TextView room_name;
    private RoomAdapter adapter;
    private ArrayList<RoomData> roomlist = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        for(int i = 0; i < 5; i++){
            RoomData tempRoom = new RoomData();
            tempRoom.setOne_discount("13%");
            tempRoom.setTwo_discount("13%");
            tempRoom.setOne_account("20,000원");
            tempRoom.setTwo_account("40,000원");
            tempRoom.setOne_origin("23,000원");
            tempRoom.setTwo_origin("46,000원");
            roomlist.add(tempRoom);
        }

        RecyclerView recyclerView = findViewById(R.id.room_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));
        adapter = new RoomAdapter(roomlist);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new RoomAdapter.OnListItemSelected() {
            @Override
            public void onItemSelected(View v, int position) {
//                Intent intent = new Intent(this, );
//                startActivity(intent);
            }
        });
    }
}