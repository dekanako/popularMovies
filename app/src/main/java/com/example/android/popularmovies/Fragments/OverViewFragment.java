package com.example.android.popularmovies.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.popularmovies.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OverViewFragment extends Fragment
{
    private static final String OVERVIEW_BUNDLE_KEY = "overview_bundle_key";
    private String mOverView;
    public static Fragment newInstance(String overview)
    {
        OverViewFragment overViewFragment = new OverViewFragment();
        Bundle args = new Bundle();
        args.putString(OVERVIEW_BUNDLE_KEY,overview);
        overViewFragment.setArguments(args);
        return overViewFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        mOverView = getArguments().getString(OVERVIEW_BUNDLE_KEY);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.over_view_fragment,container,false);
        TextView overViewTextView = view.findViewById(R.id.overview_id4);
        overViewTextView.setText(mOverView);
        return view;
    }
}
