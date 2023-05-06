package com.example.tffifinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.tffifinder.databinding.ActivityDashboardBinding;

public class Dashboard extends DrawerNav {

    ActivityDashboardBinding activityDashboardBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = ActivityDashboardBinding.inflate(getLayoutInflater());
        setContentView(activityDashboardBinding.getRoot());

        allocateActivityTitle("Dashboard");

        activityDashboardBinding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this, AddPet.class);
                startActivity(intent);
            }
        });

        LinearLayout linearLayout = findViewById(R.id.acc_button);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, PetInfo.class);
                startActivity(intent);
            }
        });
    }
}