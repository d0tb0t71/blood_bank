package com.example.bloodbank;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class BloodBank extends AppCompatActivity {

    FloatingActionButton floating_button;
    RecyclerView recyclerView;

    ArrayList<ModelBloodBank> list;
    AdapterBloodBank adapterBloodBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood_bank);

        floating_button = findViewById(R.id.floating_button);
        recyclerView = findViewById(R.id.recyclerView);





        recyclerView  = findViewById(R.id.recyclerView);

        LinearLayoutManager layoutManager = new LinearLayoutManager(BloodBank.this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        adapterBloodBank = new AdapterBloodBank(this,list);
        recyclerView.setAdapter(adapterBloodBank);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("BloodBank");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ModelBloodBank modelBloodBank = dataSnapshot.getValue(ModelBloodBank.class);

                    list.add(modelBloodBank);
                }

                adapterBloodBank.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
























        floating_button.setOnClickListener(v->{

            startActivity(new Intent(getApplicationContext(), AddBloodBank.class));
            finish();

        });




    }
}