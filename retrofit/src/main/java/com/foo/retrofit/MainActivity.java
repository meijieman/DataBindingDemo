package com.foo.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.foo.retrofit.api.API;
import com.foo.retrofit.bean.User;
import com.foo.retrofit.model.RetrofitUtil;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
        findViewById(R.id.btn_3).setOnClickListener(this);
        findViewById(R.id.btn_4).setOnClickListener(this);
        findViewById(R.id.btn_5).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1:
                API api = RetrofitUtil.create(API.class, "auth");
                Call<User> call = api.getUser("meijieman");
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(Call<User> call, Response<User> response) {
                        User user = response.body();
                        okhttp3.Response raw = response.raw();
                        if (user != null) {
                            Log.e(TAG, "onResponse: user " + user.toString());
                        } else {
                            ResponseBody body = response.errorBody();
                            if (body != null) {
                                try {
                                    String string = body.string();
                                    Log.e(TAG, "onResponse: User is null " + string);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            } else {
                                Log.e(TAG, "onResponse: errorBody is null");
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Log.e(TAG, "onFailure: failure " + t.getMessage());
                    }
                });
                break;
            case R.id.btn_2:

                break;
            case R.id.btn_3:

                break;
            case R.id.btn_4:

                break;
            case R.id.btn_5:

                break;
        }
    }
}
