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

public class AddRequest extends AppCompatActivity {

    EditText req_name,req_group,req_description,req_mobile,req_location;
    Button submit_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_request);

        req_name = findViewById(R.id.req_name);
        req_group = findViewById(R.id.req_group);
        req_description = findViewById(R.id.req_description);
        req_mobile = findViewById(R.id.req_mobile);
        req_location = findViewById(R.id.req_location);

        submit_btn = findViewById(R.id.submit_btn);





        submit_btn.setOnClickListener(v->{

            String Name = req_name.getText().toString();
            String bGroup = req_group.getText().toString();
            String Description = req_description.getText().toString();
            String Mobile = req_mobile.getText().toString();
            String Location = req_location.getText().toString();


            HashMap<Object, String> hashMap = new HashMap<>();

            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            String userID = user.getUid();

            hashMap.put("name", Name);
            hashMap.put("bGroup", bGroup);
            hashMap.put("description", Description);
            hashMap.put("mobile", Mobile);
            hashMap.put("location", Location);


            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference reference = database.getReference("Request");

            reference.push().setValue(hashMap);


            Toast.makeText(getApplicationContext(), "Requested for blood", Toast.LENGTH_SHORT).show();

            startActivity(new Intent(getApplicationContext(),RequestActivity.class));
            finish();



        });














    }
}