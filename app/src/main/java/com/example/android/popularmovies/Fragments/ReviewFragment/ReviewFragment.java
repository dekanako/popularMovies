package com.example.android.popularmovies.Fragments.ReviewFragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.popularmovies.Model.Review;
import com.example.android.popularmovies.R;
import com.example.android.popularmovies.Util.JsonUtil;
import com.example.android.popularmovies.Util.NetworkingUtil;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ReviewFragment extends Fragment
{

    private static final String MOVIE_REVIEW_BUNDLE_KEY = "movie_review_bundle";
    private int mMovieID;
    private RecyclerView mRecyclerView;
    private ReviewAdapter mReviewAdapter;
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
        View  view = inflater.inflate(R.layout.review_fragment,container,false);
        mRecyclerView = view.findViewById(R.id.reviews_recycler_view_id);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
    private class ReviewsAsyncTask extends AsyncTask<Integer,Void, List<Review>>
    {

        @Override
        protected List<Review> doInBackground(Integer... integers)
        {
            URL url = NetworkingUtil.buildReviewURL(integers[0]);
            String jsonOutput = null;
            try
            {
                jsonOutput = NetworkingUtil.getResponseFromHttpUrlUsingScanner(url);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return JsonUtil.extractMovieReviews(jsonOutput);
        }

        @Override
        protected void onPostExecute(List<Review> reviews)
        {
            mReviewAdapter = new ReviewAdapter(reviews);
            mRecyclerView.setAdapter(mReviewAdapter);
        }
    }
}
