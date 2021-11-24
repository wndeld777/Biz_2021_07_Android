package com.wndeld777.movie.service.impl;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.wndeld777.movie.adapter.MovieViewAdapter;
import com.wndeld777.movie.config.NaverAPI;
import com.wndeld777.movie.model.MovieDTO;
import com.wndeld777.movie.model.NaverParent;
import com.wndeld777.movie.service.NaverMovieService;
import com.wndeld777.movie.service.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NaverMovieServiceImplV1 implements NaverMovieService {

    protected RecyclerView recyclerView;

    public NaverMovieServiceImplV1(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Override
    public MovieDTO getMovie(String search) {

        Call<NaverParent> retrofitReturn = RetrofitClient.getAPIClient()
                .getMovie(NaverAPI.CLIENT_ID,
                        NaverAPI.CLIENT_SECRET,
                        search,
                        1,
                        20);

        retrofitReturn.enqueue(new Callback<NaverParent>() {
            @Override
            public void onResponse(Call<NaverParent> call, Response<NaverParent> response) {

                int resCode = response.code();
                if(resCode < 300 ){
                    NaverParent naverParent = response.body();
                    List<MovieDTO> movieList = naverParent.items;
                    MovieViewAdapter movieViewAdapter = new MovieViewAdapter(movieList);
                    recyclerView.setAdapter(movieViewAdapter);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(recyclerView.getContext());
                    recyclerView.setLayoutManager(layoutManager);
                }else{
                    Log.d("오류",response.toString());
                }
            }

            @Override
            public void onFailure(Call<NaverParent> call, Throwable t) {

            }
        });



        return null;
    }
}
