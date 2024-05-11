package com.example.shingles;

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

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class JoinPasswordActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText pwText, pwCheckText;
    private Button joinButton;
    String password, passwordCheck, id;
    private NetworkService mNetworkService;
    final String tag = "Backend : ";
    final String baseUrl = "https://e44e-219-255-158-170.ngrok-free.app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joinpassword);

        Intent intent = getIntent();
        id = intent.getStringExtra("id");

        pwText = findViewById(R.id.join_pw);
        pwCheckText = findViewById(R.id.join_pw_confirm);
        joinButton = findViewById(R.id.join2_continue_button);

        joinButton.setOnClickListener(this);
        pwCheckText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                password = pwText.getText().toString();
                passwordCheck = pwCheckText.getText().toString();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(password.equals(passwordCheck)){
                    joinButton.setTextColor(Color.parseColor("#FFFFFF"));
                    joinButton.setClickable(true);
                    joinButton.setBackgroundResource(R.drawable.activated_button);
                } else {
                    joinButton.setTextColor(Color.parseColor("#5862FA"));
                    joinButton.setClickable(false);
                    joinButton.setBackgroundResource(R.drawable.deactivated_button);
                }
            }
        });
        ApplicationController application = ApplicationController.getInstance();
        application.buildNetworkService(baseUrl);
        mNetworkService = ApplicationController.getInstance().getNetworkService();
    }

    @Override
    public void onClick(View v) {
        if(v == joinButton){
            password = pwText.getText().toString();
            passwordCheck = pwCheckText.getText().toString();

            if(password.equals(passwordCheck)){
                Intent intent = new Intent(JoinPasswordActivity.this, StartActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
//                JoinItem item = new JoinItem();
//                item.setUsername(id);
//                item.setPassword(password);
//
//                Call<JoinItem> postCall = mNetworkService.post_persons(item);
//                postCall.enqueue(new Callback<JoinItem>() {
//                    @Override
//                    public void onResponse(Call<JoinItem> call, Response<JoinItem> response) {
//                        if(response.isSuccessful()){
//                            Log.d("Backend : ","등록 완료");
//                            Log.d("Backend : ","Respose body : " + response.body().toString());
//
//                        }else {
//                            Log.d("Backend : ","Status Code : " + response.code());
//                            Log.d("Backend : ",response.errorBody().toString());
//                            Log.d("Backend : ",call.request().body().toString());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<JoinItem> call, Throwable t) {
//                        Log.d(tag,"Fail msg : " + t.getMessage());
//                    }
//
//                });

            } else{
                Log.d(tag,"안맞음");
                Toast toast = Toast.makeText(JoinPasswordActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }
}