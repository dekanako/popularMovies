package com.example.android.popularmovies.Room;

import com.example.android.popularmovies.Model.Movie;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface MovieDAO
{
  @Query("SELECT * FROM movie")
  LiveData<List<Movie>>getAllMovie();

  @Insert
  void insertMovie(Movie movie);

}
