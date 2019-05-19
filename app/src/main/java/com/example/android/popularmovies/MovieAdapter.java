package com.example.android.popularmovies;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.android.popularmovies.Model.Movie;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder>
{
    private List<Movie> mMovies;
    private Context mContext;

    public MovieAdapter(List<Movie> movies,Context context)
    {
        this.mMovies = movies;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);

        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position)
    {
        holder.bindTo(position);
    }

    @Override
    public int getItemCount() {
        return mMovies.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder
    {
        private TextView mMovieTitleView;
        private ImageView mPosterView;
        private RatingBar mRatingBarView;
        public MovieViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mMovieTitleView = itemView.findViewById(R.id.movie_title_id);
            mPosterView = itemView.findViewById(R.id.poster_view_id);
            mRatingBarView = itemView.findViewById(R.id.rateing_bar_id);
        }
        public void bindTo(int position)
        {
            mMovieTitleView.setText(mMovies.get(position).getFilmTitle());
            mRatingBarView.setRating(mMovies.get(position).getRating()/2);
//            Glide.with(mContext).load()
        }
    }
}
