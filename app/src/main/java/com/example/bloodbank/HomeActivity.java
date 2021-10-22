package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    ImageView my_profile_IV,request_IV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        my_profile_IV = findViewById(R.id.my_profile_IV);
        request_IV = findViewById(R.id.request_IV);


        my_profile_IV.setOnClickListener(v->{

            startProfileActivity();

        });

        request_IV.setOnClickListener(v->{

            startRequestActivity();
        });


    }

    private void startRequestActivity() {
        startActivity(new Intent(getApplicationContext(),RequestActivity.class));
    }

    private void startProfileActivity() {
        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
    }
}