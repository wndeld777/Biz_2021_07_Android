package com.wndeld777.movie;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;

import com.wndeld777.movie.model.MovieDTO;
import com.wndeld777.movie.service.NaverMovieService;
import com.wndeld777.movie.service.impl.NaverMovieServiceImplV1;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
//    private TextView item_link;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar main_toolbar =findViewById(R.id.main_app_toolbar);
        setSupportActionBar(main_toolbar);

        recyclerView = findViewById(R.id.movie_list_view);

        NaverMovieService movieService = new NaverMovieServiceImplV1(recyclerView);

        movieService.getMovie("도시");

//        item_link = findViewById(R.id.movie_item_link);
//        item_link.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                MovieDTO movieDTO = new MovieDTO();
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(movieDTO.getLink()));
//                startActivity(intent);
//            }
//        });

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_appbar_menu,menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setQueryHint("영화명 검색");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                NaverMovieService movieService = new NaverMovieServiceImplV1(recyclerView);
                movieService.getMovie(query.trim());
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }
}