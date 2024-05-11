package com.example.shingles;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;



public class JoinActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText idText, pwText, pwCheckText;
    private Button loginButton, joinButton;
    String id, password, passwordCheck;

    private final String BASE_URL = "http://localhost/";
    private MyAPI mMyAPI;
    final String tag = "Backend : ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        idText = findViewById(R.id.join_id);
        pwText = findViewById(R.id.join_pw);
        pwCheckText = findViewById(R.id.join_pw_confirm);
        joinButton = findViewById(R.id.join_button);
        loginButton = findViewById(R.id.to_login_button);

        joinButton.setOnClickListener(this);
        initMyAPI(BASE_URL);
    }


    private void initMyAPI(String baseUrl){
        Log.d(tag,"initMyAPI : " + baseUrl);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        mMyAPI = retrofit.create(MyAPI.class);
    }

    @Override
    public void onClick(View v) {
        if(v == joinButton){
            Log.d(tag, "POST");
            JoinData item = new JoinData();
            id = String.valueOf(idText.getText());
            password = String.valueOf(pwText.getText());

            item.setId(id);
            item.setPassword(password);

            Call<JoinData> postCall = mMyAPI.post_persons(item);
            postCall.enqueue(new Callback<JoinData>() {
                @Override
                public void onResponse(Call<JoinData> call, Response<JoinData> response) {
                    if(response.isSuccessful()){
                        Log.d(tag,"등록 완료");
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
        }
    }
}