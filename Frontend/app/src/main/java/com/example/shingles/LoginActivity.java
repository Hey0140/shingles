package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import javax.xml.transform.Result;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    final String baseUrl = "https://e44e-219-255-158-170.ngrok-free.app";
    private CardView cardView;
    private EditText idText, passwordText;
    private NetworkService mNetworkService;
    private String id = "test";
    private String password = "test1234";
    private Button login_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idText = findViewById(R.id.login_id);
        passwordText = findViewById(R.id.login_pw);
        login_Button = findViewById(R.id.login_page_button2);

        login_Button.setOnClickListener(this);

        ApplicationController application = ApplicationController.getInstance();
        application.buildNetworkService(baseUrl);
        mNetworkService = ApplicationController.getInstance().getNetworkService();
    }


    @Override
    public void onClick(View view) {
        if (view == login_Button){
            if( id.equals(idText.getText().toString()) && password.equals(passwordText.getText().toString() )){
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            } else {
                Toast toast = Toast.makeText(LoginActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT);
                toast.show();
            }

            JoinItem item = new JoinItem();

            item.setUsername(idText.getText().toString());
            item.setPassword(passwordText.getText().toString());


//            Call<JoinItem> postCall = mNetworkService.post_persons(item);
//            postCall.enqueue(new Callback<JoinItem>() {
//                @Override
//                public void onResponse(Call<JoinItem> call, Response<JoinItem> response) {
//                    if(response.isSuccessful()){
//                        Log.d("Backend : ","등록 완료");
//                        Log.d("Backend : ","Respose body : " + response.body().toString());
//                    }else {
//                        Log.d("Backend : ","Status Code : " + response.code());
//                        Log.d("Backend : ",response.errorBody().toString());
//                        Log.d("Backend : ",call.request().body().toString());
//                    }
//                }
//                @Override
//                public void onFailure(Call<JoinItem> call, Throwable t) {
//                    Log.d("Backend : ","Fail msg : " + t.getMessage());
//                }
//            });


//            Call<PersonItem> postCall = mNetworkService.login_persons(item);
//            postCall.enqueue(new Callback<PersonItem>() {
//                @Override
//                public void onResponse(Call<PersonItem> call, Response<PersonItem> response) {
//                    if(response.isSuccessful()){
//                        Log.d("Backend : ","등록 완료");
//                        Log.d("Backend : ","Respose body : " + response.raw());
//                        Log.d("Backend : ","Respose body : " + response.body().getTocken());
//                    } else{
//                        Log.d("Backend : ","Status Code : " + response.code());
//                        Log.d("Backend : ",response.errorBody().toString());
//                        Log.d("Backend : ",call.request().body().toString());
//                    }
//                }
//
//                @Override
//                public void onFailure(Call<PersonItem> call, Throwable t) {
//                    Log.d("Backend : ","Fail msg : " + t.getMessage());
//                }
//            });

        }
    }
}