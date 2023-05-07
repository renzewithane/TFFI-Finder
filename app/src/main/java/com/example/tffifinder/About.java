package com.example.tffifinder;

import android.os.Bundle;

import com.example.tffifinder.databinding.ActivityAboutBinding;

public class About extends DrawerNav {

    ActivityAboutBinding activityAboutBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityAboutBinding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(activityAboutBinding.getRoot());

        allocateActivityTitle("About");
    }
}