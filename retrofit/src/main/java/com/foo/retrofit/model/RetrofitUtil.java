package com.foo.retrofit.model;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/9/25 9:48
 */

public class RetrofitUtil {

    public static final String BASE_URL = "https://api.github.com";

    private static OkHttpClient.Builder sBuilder = new OkHttpClient.Builder();

    private static Retrofit.Builder sRetrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

    public static <S> S create(Class<S> serviceClass){
        return create(serviceClass, null);
    }

    public static <S> S create(Class<S> serviceClass, final String authToken) {
        if (authToken != null) {
            sBuilder.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    Request.Builder builder = request.newBuilder()
                                                     .header("Authorization", authToken)
                                                     .method(request.method(), request.body());

                    Request build = builder.build();
                    return chain.proceed(build);
                }
            });
        }

        OkHttpClient client = sBuilder.build();
        Retrofit retrofit = sRetrofit.client(client).build();

        return retrofit.create(serviceClass);
    }
}
