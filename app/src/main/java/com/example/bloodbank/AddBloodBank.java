package com.example.bloodbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class AddBloodBank extends AppCompatActivity {

    EditText bb_name,bb_description,bb_mobile,bb_location;
    Button add_bb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_blood_bank);

        bb_name = findViewById(R.id.bb_name);
        bb_description = findViewById(R.id.bb_description);
        bb_mobile = findViewById(R.id.bb_mobile);
        bb_location = findViewById(R.id.bb_location);

        add_bb = findViewById(R.id.add_bb);


        add_bb.setOnClickListener(v->{

            String Name = bb_name.getText().toString();
            String Description = bb_description.getText().toString();
            String Mobile = bb_mobile.getText().toString();
            String Location = bb_location.getText().toString();


            HashMap<Object, String> hashMap = new HashMap<>();

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String userID = user.getUid();

            hashMap.put("bb_name", Name);
            hashMap.put("bb_description", Description);
            hashMap.put("bb_mobile", Mobile);
            hashMap.put("bb_location", Location);
            hashMap.put("bb_addedBy",userID);

            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("BloodBank");

            reference.push().setValue(hashMap);

            Toast.makeText(getApplicationContext(), "Blood Bank Added", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(getApplicationContext(),BloodBank.class));
            finish();

        });




    }
}