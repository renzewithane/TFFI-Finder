package com.example.tffifinder;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class PetInfo extends AppCompatActivity {

    Button petlocate;
    Button petcollar;

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

        //Notify if the pet is out of range
        petlocate = findViewById(R.id.pet_locate);
        //Notify if the collar is removed
        petcollar = findViewById(R.id.pet_collar);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("My Notification", "My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);

        }

        petlocate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //notification code goes here
                NotificationCompat.Builder builder = new NotificationCompat.Builder(PetInfo.this, "My Notification");
                builder.setContentTitle("Feed and Find");
                builder.setContentText("Your pet is out of range! Open the app to locate your pet");
                builder.setSmallIcon(R.drawable.tffi_logo);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(PetInfo.this);
                if (ActivityCompat.checkSelfPermission(PetInfo.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                managerCompat.notify(1, builder.build());

            }
        });

        petcollar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //notification code goes here
                NotificationCompat.Builder builder = new NotificationCompat.Builder(PetInfo.this, "My Notification");
                builder.setContentTitle("Feed and Find");
                builder.setContentText("Collar has been removed! Open the app to the collar");
                builder.setSmallIcon(R.drawable.tffi_logo);
                builder.setAutoCancel(true);
                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(PetInfo.this);
                if (ActivityCompat.checkSelfPermission(PetInfo.this, android.Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                managerCompat.notify(1, builder.build());

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