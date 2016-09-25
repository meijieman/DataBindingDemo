package com.foo.retrofit.api;

import com.foo.retrofit.bean.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/9/25 9:37
 */

public interface API {

    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);
}
