package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class RequestDetails extends AppCompatActivity {

    TextView details_name,details_mobile,details_description,details_address,details_blood;
    ImageView call_now_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_details);


        details_name = findViewById(R.id.details_name);
        details_mobile = findViewById(R.id.details_mobile);
        details_description = findViewById(R.id.details_description);
        details_address = findViewById(R.id.details_address);
        details_blood = findViewById(R.id.details_blood);

        call_now_btn = findViewById(R.id.call_now_btn);




        String Name = getIntent().getStringExtra("Name");
        String bGroup = getIntent().getStringExtra("bGroup");
        String Mobile = getIntent().getStringExtra("Mobile");
        String Description = getIntent().getStringExtra("Description");
        String Address = getIntent().getStringExtra("Address");



        details_name.setText(""+Name);
        details_mobile.setText(""+Mobile);
        details_description.setText(""+Description);
        details_address.setText(""+Address);
        details_blood.setText(""+bGroup);

        call_now_btn.setOnClickListener(v->{

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+Mobile));
            startActivity(callIntent);


        });




    }
}