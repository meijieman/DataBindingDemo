package com.hongfans.restfuldemo.model;

import android.util.Log;

import com.hongfans.restfuldemo.api.GitHubService;
import com.hongfans.restfuldemo.bean.User;
import com.hongfans.restfuldemo.vm.MainViewModel;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2016/9/22.
 */
public class GitHubModel {

    private static final String TAG = "GitHubModel";

    private GitHubService mService;
    private MainViewModel mViewModel;

    public GitHubModel(MainViewModel viewModel) {
        mViewModel = viewModel;
        mService = ServiceGenerator.createService(GitHubService.class);
    }

    public void getUser(String username) {
        Call<User> call = mService.getUser(username);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Response<User> response) {
                User model = response.body();
                if (model == null) {
                    //404 or the response cannot be converted to User.
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        try {
                            mViewModel.setText("responseBody = " + responseBody.string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    } else {
                        mViewModel.setText("responseBody = null");
                    }
                } else {
                    // 200
                    mViewModel.setText("Github Name : " + model.getName()
                            + "\nWebsite :" + model.getBlog()
                            + "\nCompany Name :" + model.getCompany());

                    Log.e(TAG, "onResponse: success" + model);
                }
                mViewModel.setPb(false);
            }

            @Override
            public void onFailure(Throwable t) {
                mViewModel.setText("t = " + t.getMessage());
                mViewModel.setPb(false);
            }
        });
    }
}
