package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class FindDonor extends AppCompatActivity {
    Button im_donor;
    RecyclerView recyclerView;
    AdapterDonor adapterDonor;
    ArrayList<ModelDonor> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_donor);

        im_donor = findViewById(R.id.im_donor);
        recyclerView= findViewById(R.id.recyclerView_FD);

        LinearLayoutManager layoutManager = new LinearLayoutManager(FindDonor.this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        adapterDonor = new AdapterDonor(this,list);
        recyclerView.setAdapter(adapterDonor);

        DatabaseReference databaseReference0 = FirebaseDatabase.getInstance().getReference("Donor");
        databaseReference0.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                list.clear();

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ModelDonor modelDonor = dataSnapshot.getValue(ModelDonor.class);

                    list.add(modelDonor);
                }

                adapterDonor.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });












        im_donor.setOnClickListener(v->{





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


                            HashMap<Object,String> hashMap = new HashMap<>();

                            hashMap.put("email",Email);
                            hashMap.put("uid",user.getUid());
                            hashMap.put("name",Name);
                            hashMap.put("mobile",Mobile);
                            hashMap.put("address",Address);
                            hashMap.put("bGroup",bGroup);

                            FirebaseDatabase database=FirebaseDatabase.getInstance();
                            DatabaseReference reference=database.getReference("Donor");
                            reference.push().setValue(hashMap);

                            Toast.makeText(getApplicationContext(), "You are successfully added to the donor list", Toast.LENGTH_SHORT).show();

                            im_donor.setVisibility(View.GONE);

                        }

                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });



        });


    }
}