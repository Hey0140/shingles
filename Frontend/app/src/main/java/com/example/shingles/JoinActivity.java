package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Version;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText idText, pwText, pwCheckText;
    private Button loginButton, joinButton;
    String id, password, passwordCheck;
    private NetworkService mNetworkService;
    final String tag = "Backend : ";
    final String baseUrl = "https://e44e-219-255-158-170.ngrok-free.app";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        idText = findViewById(R.id.join_id);
        pwText = findViewById(R.id.join_pw);
        pwCheckText = findViewById(R.id.join_pw_confirm);
        joinButton = findViewById(R.id.join_button);
        loginButton = findViewById(R.id.back_login_button);

        joinButton.setOnClickListener(this);
        ApplicationController application = ApplicationController.getInstance();
        application.buildNetworkService(baseUrl);
        mNetworkService = ApplicationController.getInstance().getNetworkService();
    }

    @Override
    public void onClick(View v) {
        if(v == joinButton){
            Log.d(tag, "POST");

            id = String.valueOf(idText.getText());
            password = String.valueOf(pwText.getText());
            passwordCheck = String.valueOf(pwCheckText.getText());

            if(password == passwordCheck){

                JoinData item = new JoinData();
                item.setUsername(id);
                item.setPassword(password);


                Call<JoinData> postCall = mNetworkService.post_persons(item);
                postCall.enqueue(new Callback<JoinData>() {
                    @Override
                    public void onResponse(Call<JoinData> call, Response<JoinData> response) {
                        if(response.isSuccessful()){
                            Log.d(tag,"등록 완료");
                            Log.d(tag,"Respose body : " + response.body().toString());
                        }else {
                            Log.d(tag,"Status Code : " + response.code());
                            Log.d(tag,response.errorBody().toString());
                            Log.d(tag,call.request().body().toString());
                        }
                    }

                    @Override
                    public void onFailure(Call<JoinData> call, Throwable t) {
                        Log.d(tag,"Fail msg : " + t.getMessage());
                    }

                });

            } else{
                Toast toast = Toast.makeText(JoinActivity.this, "비밀번호가 다릅니다.", Toast.LENGTH_SHORT);
                toast.show();
            }

        }
    }
}