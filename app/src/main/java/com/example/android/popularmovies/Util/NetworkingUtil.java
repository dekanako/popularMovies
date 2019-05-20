package com.example.android.popularmovies.Util;


import android.net.Uri;

import java.net.MalformedURLException;
import java.net.URL;

public class NetworkingUtil
{
    private static final String BASE_MOVIE_URL ="https://api.themoviedb.org/3/movie";
    private static final String API_KEY= "api_key";
    private static final String API_KEY_VALUE = "90429cbb0771760ab50be543df397f62";


    private static final String POPULAR_PATH ="popular";
    private static final String PAGE = "page";


    private static final String LANGUAGE = "language";

    private static final String LANGUAGE_VALUE = "en-US";

   // "https://api.themoviedb.org/3/movie/458156?api_key=90429cbb0771760ab50be543df397f62&language=en-US\n"

    public static URL buildURLForListOfMovies(int page)
    {
        Uri movieUri =Uri.parse(BASE_MOVIE_URL).buildUpon()
                .appendEncodedPath(POPULAR_PATH)
                .appendQueryParameter(API_KEY,API_KEY_VALUE)
                .appendQueryParameter(PAGE,String.valueOf(page))
                .appendQueryParameter(LANGUAGE,LANGUAGE_VALUE)
                .build();
        try {
            return new URL(movieUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static URL buildURLForOneMovie(int movieID)
    {
        Uri movieUri =Uri.parse(BASE_MOVIE_URL).buildUpon()
                .appendEncodedPath(String.valueOf(movieID))
                .appendQueryParameter(API_KEY,API_KEY_VALUE)
                .appendQueryParameter(LANGUAGE,LANGUAGE_VALUE)
                .build();
        try
        {
            return new URL(movieUri.toString());
        } catch
        (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static URL buildPhotoURL(String movieID)
    {
        Uri movieUri =Uri.parse(BASE_MOVIE_URL).buildUpon()
                .appendEncodedPath(String.valueOf(movieID))
                .appendQueryParameter(API_KEY,API_KEY_VALUE)
                .appendQueryParameter(LANGUAGE,LANGUAGE_VALUE)
                .build();
        try
        {
            return new URL(movieUri.toString());
        } catch
        (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }

}
