package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText idText, passwordText;
    public TextView joinText;
    private Button login_Button;
    String id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idText = findViewById(R.id.login_id);
        passwordText = findViewById(R.id.login_pw);
        login_Button = findViewById(R.id.login_page_button);
        joinText = findViewById(R.id.login_join_text);

        if(joinText == null){
            Log.i("dk", "djdjdjjd");
        }
        joinText.setOnClickListener(this);

        setContentView(R.layout.activity_login);
    }


    @Override
    public void onClick(View view) {
        if (view == joinText){

        }
    }
}