package com.wndeld777.library.service;

import com.wndeld777.library.config.NaverAPI;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Retrofit 을 사용하여 다른 network(server)에 접속하기 위한
 * 기본 설정 객체를 만들어서 배포하는 클래스
 */
public class RetrofitAPIClient {

    /**
     * 필요한 곳에 Retrofit 접속을 위한 객체를
     * 보내는 method
     *
     * getConnection()  method 를 호출하여
     * Connection instance 를 가져오고
     * instance 의 create() method 를 사용하여
     * RetrofitAPIClient interface 를 구현한
     * 코드를 생성한다
     * @return
     */
    public static NaverRetrofit getApiClient(){

        NaverRetrofit naverRetrofit = getConnection().create(NaverRetrofit.class);

        return naverRetrofit;
    }

    /**
     * 접속 설정을 수행하고
     * 접속을 가능하게 하는 Connection instance 를 만드는 method
     */
    private static Retrofit getConnection(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NaverAPI.NAVER_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;

    }
}
