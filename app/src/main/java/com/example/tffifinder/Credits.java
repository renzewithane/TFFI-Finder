package com.example.tffifinder;

import android.os.Bundle;

import com.example.tffifinder.databinding.ActivityCreditsBinding;

public class Credits extends DrawerNav {

    ActivityCreditsBinding activityCreditsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityCreditsBinding = ActivityCreditsBinding.inflate(getLayoutInflater());
        setContentView(activityCreditsBinding.getRoot());

        allocateActivityTitle("Credits");

    }
}