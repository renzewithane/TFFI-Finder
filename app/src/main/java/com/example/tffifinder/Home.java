package com.example.tffifinder;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LinearLayout linearLayout = findViewById(R.id.acc_button);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this, PetInfo.class);
                startActivity(intent);
            }
        });

        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigationView);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.white));

        navigationView.setCheckedItem(R.id.nav_dashboard);

        navigationView.setNavigationItemSelectedListener(item -> {

            switch (item.getItemId()){

                case R.id.nav_dashboard:
                    drawerLayout.closeDrawer(GravityCompat.START);

                    break;

                case R.id.nav_credits:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(new Intent(Home.this, Credits.class));
                    break;

                case R.id.nav_about:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    startActivity(new Intent(Home.this, About.class));
                    break;

                case R.id.nav_trash:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "Trash", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.nav_settings:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "Settings", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.nav_feeder:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "Feeder", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.nav_logout:
                    drawerLayout.closeDrawer(GravityCompat.START);
                    Toast.makeText(Home.this, "Logout", Toast.LENGTH_SHORT).show();
                    break;
            }
            return true;
        });

    }
}