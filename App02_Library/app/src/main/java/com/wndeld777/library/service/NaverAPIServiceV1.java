package com.wndeld777.library.service;

import com.wndeld777.library.config.Naver;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;

public class NaverAPIServiceV1 {

    public void getNaverBooks(String search) throws Exception {

        if(search == null){
            search = "자바";
        }

        // 검색어 문자열을 UTF-8 로 encoding 하기
        String encSearch = URLEncoder.encode(search,"UTF-8");

        // Naver Open API 에 요청할 queryString 만들기
        String queryString = Naver.NAVER_BOOK_URL;
        queryString += "?query=%s";
        queryString += "&display=%d";
        queryString += "&start=%d";

        queryString = String.format(queryString,encSearch,10,1);

        // Network 코딩

        // 생성한 queryString 이용하여 Naver 에 요청하기 위한 시작
        URI apiURI = new URI(queryString);



    }

}
