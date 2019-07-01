package com.example.android.popularmovies;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.popularmovies.Util.NetworkingUtil;

import java.io.IOException;
import java.net.URL;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ReviewFragment extends Fragment
{
    private TextView mJsonView;
    private static final String MOVIE_REVIEW_BUNDLE_KEY = "movie_review_bundle";
    private int mMovieID;

    public static Fragment newInstance(int movieId)
    {
        Bundle args = new Bundle();
        args.putInt(MOVIE_REVIEW_BUNDLE_KEY,movieId);
        ReviewFragment fragment = new ReviewFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mMovieID = getArguments().getInt(MOVIE_REVIEW_BUNDLE_KEY);
        new ReviewsAsyncTask().execute(mMovieID);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View  view = inflater.inflate(R.layout.dummy_layout_test_two,container,false);
        mJsonView = view.findViewById(R.id.reviews_text_view_json);
        return view;
    }
    private class ReviewsAsyncTask extends AsyncTask<Integer,Void, String>
    {

        @Override
        protected String doInBackground(Integer... integers)
        {
            URL url = NetworkingUtil.buildReviewURL(integers[0]);
            String jsonOutput = null;
            try {
                jsonOutput = NetworkingUtil.getResponseFromHttpUrlUsingScanner(url);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return jsonOutput;
        }

        @Override
        protected void onPostExecute(String s)
        {
            mJsonView.setText(s);
        }
    }
}
