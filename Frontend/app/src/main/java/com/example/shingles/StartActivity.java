package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    private Button start_loginButton, start_joinButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        start_loginButton = findViewById(R.id.start_login_button);
        start_joinButton = findViewById(R.id.start_join_button);

        start_loginButton.setOnClickListener(this);
        start_joinButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view == start_loginButton){
            Intent intent = new Intent(StartActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        if(view == start_joinButton){
            Intent intent = new Intent(StartActivity.this, JoinActivity.class);
            startActivity(intent);
        }
    }
}