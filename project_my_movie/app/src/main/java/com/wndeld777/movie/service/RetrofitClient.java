package com.wndeld777.movie.service;

import com.wndeld777.movie.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static NaverRetrofit getAPIClient(){

        NaverRetrofit naverRetrofit = getConnection().create(NaverRetrofit.class);

        return naverRetrofit;

    }

    private static Retrofit getConnection(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
