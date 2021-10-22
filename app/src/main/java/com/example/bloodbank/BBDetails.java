package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class BBDetails extends AppCompatActivity {

    TextView bb_name_TV,bb_mobile_TV,bb_description_TV,bb_location_TV;
    ImageView bb_call_now_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bbdetails);


        bb_name_TV = findViewById(R.id.bb_name_TV);
        bb_mobile_TV = findViewById(R.id.bb_mobile_TV);
        bb_description_TV = findViewById(R.id.bb_description_TV);
        bb_location_TV = findViewById(R.id.bb_location_TV);


        bb_call_now_btn = findViewById(R.id.bb_call_now_btn);


        String Name = getIntent().getStringExtra("Name");
        String AddedBy = getIntent().getStringExtra("AddedBy");
        String Description = getIntent().getStringExtra("Description");
        String Mobile = getIntent().getStringExtra("Mobile");
        String Location = getIntent().getStringExtra("Location");



        bb_name_TV.setText(""+Name);
        bb_mobile_TV.setText("Mobile : "+Mobile);
        bb_description_TV.setText("Description : "+Description);
        bb_location_TV.setText("Location :\n"+Location);



        bb_call_now_btn.setOnClickListener(v->{

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+Mobile));
            startActivity(callIntent);

        });

    }
}