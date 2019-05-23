package com.example.android.popularmovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;

import com.example.android.popularmovies.Model.Movie;
import com.example.android.popularmovies.Util.JsonUtil;
import com.example.android.popularmovies.Util.NetworkingUtil;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity
{
//    String x = "{\"page\":1,\"total_results\":19840,\"total_pages\":992,\"results\":[{\"vote_count\":334,\"id\":458156,\"video\":false,\"vote_average\":7.5,\"title\":\"John Wick: Chapter 3 – Parabellum\",\"popularity\":578.653,\"poster_path\":\"\\/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg\",\"original_language\":\"en\",\"original_title\":\"John Wick: Chapter 3 – Parabellum\",\"genre_ids\":[80,28,53],\"backdrop_path\":\"\\/kcga7xuiQVqM9WHfWnAbidxU7hd.jpg\",\"adult\":false,\"overview\":\"Super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.\",\"release_date\":\"2019-05-15\"},{\"vote_count\":17,\"id\":280960,\"video\":false,\"vote_average\":5.4,\"title\":\"Catarina and the others\",\"popularity\":388.325,\"poster_path\":\"\\/kZMCbp0o46Tsg43omSHNHJKNTx9.jpg\",\"original_language\":\"pt\",\"original_title\":\"Catarina e os Outros\",\"genre_ids\":[18,9648],\"backdrop_path\":\"\\/9nDiMhvL3FtaWMsvvvzQIuq276X.jpg\",\"adult\":false,\"overview\":\"Outside, the first sun rays break the dawn.  Sixteen years old Catarina can't fall asleep.  Inconsequently, in the big city adults are moved by desire...  Catarina found she is HIV positive. She wants to drag everyone else along.\",\"release_date\":\"2011-03-01\"},{\"vote_count\":5802,\"id\":299534,\"video\":false,\"vote_average\":8.5,\"title\":\"Avengers: Endgame\",\"popularity\":314.127,\"poster_path\":\"\\/or06FN3Dka5tukK1e9sl16pB3iy.jpg\",\"original_language\":\"en\",\"original_title\":\"Avengers: Endgame\",\"genre_ids\":[12,878,28],\"backdrop_path\":\"\\/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg\",\"adult\":false,\"overview\":\"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.\",\"release_date\":\"2019-04-24\"},{\"vote_count\":743,\"id\":447404,\"video\":false,\"vote_average\":7,\"title\":\"Pokémon Detective Pikachu\",\"popularity\":215.512,\"poster_path\":\"\\/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg\",\"original_language\":\"en\",\"original_title\":\"Pokémon Detective Pikachu\",\"genre_ids\":[9648,10751,35,878,28,12,16],\"backdrop_path\":\"\\/nDP33LmQwNsnPv29GQazz59HjJI.jpg\",\"adult\":false,\"overview\":\"In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.\",\"release_date\":\"2019-05-03\"},{\"vote_count\":1643,\"id\":287947,\"video\":false,\"vote_average\":7.1,\"title\":\"Shazam!\",\"popularity\":135.697,\"poster_path\":\"\\/xnopI5Xtky18MPhK40cZAGAOVeV.jpg\",\"original_language\":\"en\",\"original_title\":\"Shazam!\",\"genre_ids\":[28,12,35,14],\"backdrop_path\":\"\\/bi4jh0Kt0uuZGsGJoUUfqmbrjQg.jpg\",\"adult\":false,\"overview\":\"A boy is given the ability to become an adult superhero in times of need with a single magic word.\",\"release_date\":\"2019-03-23\"},{\"vote_count\":4948,\"id\":299537,\"video\":false,\"vote_average\":7.1,\"title\":\"Captain Marvel\",\"popularity\":130.619,\"poster_path\":\"\\/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg\",\"original_language\":\"en\",\"original_title\":\"Captain Marvel\",\"genre_ids\":[28,12,878],\"backdrop_path\":\"\\/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg\",\"adult\":false,\"overview\":\"The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.\",\"release_date\":\"2019-03-06\"},{\"vote_count\":1,\"id\":403300,\"video\":false,\"vote_average\":0,\"title\":\"A Hidden Life\",\"popularity\":128.184,\"poster_path\":\"\\/gRgkGpaeoBY6IrHP9FbLrVwdb6F.jpg\",\"original_language\":\"en\",\"original_title\":\"A Hidden Life\",\"genre_ids\":[18,10752],\"backdrop_path\":\"\\/ijXdtIFWjZhmvLH9kuqgchKLD2N.jpg\",\"adult\":false,\"overview\":\"The Austrian Franz Jägerstätter, a conscientious objector, refuses to fight for the Nazis in World War II and is executed by them in 1943. Opening at Jägerstätter’s home in Austria’s countryside, the film follows Franz and his wife, Fani, along their path of resistance. Told through real wartime letters, this love story finds the couple in conflict with the members of their close-knit town, their church, their government, and even their friends — all of which brings them to a dramatic choice.\",\"release_date\":\"2019-05-19\"},{\"vote_count\":49,\"id\":420817,\"video\":false,\"vote_average\":5.6,\"title\":\"Aladdin\",\"popularity\":127.389,\"poster_path\":\"\\/yYWGCAerbVAHyfuGBCHKzWJdEtj.jpg\",\"original_language\":\"en\",\"original_title\":\"Aladdin\",\"genre_ids\":[12,14,10402,10749],\"backdrop_path\":\"\\/v4yVTbbl8dE1UP2dWu5CLyaXOku.jpg\",\"adult\":false,\"overview\":\"Young Aladdin embarks on a magical adventure after finding a lamp that releases a wisecracking genie.\",\"release_date\":\"2019-05-22\"},{\"vote_count\":22,\"id\":531309,\"video\":false,\"vote_average\":5.3,\"title\":\"Brightburn\",\"popularity\":112.313,\"poster_path\":\"\\/roslEbKdY0WSgYaB5KXvPKY0bXS.jpg\",\"original_language\":\"en\",\"original_title\":\"Brightburn\",\"genre_ids\":[27,878,18,53],\"backdrop_path\":\"\\/uHEI6v8ApQusjbaRZ8o7WcLYeWb.jpg\",\"adult\":false,\"overview\":\"A child from another world crash-lands on Earth, but instead of becoming a hero to mankind, he is an evil little boy.\",\"release_date\":\"2019-05-10\"},{\"vote_count\":16,\"id\":543103,\"video\":false,\"vote_average\":5.3,\"title\":\"Kamen Rider Heisei Generations FOREVER\",\"popularity\":111.892,\"poster_path\":\"\\/6sOFQDlkY6El1B2P5gklzJfVdsT.jpg\",\"original_language\":\"ja\",\"original_title\":\"仮面ライダー平成ジェネレーションズFOREVER\",\"genre_ids\":[28,12,878],\"backdrop_path\":\"\\/uufTqD2CSn1NqL3cXEl4Vp3bCav.jpg\",\"adult\":false,\"overview\":\"In the world of Sougo Tokiwa and Sento Kiryu, their \\\"companions\\\" are losing their memories one after the other as they're replaced by other people. The Super Time Jacker, Tid , appears before them. He orders his powerful underlings, Another Double and Another Den-O, to pursue a young boy called Shingo. While fighting to protect Shingo, Sougo meets Ataru, a young man who loves Riders, but Ataru says that Kamen Riders aren't real. What is the meaning of those words? While the mystery deepens, the true enemy that Sougo and Sento must defeat appears in the Kuriogatake mountain...\",\"release_date\":\"2018-12-22\"},{\"vote_count\":9762,\"id\":245891,\"video\":false,\"vote_average\":7.2,\"title\":\"John Wick\",\"popularity\":111.587,\"poster_path\":\"\\/b9uYMMbm87IBFOq59pppvkkkgNg.jpg\",\"original_language\":\"en\",\"original_title\":\"John Wick\",\"genre_ids\":[28,53],\"backdrop_path\":\"\\/mFb0ygcue4ITixDkdr7wm1Tdarx.jpg\",\"adult\":false,\"overview\":\"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\"release_date\":\"2014-10-22\"},{\"vote_count\":0,\"id\":579598,\"video\":false,\"vote_average\":0,\"title\":\"Vaarikkuzhiyile Kolapathakam\",\"popularity\":106.24,\"poster_path\":\"\\/qwDA7qSSQLwQ7JgDmHrflHFyQZf.jpg\",\"original_language\":\"ml\",\"original_title\":\"വാരിക്കുഴിയിലെ കൊലപാതകം\",\"genre_ids\":[],\"backdrop_path\":null,\"adult\":false,\"overview\":\"\",\"release_date\":\"2019-02-22\"},{\"vote_count\":1847,\"id\":166428,\"video\":false,\"vote_average\":7.6,\"title\":\"How to Train Your Dragon: The Hidden World\",\"popularity\":105.535,\"poster_path\":\"\\/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg\",\"original_language\":\"en\",\"original_title\":\"How to Train Your Dragon: The Hidden World\",\"genre_ids\":[16,10751,12],\"backdrop_path\":\"\\/lFwykSz3Ykj1Q3JXJURnGUTNf1o.jpg\",\"adult\":false,\"overview\":\"As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.\",\"release_date\":\"2019-01-03\"},{\"vote_count\":47,\"id\":390634,\"video\":false,\"vote_average\":4.8,\"title\":\"Fate\\/stay night: Heaven’s Feel II. lost butterfly\",\"popularity\":104.188,\"poster_path\":\"\\/4tS0iyKQBDFqVpVcH21MSJwXZdq.jpg\",\"original_language\":\"ja\",\"original_title\":\"劇場版 Fate／stay night [Heaven's Feel] II. lost butterfly\",\"genre_ids\":[16,28,14,12],\"backdrop_path\":\"\\/2zKusjJZd8b2Cdk2C5K9dGFNWiJ.jpg\",\"adult\":false,\"overview\":\"Theatrical-release adaptation of the visual novel \\\"Fate\\/stay night\\\", following the third and final route. (Part 2 of a trilogy.)\",\"release_date\":\"2019-01-12\"},{\"vote_count\":83,\"id\":449562,\"video\":false,\"vote_average\":6.2,\"title\":\"The Hustle\",\"popularity\":102.837,\"poster_path\":\"\\/qibqW5Dnvqp4hcEnoTARbQgxwJy.jpg\",\"original_language\":\"en\",\"original_title\":\"The Hustle\",\"genre_ids\":[35],\"backdrop_path\":\"\\/s6awXOxTKYQLSktiIJfI3969dZH.jpg\",\"adult\":false,\"overview\":\"Two female scam artists, one low rent and the other high class, compete to swindle a naïve tech prodigy out of his fortune. A remake of the 1988 comedy \\\"Dirty Rotten Scoundrels.\\\"\",\"release_date\":\"2019-05-09\"},{\"vote_count\":13628,\"id\":299536,\"video\":false,\"vote_average\":8.3,\"title\":\"Avengers: Infinity War\",\"popularity\":102.818,\"poster_path\":\"\\/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\"original_language\":\"en\",\"original_title\":\"Avengers: Infinity War\",\"genre_ids\":[12,28,14],\"backdrop_path\":\"\\/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg\",\"adult\":false,\"overview\":\"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\",\"release_date\":\"2018-04-25\"},{\"vote_count\":565,\"id\":438650,\"video\":false,\"vote_average\":5.3,\"title\":\"Cold Pursuit\",\"popularity\":92.398,\"poster_path\":\"\\/otK0H9H1w3JVGJjad5Kzx3Z9kt2.jpg\",\"original_language\":\"en\",\"original_title\":\"Cold Pursuit\",\"genre_ids\":[28,18,53,80],\"backdrop_path\":\"\\/aiM3XxYE2JvW1vJ4AC6cI1RjAoT.jpg\",\"adult\":false,\"overview\":\"Nels Coxman, a snowplow driver recently awarded the title of citizen of the year, triggers a series of violence and misunderstandings between two rival gangs after he starts avenging his son's death.\",\"release_date\":\"2019-02-07\"},{\"vote_count\":2903,\"id\":450465,\"video\":false,\"vote_average\":6.5,\"title\":\"Glass\",\"popularity\":87.626,\"poster_path\":\"\\/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg\",\"original_language\":\"en\",\"original_title\":\"Glass\",\"genre_ids\":[53,9648,18],\"backdrop_path\":\"\\/rL1ITQuX0lmSNPu52pRRHUyim5N.jpg\",\"adult\":false,\"overview\":\"In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.\",\"release_date\":\"2019-01-16\"},{\"vote_count\":575,\"id\":157433,\"video\":false,\"vote_average\":5.8,\"title\":\"Pet Sematary\",\"popularity\":84.257,\"poster_path\":\"\\/7SPhr7Qj39vbnfF9O2qHRYaKHAL.jpg\",\"original_language\":\"en\",\"original_title\":\"Pet Sematary\",\"genre_ids\":[53,9648,27],\"backdrop_path\":\"\\/n2aX63BmW7zIKgKJ58e6rKlSsdi.jpg\",\"adult\":false,\"overview\":\"Louis Creed, his wife Rachel and their two children Gage and Ellie move to a rural home where they are welcomed and enlightened about the eerie 'Pet Sematary' located nearby. After the tragedy of their cat being killed by a truck, Louis resorts to burying it in the mysterious pet cemetery, which is definitely not as it seems, as it proves to the Creeds that sometimes dead is better.\",\"release_date\":\"2019-04-04\"},{\"vote_count\":951,\"id\":537915,\"video\":false,\"vote_average\":6,\"title\":\"After\",\"popularity\":83.844,\"poster_path\":\"\\/u3B2YKUjWABcxXZ6Nm9h10hLUbh.jpg\",\"original_language\":\"en\",\"original_title\":\"After\",\"genre_ids\":[18,10749],\"backdrop_path\":\"\\/997ToEZvF2Obp9zNZbY5ELVnmrW.jpg\",\"adult\":false,\"overview\":\"A young woman falls for a guy with a dark secret and the two embark on a rocky relationship.\",\"release_date\":\"2019-04-11\"}]}";
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity(new Intent(this,DetailActivity.class));
        new MoviesAsyncTaske().execute("1");
        movieAdapter = new MovieAdapter(new ArrayList<Movie>(),this);
        recyclerView = findViewById(R.id.recycle_view_id);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() {
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

                    if (position < spanCount) { // top edge
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
        recyclerView.setAdapter(movieAdapter);
    }

    private class MoviesAsyncTaske extends AsyncTask<String,Void, List<Movie>>
    {

        @Override
        protected List<Movie> doInBackground(String... strings)
        {
            String jsonOutput = null;
            URL urlForListOfMoviesNetworkingUtil = NetworkingUtil.buildURLForListOfMovies(Integer.parseInt(strings[0]));
            try
            {
                 jsonOutput = NetworkingUtil.getResponseFromHttpUrlUsingScanner(urlForListOfMoviesNetworkingUtil);
            } catch (IOException e)
            {
                e.printStackTrace();
            }
            return JsonUtil.extractMovieList(jsonOutput);
        }

        @Override
        protected void onPostExecute(List<Movie> movies)
        {
            movieAdapter = new MovieAdapter(movies,getBaseContext());
            recyclerView.setAdapter(movieAdapter);
        }
    }

}
