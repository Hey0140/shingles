package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText idText;
    private Button joinButton;
    int number;
    String id;
    String preText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        idText = findViewById(R.id.join_id);
        //pwText = findViewById(R.id.join_pw);
        //pwCheckText = findViewById(R.id.join_pw_confirm);
        joinButton = findViewById(R.id.join_continue_button);
        //loginButton = findViewById(R.id.back_login_button);


        joinButton.setOnClickListener(this);
        idText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() > 0){
                    joinButton.setClickable(true);
                    joinButton.setTextColor(Color.parseColor("#FFFFFF"));
                    joinButton.setBackgroundResource(R.drawable.activated_button);
                } else {
                    joinButton.setClickable(false);
                    joinButton.setTextColor(Color.parseColor("#5862FA"));
                    joinButton.setBackgroundResource(R.drawable.deactivated_button);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == joinButton){
            id = idText.getText().toString();
            if(v.isClickable()){
                Intent intent = new Intent(JoinActivity.this, JoinPasswordActivity.class);
                intent.putExtra("id", id);
                startActivity(intent);
            } else{
                Toast toast = Toast.makeText(JoinActivity.this, "아이디를 입력하세요", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }
}