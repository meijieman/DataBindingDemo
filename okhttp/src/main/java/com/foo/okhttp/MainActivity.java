package com.foo.okhttp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG      = "beauty";
    public static final  String URL      = "https://github.com";
    public static final  String URL_POST = "http://www.roundsapp.com/post";

    public static final MediaType JSON = MediaType.parse("application/json;charset=utf=8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_1).setOnClickListener(this);
        findViewById(R.id.btn_2).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_1: {
                final OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(URL).build();

                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        String message = e.getMessage();
                        Log.e(TAG, "onFailure: " + message);
                    }

                    @Override
                    public void onResponse(final Call call, Response response) throws IOException {
                        if (response.code() == 200) {
                            ResponseBody body = response.body();
                            if (body != null) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        try {
                                            boolean executed = call.isExecuted();
                                            if (executed) {
                                                Request request1 = call.request();
                                                Call call1 = client.newCall(request1.newBuilder().build());
                                                Response execute = call1.execute();
                                                Log.w(TAG, "run: " + execute.body().string());
                                            }
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }

                                    }
                                }).start();
                                String str = body.string();
                                Log.w(TAG, "onResponse: " + str);
                            } else {
                                Log.e(TAG, "onResponse: body == null");
                            }
                        } else {
                            Log.e(TAG, "onResponse: code " + response.code());
                        }
                    }
                });
            }

            break;
            case R.id.btn_2: {
                OkHttpClient client = new OkHttpClient();
                RequestBody body = RequestBody.create(JSON, bowlingJson("Jesse", "Jake"));
                Request request = new Request.Builder()
                        .url(URL_POST)
                        .post(body)
                        .build();
                client.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                        Log.e(TAG, "onFailure: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        Log.w(TAG, "onResponse: " + response);
                    }
                });

            }
            break;
        }
    }

    static String bowlingJson(String player1, String player2) {
        return "{'winCondition':'HIGH_SCORE',"
               + "'name':'Bowling',"
               + "'round':4,"
               + "'lastSaved':1367702411696,"
               + "'dateStarted':1367702378785,"
               + "'players':["
               + "{'name':'" + player1 + "','history':[10,8,6,7,8],'color':-13388315,'total':39},"
               + "{'name':'" + player2 + "','history':[6,10,5,10,10],'color':-48060,'total':41}"
               + "]}";
    }
}
