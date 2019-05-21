package com.example.android.popularmovies.Util;

import java.util.StringTokenizer;

public class StringCheck
{
    public static String StrinFixer(String x)
    {
        StringTokenizer tokenizer;
        if (x.length() > "AVENGERS ENDGAME SLAW ".length() || x.contains(":"))
        {
            tokenizer = new StringTokenizer(x,":");
            return tokenizer.nextToken();
        }
        return x;


    }
}
