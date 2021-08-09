package com.wndeld777.library.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wndeld777.library.config.Naver;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {


    // 1. OpenAPI 와 연결할 Connection 객체를 생성하고
    private static Retrofit getInstance(){

        // Retrofit 으로 Open API 로 데이터를 가져오면
        // 자동 parsing 을 도와줄 객체
        Gson gson = new GsonBuilder().setLenient().create();

        // Naver.NAVER_BOOK_URL 과 연결하는
        // HTTP Connection 을 하나 설정하고 객체를 만들어라
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Naver.NAVER_BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();

        return retrofit;
    }

    // 2. 미리 만들어둔 NaverRetrofitService interface 와 연동하여
    // 데이터를 parsing 하는 코드를 생성하여 return
    public static NaverRetrofitService getClient(){
        return getInstance().create(NaverRetrofitService.class);
    }
}
