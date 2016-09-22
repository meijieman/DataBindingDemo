package com.hongfans.restfuldemo.api;

import com.hongfans.restfuldemo.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2016/9/22.
 */
public interface GitHubService {

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);
}
