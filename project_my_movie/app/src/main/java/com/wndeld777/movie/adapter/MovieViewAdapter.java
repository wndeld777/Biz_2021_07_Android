package com.wndeld777.movie.adapter;

import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.wndeld777.movie.R;
import com.wndeld777.movie.model.MovieDTO;

import java.util.List;

public class MovieViewAdapter extends RecyclerView.Adapter {

    private List<MovieDTO> movieList;

    public MovieViewAdapter(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.movie_item_view,parent,false);
        MovieItemHolder movieItemHolder = new MovieItemHolder(view);
        return movieItemHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        MovieItemHolder movieHolder = (MovieItemHolder) holder;
        MovieDTO movieDTO = movieList.get(position);

        String item_title = movieDTO.getTitle();
        Spanned sp_title = Html.fromHtml(item_title,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_title.setText(sp_title);

        String item_director = movieDTO.getDirector();
        Spanned sp_director = Html.fromHtml(item_director,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_director.setText(sp_director);

        String item_actor = movieDTO.getActor();
        Spanned sp_actor = Html.fromHtml(item_actor,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_actor.setText(sp_actor);

        String item_rating = movieDTO.getUserRating();
        Spanned sp_rating = Html.fromHtml(item_rating,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_rating.setText(sp_rating);

        String item_subtitle = movieDTO.getSubtitle();
        Spanned sp_subtitle = Html.fromHtml(item_subtitle,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_subtitle.setText(sp_subtitle);

        String item_link = movieDTO.getLink();
        Spanned sp_link = Html.fromHtml(item_link,Html.FROM_HTML_MODE_LEGACY);
        movieHolder.item_link.setText(sp_link);

        if(!movieDTO.getImage().isEmpty()){
            Picasso.get().load(movieDTO.getImage()).into(movieHolder.item_image);
        }


    }

    @Override
    public int getItemCount() {
        return movieList == null ? 0 : movieList.size();
    }

    public static class MovieItemHolder extends RecyclerView.ViewHolder{

        public TextView item_title;
        public TextView item_director;
        public TextView item_actor;
        public TextView item_rating;
        public ImageView item_image;
        public TextView item_subtitle;
        public TextView item_link;


        public MovieItemHolder(@NonNull View itemView) {
            super(itemView);

            item_title = itemView.findViewById(R.id.movie_item_title);
            item_director = itemView.findViewById(R.id.movie_item_director);
            item_actor = itemView.findViewById(R.id.movie_item_actor);
            item_rating = itemView.findViewById(R.id.movie_item_rating);
            item_image = itemView.findViewById(R.id.movie_item_image);
            item_subtitle = itemView.findViewById(R.id.movie_item_subtitle);
            item_link = itemView.findViewById(R.id.movie_item_link);
        }
    }

}
