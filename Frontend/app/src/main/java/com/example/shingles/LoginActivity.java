package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText idText, passwordText;
    private Button loginButton;
    String id, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        idText = findViewById(R.id.login_id);
        passwordText = findViewById(R.id.login_pw);
        loginButton = findViewById(R.id.login_button);

        loginButton.setOnClickListener(this);

        setContentView(R.layout.activity_login);
    }


    @Override
    public void onClick(View v) {
        if(v == loginButton){
            id = String.valueOf(idText.getText());
            password = String.valueOf(passwordText.getText());

        }
    }
}