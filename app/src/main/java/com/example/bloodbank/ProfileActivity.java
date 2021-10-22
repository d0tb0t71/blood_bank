package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity {

    TextView profile_name,profile_mobile,profile_email,profile_address,profile_blood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profile_name = findViewById(R.id.profile_name);
        profile_mobile = findViewById(R.id.profile_mobile);
        profile_email = findViewById(R.id.profile_email);
        profile_address = findViewById(R.id.profile_address);
        profile_blood = findViewById(R.id.profile_blood);



        DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("Users");
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();


        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot:snapshot.getChildren()){

                    if(user.getUid().equals(dataSnapshot.child("uid").getValue())){

                        String Name = ""+dataSnapshot.child("name").getValue();
                        String Mobile = ""+dataSnapshot.child("phone").getValue();
                        String Address = ""+dataSnapshot.child("address").getValue();
                        String Email = ""+dataSnapshot.child("email").getValue();
                        String bGroup = ""+dataSnapshot.child("bGroup").getValue();


                        profile_name.setText(Name);
                        profile_mobile.setText("Mobile: "+Mobile);
                        profile_address.setText("Address: "+Address);
                        profile_email.setText("Email: "+Email);
                        profile_blood.setText("Blood Group: "+bGroup);



                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });







    }
}