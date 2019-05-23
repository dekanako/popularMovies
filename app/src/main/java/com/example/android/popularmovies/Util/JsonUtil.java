package com.example.android.popularmovies.Util;

import android.util.Log;

import com.example.android.popularmovies.Model.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtil
{
    private static final String ID = "id";
    private static final String RATE = "vote_average";
    private static final String TITLE = "title";
    private static final String POSTER_PATH = "poster_path";
    private static final String OVERVIEW = "overview";
    private static final String BACKGROUND_IMAGE = "backdrop_path";
    private static final String RELEASE_DATE = "release_date";

    private static final String TAG = JsonUtil.class.getName();
    public static  List<Movie> extractMovieList(String json)
    {
        Log.d(TAG,json);
        List<Movie> movie = new ArrayList<>();
        try {
            JSONObject baseJsonObject = new JSONObject(json);
            JSONArray array = baseJsonObject.getJSONArray("results");

            for (int x = 0;x<array.length();x++)
            {
                JSONObject jsonObject = array.getJSONObject(x);
                int movieIDExtracted = jsonObject.getInt(ID);

                double movieRateExtracted = jsonObject.getDouble(RATE);

                String movieTitleExtracted = jsonObject.getString(TITLE);

                String posterPathExtracted = jsonObject.getString(POSTER_PATH);

                String overView = jsonObject.getString(OVERVIEW);

                String coverImage = jsonObject.getString(BACKGROUND_IMAGE);

                String date = jsonObject.getString(RELEASE_DATE);

                movie.add(new Movie(posterPathExtracted,movieTitleExtracted,movieRateExtracted,movieIDExtracted,coverImage,overView,date));
            }
        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }
        Log.d(TAG,"SIZE IS"+movie.size());
        return movie;
    }
}
