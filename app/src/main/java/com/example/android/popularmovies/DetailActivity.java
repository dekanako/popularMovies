package com.example.android.popularmovies;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.popularmovies.Model.Movie;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getName();
    private Movie mMovie;

    private ImageView mBackgroundImage;
    private TextView mMovieTitleView;
    private TextView mDate;
    private TextView mRate;
    private TextView mOverView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        //initializing the views
        mBackgroundImage = findViewById(R.id.background_image_id);
        mMovieTitleView = findViewById(R.id.movie_title_id);
        mRate = findViewById(R.id.rateing_id);
        mDate = findViewById(R.id.date_id);
        mOverView = findViewById(R.id.overview_id);

        //check if there is a passed intent
        if (getIntent().hasExtra(Intent.EXTRA_INTENT))
        {
            mMovie = getIntent().getParcelableExtra(Intent.EXTRA_INTENT);
            Log.d(TAG,mMovie.toString());
            Glide.with(this).load("http://image.tmdb.org/t/p/" + "w1280/"+mMovie.getCoverImage()).into(mBackgroundImage);
            mMovieTitleView.setText(mMovie.getFilmTitle());
            mOverView.setText(mMovie.getOverView());
            mDate.setText(mMovie.getDate());
            mRate.setText(String.valueOf(mMovie.getRating()));
            //appending /10 to the String to make it looks like 8/10 etc
            mRate.append("/10");
            System.out.println("TESTTT" + mMovie.getOverView());
        }
    }
}
