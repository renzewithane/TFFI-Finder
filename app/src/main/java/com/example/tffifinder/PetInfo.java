package com.example.tffifinder;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class PetInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_info);

        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        // Set the custom back arrow as the navigation icon
        myToolbar.setNavigationIcon(R.drawable.ic_arrow_back);

        // Set a click listener on the navigation icon
        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void setSupportActionBar(Toolbar myToolbar) {
    }

    public void buttonClick(View view) {
        Intent intent = new Intent(this, EditInfo.class);
        startActivity(intent);
    }
}