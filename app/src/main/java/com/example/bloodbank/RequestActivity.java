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

public class RequestActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    RecyclerView recyclerView;
    ArrayList<ModelRequest> list;
    AdapterRequest adapterRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);


        floatingActionButton = findViewById(R.id.floating_action_btn);



        recyclerView  = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(RequestActivity.this);
        layoutManager.setReverseLayout(true);
        layoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(layoutManager);

        list = new ArrayList<>();

        adapterRequest = new AdapterRequest(this,list);
        recyclerView.setAdapter(adapterRequest);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Request");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                    ModelRequest modelRequest = dataSnapshot.getValue(ModelRequest.class);

                    list.add(modelRequest);
                }

                adapterRequest.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });




        floatingActionButton.setOnClickListener(v -> {

            startActivity(new Intent(getApplicationContext(), AddRequest.class));
            finish();

        });


    }
}