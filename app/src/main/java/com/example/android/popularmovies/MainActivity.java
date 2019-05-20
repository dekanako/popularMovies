package com.example.android.popularmovies;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;
import android.util.Log;

import com.example.android.popularmovies.Util.JsonUtil;
import com.example.android.popularmovies.Util.NetworkingUtil;

public class MainActivity extends AppCompatActivity
{
    String x = "{\n" +
            "    \"page\": 1,\n" +
            "    \"total_results\": 19839,\n" +
            "    \"total_pages\": 992,\n" +
            "    \"results\": [\n" +
            "        {\n" +
            "            \"vote_count\": 5549,\n" +
            "            \"id\": 299534,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 8.5,\n" +
            "            \"title\": \"Avengers: Endgame\",\n" +
            "            \"popularity\": 368.982,\n" +
            "            \"poster_path\": \"/or06FN3Dka5tukK1e9sl16pB3iy.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Avengers: Endgame\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                878,\n" +
            "                28\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/7RyHsO4yDXtBv1zUU3mTpHeQ0d5.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"After the devastating events of Avengers: Infinity War, the universe is in ruins due to the efforts of the Mad Titan, Thanos. With the help of remaining allies, the Avengers must assemble once more in order to undo Thanos' actions and restore order to the universe once and for all, no matter what consequences may be in store.\",\n" +
            "            \"release_date\": \"2019-04-24\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 177,\n" +
            "            \"id\": 458156,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.7,\n" +
            "            \"title\": \"John Wick: Chapter 3 – Parabellum\",\n" +
            "            \"popularity\": 331.398,\n" +
            "            \"poster_path\": \"/ziEuG1essDuWuC5lpWUaw1uXY2O.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"John Wick: Chapter 3 – Parabellum\",\n" +
            "            \"genre_ids\": [\n" +
            "                80,\n" +
            "                28,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/kcga7xuiQVqM9WHfWnAbidxU7hd.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"In this third installment of the adrenaline-fueled action franchise, super-assassin John Wick returns with a $14 million price tag on his head and an army of bounty-hunting killers on his trail. After killing a member of the shadowy international assassin’s guild, the High Table, John Wick is excommunicado, but the world’s most ruthless hit men and women await his every turn.\",\n" +
            "            \"release_date\": \"2019-05-15\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 616,\n" +
            "            \"id\": 447404,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7,\n" +
            "            \"title\": \"Pokémon Detective Pikachu\",\n" +
            "            \"popularity\": 295.964,\n" +
            "            \"poster_path\": \"/wgQ7APnFpf1TuviKHXeEe3KnsTV.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Pokémon Detective Pikachu\",\n" +
            "            \"genre_ids\": [\n" +
            "                9648,\n" +
            "                10751,\n" +
            "                35,\n" +
            "                878,\n" +
            "                28,\n" +
            "                12,\n" +
            "                16\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/nDP33LmQwNsnPv29GQazz59HjJI.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"In a world where people collect pocket-size monsters (Pokémon) to do battle, a boy comes across an intelligent monster who seeks to be a detective.\",\n" +
            "            \"release_date\": \"2019-05-03\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 13,\n" +
            "            \"id\": 280960,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.2,\n" +
            "            \"title\": \"Catarina and the others\",\n" +
            "            \"popularity\": 182.687,\n" +
            "            \"poster_path\": \"/kZMCbp0o46Tsg43omSHNHJKNTx9.jpg\",\n" +
            "            \"original_language\": \"pt\",\n" +
            "            \"original_title\": \"Catarina e os Outros\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                9648\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/9nDiMhvL3FtaWMsvvvzQIuq276X.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Outside, the first sun rays break the dawn.  Sixteen years old Catarina can't fall asleep.  Inconsequently, in the big city adults are moved by desire...  Catarina found she is HIV positive. She wants to drag everyone else along.\",\n" +
            "            \"release_date\": \"2011-03-01\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 16,\n" +
            "            \"id\": 543103,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.3,\n" +
            "            \"title\": \"Kamen Rider Heisei Generations FOREVER\",\n" +
            "            \"popularity\": 173.925,\n" +
            "            \"poster_path\": \"/6sOFQDlkY6El1B2P5gklzJfVdsT.jpg\",\n" +
            "            \"original_language\": \"ja\",\n" +
            "            \"original_title\": \"仮面ライダー平成ジェネレーションズFOREVER\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/uufTqD2CSn1NqL3cXEl4Vp3bCav.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"In the world of Sougo Tokiwa and Sento Kiryu, their \\\"companions\\\" are losing their memories one after the other as they're replaced by other people. The Super Time Jacker, Tid , appears before them. He orders his powerful underlings, Another Double and Another Den-O, to pursue a young boy called Shingo. While fighting to protect Shingo, Sougo meets Ataru, a young man who loves Riders, but Ataru says that Kamen Riders aren't real. What is the meaning of those words? While the mystery deepens, the true enemy that Sougo and Sento must defeat appears in the Kuriogatake mountain...\",\n" +
            "            \"release_date\": \"2018-12-22\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 4895,\n" +
            "            \"id\": 299537,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.1,\n" +
            "            \"title\": \"Captain Marvel\",\n" +
            "            \"popularity\": 172.333,\n" +
            "            \"poster_path\": \"/AtsgWhDnHTq68L0lLsUrCnM7TjG.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Captain Marvel\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/w2PMyoyLU22YvrGK3smVM9fW1jj.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"The story follows Carol Danvers as she becomes one of the universe’s most powerful heroes when Earth is caught in the middle of a galactic war between two alien races. Set in the 1990s, Captain Marvel is an all-new adventure from a previously unseen period in the history of the Marvel Cinematic Universe.\",\n" +
            "            \"release_date\": \"2019-03-06\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 23,\n" +
            "            \"id\": 576393,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.7,\n" +
            "            \"title\": \"Fall in Love at First Kiss\",\n" +
            "            \"popularity\": 156.227,\n" +
            "            \"poster_path\": \"/wtaSH8MfJSCEIrrEX9SQuHdU5sl.jpg\",\n" +
            "            \"original_language\": \"zh\",\n" +
            "            \"original_title\": \"一吻定情\",\n" +
            "            \"genre_ids\": [\n" +
            "                10749,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/yY7kr7Rgvo8W0Kr3U0bMV8Zq1qM.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"After an earthquake destroys Xiang Qin's house, she and her father move in with the family of her father's college buddy. To her surprise, her new kind and amicable aunt and uncle are the parents of her cold and distant schoolmate, Jiang Zhi Shu, a genius with an IQ of 200 whom not too long ago rejected her when she confessed her feelings for him. Will the close proximity give her a second chance to win Zhi Shu's heart? Or will her love for him end under his cold words?\",\n" +
            "            \"release_date\": \"2019-02-14\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 1603,\n" +
            "            \"id\": 287947,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.1,\n" +
            "            \"title\": \"Shazam!\",\n" +
            "            \"popularity\": 151.588,\n" +
            "            \"poster_path\": \"/xnopI5Xtky18MPhK40cZAGAOVeV.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Shazam!\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                35,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/bi4jh0Kt0uuZGsGJoUUfqmbrjQg.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A boy is given the ability to become an adult superhero in times of need with a single magic word.\",\n" +
            "            \"release_date\": \"2019-03-23\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 67,\n" +
            "            \"id\": 449562,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.1,\n" +
            "            \"title\": \"The Hustle\",\n" +
            "            \"popularity\": 150.27,\n" +
            "            \"poster_path\": \"/qibqW5Dnvqp4hcEnoTARbQgxwJy.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"The Hustle\",\n" +
            "            \"genre_ids\": [\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/s6awXOxTKYQLSktiIJfI3969dZH.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Two female scam artists, one low rent and the other high class, compete to swindle a naïve tech prodigy out of his fortune. A remake of the 1988 comedy \\\"Dirty Rotten Scoundrels.\\\"\",\n" +
            "            \"release_date\": \"2019-05-09\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 12,\n" +
            "            \"id\": 531309,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.3,\n" +
            "            \"title\": \"Brightburn\",\n" +
            "            \"popularity\": 135.881,\n" +
            "            \"poster_path\": \"/roslEbKdY0WSgYaB5KXvPKY0bXS.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Brightburn\",\n" +
            "            \"genre_ids\": [\n" +
            "                27,\n" +
            "                878,\n" +
            "                18,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/uHEI6v8ApQusjbaRZ8o7WcLYeWb.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A child from another world crash-lands on Earth, but instead of becoming a hero to mankind, he is an evil little boy.\",\n" +
            "            \"release_date\": \"2019-05-10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 9678,\n" +
            "            \"id\": 245891,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.2,\n" +
            "            \"title\": \"John Wick\",\n" +
            "            \"popularity\": 129.89,\n" +
            "            \"poster_path\": \"/b9uYMMbm87IBFOq59pppvkkkgNg.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"John Wick\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                53\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/mFb0ygcue4ITixDkdr7wm1Tdarx.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Ex-hitman John Wick comes out of retirement to track down the gangsters that took everything from him.\",\n" +
            "            \"release_date\": \"2014-10-22\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 1809,\n" +
            "            \"id\": 166428,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 7.6,\n" +
            "            \"title\": \"How to Train Your Dragon: The Hidden World\",\n" +
            "            \"popularity\": 125.252,\n" +
            "            \"poster_path\": \"/xvx4Yhf0DVH8G4LzNISpMfFBDy2.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"How to Train Your Dragon: The Hidden World\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                10751,\n" +
            "                12\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/lFwykSz3Ykj1Q3JXJURnGUTNf1o.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"As Hiccup fulfills his dream of creating a peaceful dragon utopia, Toothless’ discovery of an untamed, elusive mate draws the Night Fury away. When danger mounts at home and Hiccup’s reign as village chief is tested, both dragon and rider must make impossible decisions to save their kind.\",\n" +
            "            \"release_date\": \"2019-01-03\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 534,\n" +
            "            \"id\": 438650,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.3,\n" +
            "            \"title\": \"Cold Pursuit\",\n" +
            "            \"popularity\": 124.491,\n" +
            "            \"poster_path\": \"/otK0H9H1w3JVGJjad5Kzx3Z9kt2.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Cold Pursuit\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                18,\n" +
            "                53,\n" +
            "                80\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/aiM3XxYE2JvW1vJ4AC6cI1RjAoT.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Nels Coxman, a snowplow driver recently awarded the title of citizen of the year, triggers a series of violence and misunderstandings between two rival gangs after he starts avenging his son's death.\",\n" +
            "            \"release_date\": \"2019-02-07\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 388,\n" +
            "            \"id\": 456740,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5,\n" +
            "            \"title\": \"Hellboy\",\n" +
            "            \"popularity\": 118.947,\n" +
            "            \"poster_path\": \"/bk8LyaMqUtaQ9hUShuvFznQYQKR.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Hellboy\",\n" +
            "            \"genre_ids\": [\n" +
            "                28,\n" +
            "                12,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/5BkSkNtfrnTuKOtTaZhl8avn4wU.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Hellboy comes to England, where he must defeat Nimue, Merlin's consort and the Blood Queen. But their battle will bring about the end of the world, a fate he desperately tries to turn away.\",\n" +
            "            \"release_date\": \"2019-04-10\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 2849,\n" +
            "            \"id\": 450465,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.5,\n" +
            "            \"title\": \"Glass\",\n" +
            "            \"popularity\": 115.058,\n" +
            "            \"poster_path\": \"/svIDTNUoajS8dLEo7EosxvyAsgJ.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Glass\",\n" +
            "            \"genre_ids\": [\n" +
            "                53,\n" +
            "                9648,\n" +
            "                18,\n" +
            "                14,\n" +
            "                878\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/lvjscO8wmpEbIfOEZi92Je8Ktlg.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"In a series of escalating encounters, security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.\",\n" +
            "            \"release_date\": \"2019-01-16\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 531,\n" +
            "            \"id\": 157433,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.9,\n" +
            "            \"title\": \"Pet Sematary\",\n" +
            "            \"popularity\": 113.053,\n" +
            "            \"poster_path\": \"/7SPhr7Qj39vbnfF9O2qHRYaKHAL.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Pet Sematary\",\n" +
            "            \"genre_ids\": [\n" +
            "                53,\n" +
            "                9648,\n" +
            "                27\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/n2aX63BmW7zIKgKJ58e6rKlSsdi.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Louis Creed, his wife Rachel and their two children Gage and Ellie move to a rural home where they are welcomed and enlightened about the eerie 'Pet Sematary' located nearby. After the tragedy of their cat being killed by a truck, Louis resorts to burying it in the mysterious pet cemetery, which is definitely not as it seems, as it proves to the Creeds that sometimes dead is better.\",\n" +
            "            \"release_date\": \"2019-04-04\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 917,\n" +
            "            \"id\": 537915,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6,\n" +
            "            \"title\": \"After\",\n" +
            "            \"popularity\": 107.379,\n" +
            "            \"poster_path\": \"/u3B2YKUjWABcxXZ6Nm9h10hLUbh.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"After\",\n" +
            "            \"genre_ids\": [\n" +
            "                18,\n" +
            "                10749\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/997ToEZvF2Obp9zNZbY5ELVnmrW.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"A young woman falls for a guy with a dark secret and the two embark on a rocky relationship.\",\n" +
            "            \"release_date\": \"2019-04-11\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 13562,\n" +
            "            \"id\": 299536,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 8.3,\n" +
            "            \"title\": \"Avengers: Infinity War\",\n" +
            "            \"popularity\": 105.578,\n" +
            "            \"poster_path\": \"/7WsyChQLEftFiDOVTGkv3hFpyyt.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Avengers: Infinity War\",\n" +
            "            \"genre_ids\": [\n" +
            "                12,\n" +
            "                28,\n" +
            "                14\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/bOGkgRGdhrBYJSLpXaxhXVstddV.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.\",\n" +
            "            \"release_date\": \"2018-04-25\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 6,\n" +
            "            \"id\": 566555,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 5.6,\n" +
            "            \"title\": \"Detective Conan: The Fist of Blue Sapphire\",\n" +
            "            \"popularity\": 95.21,\n" +
            "            \"poster_path\": \"/1GyvpwvgswOrHvxjnw2FBLNkTyo.jpg\",\n" +
            "            \"original_language\": \"ja\",\n" +
            "            \"original_title\": \"名探偵コナン 紺青の拳（フィスト）\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                28,\n" +
            "                18,\n" +
            "                9648,\n" +
            "                35\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/wf6VDSi4aFCZfuD8sX8JAKLfJ5m.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"23rd Detective Conan Movie.\",\n" +
            "            \"release_date\": \"2019-04-12\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"vote_count\": 7412,\n" +
            "            \"id\": 920,\n" +
            "            \"video\": false,\n" +
            "            \"vote_average\": 6.7,\n" +
            "            \"title\": \"Cars\",\n" +
            "            \"popularity\": 93.558,\n" +
            "            \"poster_path\": \"/5damnMcRFKSjhCirgX3CMa88MBj.jpg\",\n" +
            "            \"original_language\": \"en\",\n" +
            "            \"original_title\": \"Cars\",\n" +
            "            \"genre_ids\": [\n" +
            "                16,\n" +
            "                12,\n" +
            "                35,\n" +
            "                10751\n" +
            "            ],\n" +
            "            \"backdrop_path\": \"/a1MlbLBk5Sy6YvMbSuKfwGlDVlb.jpg\",\n" +
            "            \"adult\": false,\n" +
            "            \"overview\": \"Lightning McQueen, a hotshot rookie race car driven to succeed, discovers that life is about the journey, not the finish line, when he finds himself unexpectedly detoured in the sleepy Route 66 town of Radiator Springs. On route across the country to the big Piston Cup Championship in California to compete against two seasoned pros, McQueen gets to know the town's offbeat characters.\",\n" +
            "            \"release_date\": \"2006-06-08\"\n" +
            "        }\n" +
            "    ]\n" +
            "} ";
    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;
    private static final String TAG = MainActivity.class.getName();
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycle_view_id);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);



        movieAdapter = new MovieAdapter(JsonUtil.extractMovieList(x),this);
        recyclerView.setAdapter(movieAdapter);

        Log.d(TAG, JsonUtil.extractMovieList(x).get(0).toString()+"");

    }

}
