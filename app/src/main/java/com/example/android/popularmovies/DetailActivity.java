package com.example.android.popularmovies;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.AsyncTaskLoader;
import androidx.loader.content.Loader;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.android.popularmovies.Model.Movie;
import com.example.android.popularmovies.Util.JsonUtil;
import com.example.android.popularmovies.Util.NetworkingUtil;

import java.io.IOException;
import java.net.URL;

public class DetailActivity extends AppCompatActivity
    implements LoaderManager.LoaderCallbacks<String>
{

    private static final String TAG = DetailActivity.class.getName();
    private static final String TRAILER_KEY = "trailer_key";
    private static final int LOADER_ID = 125;
    private Movie mMovie;

    private ImageView mBackgroundImage;
    private TextView mMovieTitleView;
    private TextView mDate;
    private TextView mRate;
    private TextView mOverView;
    private Button playButtonImageView;

    private String trailerURL;
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
        playButtonImageView = findViewById(R.id.trailer_button_id);

        playButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if (mMovie.getTrailersArray().length>0)
                {

                    AlertDialog.Builder builderSingle = new AlertDialog.Builder(v.getContext());
                    builderSingle.setTitle("Trailers");


                    builderSingle.setItems(mMovie.getTrailersNameArray(), new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Uri uri = NetworkingUtil.createYoutubeLink(mMovie.getTrailersArray()[which].getYoutubeTrailerKey());
                            Log.d(TAG,uri.toString());
                            Intent intent = new Intent(Intent.ACTION_VIEW,uri);
                            if (intent.resolveActivity(getPackageManager()) != null)
                            {
                                startActivity(intent);
                            }
                        }
                    });
                    builderSingle.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
                    builderSingle.show();
//
//                    Uri uri = NetworkingUtil.createYoutubeLink(mMovie.getTrailersArray()[0].getYoutubeTrailerKey());
//                    Log.d(TAG,uri.toString());
//                    Intent intent = new Intent(Intent.ACTION_VIEW,uri);
//                    if (intent.resolveActivity(getPackageManager()) != null)
//                    {
//                        startActivity(intent);
//                    }
                }
                else
                {
                    Toast.makeText(getBaseContext(),"This movie doesn't has a trailer",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //check if there is a passed intent
        if (getIntent().hasExtra(Intent.EXTRA_INTENT))
        {

            mMovie = getIntent().getParcelableExtra(Intent.EXTRA_INTENT);
            Bundle args = new Bundle();
            args.putInt(TRAILER_KEY,mMovie.getDbMovieId());
            getSupportLoaderManager().initLoader(LOADER_ID,args,this).forceLoad();

            Glide.with(this).load(NetworkingUtil.buildPhotoURL(mMovie.getCoverImage(),NetworkingUtil.BACKDROP_IMAGE_W1280))
                    .into(mBackgroundImage);

            mMovieTitleView.setText(mMovie.getFilmTitle());
            mOverView.setText(mMovie.getOverView());
            mDate.setText(mMovie.getDate());
            mRate.setText(String.valueOf(mMovie.getRating()));



            //appending /10 to the String to make it looks like 8/10 etc
            mRate.append("/10");
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.detail_activity_menu,menu);
        return true;
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args)
    {
        int movieId = 0;

        if (args.containsKey(TRAILER_KEY))
        {

            movieId = args.getInt(TRAILER_KEY);
        }
        final int finalMovieId = movieId;
        return new AsyncTaskLoader<String>(this)
        {
            @Nullable
            @Override
            public String loadInBackground()
            {   String output = null;

                URL url = NetworkingUtil.buildURLForOneMovie(finalMovieId);
                try
                {
                   output = NetworkingUtil.getResponseFromHttpUrlUsingScanner(url);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
                return output;
            }
        };
    }

    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data)
    {
        JsonUtil.extractTrailerPathAndAddTheTrailersToTheMovieObject(data,mMovie);
        playButtonImageView.setClickable(true);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader)
    {

    }
}
