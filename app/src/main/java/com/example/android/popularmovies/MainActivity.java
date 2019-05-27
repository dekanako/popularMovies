package com.example.android.popularmovies;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.android.popularmovies.Model.Movie;
import com.example.android.popularmovies.Util.JsonUtil;
import com.example.android.popularmovies.Util.NetworkingUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{

    private RecyclerView mRecyclerView;
    private MovieAdapter mMovieAdapter;
    private List<Movie> mMovies;
    private String mSelectedQuery;
    private TextView mOopsView;
    private ProgressBar mProgressBar;
    private static final String TAG = MainActivity.class.getName();
    private static final String BUNDLE_KEY = "moviesList";

    //is used to indicate if we want to fetch the items or we have it already frome the onSavedInstanceStateBundle
    boolean doWeNeedToQuery = true;

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putParcelableArrayList(BUNDLE_KEY, (ArrayList)mMovies);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doWeNeedToQuery = true;
        mOopsView = findViewById(R.id.ops_id);
        mRecyclerView = findViewById(R.id.recycle_view_id);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
        mProgressBar = findViewById(R.id.progressBar);
        mRecyclerView.setHasFixedSize(true);

        if (savedInstanceState != null)
        {
            if (savedInstanceState.containsKey(BUNDLE_KEY))
            {

                doWeNeedToQuery = false;
                mMovies = savedInstanceState.getParcelableArrayList(BUNDLE_KEY);
                mMovieAdapter = new MovieAdapter(mMovies,this);
                mRecyclerView.setAdapter(mMovieAdapter);
            }
        }
        queryForWhat();


        mRecyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
            {
                int position = parent.getChildAdapterPosition(view); // item position
                int spanCount = 2;
                int spacing = 10;//spacing between views in grid

                if (position >= 0)
                {
                    int column = position % spanCount; // item column

                    outRect.left = spacing - column * spacing / spanCount; // spacing - column * ((1f / spanCount) * spacing)
                    outRect.right = (column + 1) * spacing / spanCount; // (column + 1) * ((1f / spanCount) * spacing)

                    if (position < spanCount)
                    { // top edge
                        outRect.top = spacing;
                    }
                    outRect.bottom = spacing; // item bottom
                }
                else
                {
                    outRect.left = 0;
                    outRect.right = 0;
                    outRect.top = 0;
                    outRect.bottom = 0;
                }
            }
        });
       // mRecyclerView.setAdapter(mMovieAdapter);

    }

    //TODO fix the detail activity overview textView
    //TODO fix the onSaveInstanceState

    private void queryForWhat()
    {
        if (isInternetConnection() && doWeNeedToQuery)
        {
            Log.d(TAG,"QUERYING");
            if (QueryPrefences.getStoredTypeOfQuery(this).equals(getResources().getString(R.string.popular)))
            {
                new MoviesAsyncTask().execute(NetworkingUtil.buildURLForListOfPopularMovies(1));
            }
            else
            {
                new MoviesAsyncTask().execute(NetworkingUtil.buildURLForListOfTopRatedMovies(1));
            }
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {

        TextView textView = (TextView)view;
        if ( textView.getText().equals(getResources().getString(R.string.popular)))
        {
            QueryBasedOnWhat(R.string.popular);
        }
        else if (textView.getText().equals(getResources().getString(R.string.top_rated)))
        {
            QueryBasedOnWhat(R.string.top_rated);
        }
        doWeNeedToQuery = true;
    }

    private void QueryBasedOnWhat(int p)
    {
        QueryPrefences.setStoredTypeOfQuery(this, getResources().getString(p));
        queryForWhat();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {
       QueryPrefences.getStoredTypeOfQuery(this);
    }

    private class MoviesAsyncTask extends AsyncTask<URL,Void, List<Movie>>
    {
        @Override
        protected void onPreExecute()
        {
            mRecyclerView.setVisibility(View.INVISIBLE);
            mProgressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected List<Movie> doInBackground(URL... urls)
        {
            String jsonOutput = null;

            try
            {
                jsonOutput = NetworkingUtil.getResponseFromHttpUrlUsingScanner(urls[0]);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return JsonUtil.extractMovieList(jsonOutput);
        }

        @Override
        protected void onPostExecute(List<Movie> movies)
        {
            mProgressBar.setVisibility(View.INVISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);
            mMovies = new ArrayList<>();
            mMovies.addAll(movies);
            mMovieAdapter = new MovieAdapter(mMovies,getBaseContext());
            mRecyclerView.setAdapter(mMovieAdapter);

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.main_menu,menu);
        Spinner spinner = (Spinner) menu.findItem(R.id.spinner).getActionView(); // find the spinner
        if (PreferenceManager.getDefaultSharedPreferences(this).contains("QUERY"))
        {
           mSelectedQuery =  QueryPrefences.getStoredTypeOfQuery(this);
        }
        SpinnerAdapter mSpinnerAdapter = ArrayAdapter.createFromResource(this, R.array.query_array, R.layout.spinner_item); //  create the adapter from a StringArray
        spinner.setAdapter(mSpinnerAdapter); // set the adapter
        spinner.setOnItemSelectedListener(this); // (optional) reference to a OnItemSelectedListener, that you can use to perform actions based on user selection

        if (mSelectedQuery.equals(getResources().getString(R.string.popular)))
        {
            spinner.setSelection(0);
        }
        else
        {
            spinner.setSelection(1);
        }

        return true;
    }



    public  boolean isInternetConnection()
    {

        ConnectivityManager connectivityManager =  (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager.getActiveNetworkInfo() == null )
        {

            mRecyclerView.setVisibility(View.INVISIBLE);
            mOopsView.setVisibility(View.VISIBLE);
            return false;
        }
        else
        {
            mOopsView.setVisibility(View.INVISIBLE);
            mRecyclerView.setVisibility(View.VISIBLE);

            return true;
        }

    }
      /*mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
    {
        @Override
        public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
        super.onScrollStateChanged(recyclerView, newState);
    }

        @Override
        public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
        {
            super.onScrolled(recyclerView, dx, dy);
            GridLayoutManager gridLayout =(GridLayoutManager) recyclerView.getLayoutManager();
            if (mMovies != null)
                if (!isLoading)
                {
                    if (gridLayout != null && gridLayout.findLastCompletelyVisibleItemPosition()+1== mMovies.size())
                    {
                        mMovies.add(null);
                        mMovieAdapter.notifyItemInserted(mMovies.size()-1);
                        isLoading = true;
                    }
                }

        }
    });*/
}
