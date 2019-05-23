package com.example.android.popularmovies.Model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Movie implements Parcelable
{
    private String imageLink;
    private String filmTitle;
    private int rating;
    private int dbMovieId;

    public Movie(String imageLink, String filmTitle, int rating, int DBMoviesMoviID) {
        this.imageLink = imageLink;
        this.filmTitle = filmTitle;
        this.rating = rating;
        this.dbMovieId = DBMoviesMoviID;
    }

    private Movie(Parcel p)
    {

    }

    public int getDbMovieId() {
        return dbMovieId;
    }

    public void setDbMovieId(int dbMovieId) {
        this.dbMovieId = dbMovieId;
    }

    public String getImageLink()
    {
        return imageLink;
    }

    public void setImageLink(String imageLink)
    {
        this.imageLink = imageLink;
    }

    public String getFilmTitle()
    {
        return filmTitle;
    }

    public void setFilmTitle(String filmTitle)
    {
        this.filmTitle = filmTitle;
    }

    public int getRating()
    {
        return rating;
    }
    /**
     * @param rating used to rate with the rating bar and we divide it by 2
     *
    **/
    public void setRating(int rating)
    {
        this.rating = rating;
    }

    @NonNull
    @Override
    public String toString()
    {
        return imageLink + " " + filmTitle + " " + getRating() + " " +dbMovieId;
    }


    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {

    }
}
