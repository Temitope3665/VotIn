package com.example.votin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;


public class PeopleYouMayKnow extends Fragment {


    private static final String TAG = "PeopleYouMayKnow";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.people_you_may_know, container, false);
        return view;
    }
}
