package com.example.bloodbank;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterBloodBank extends RecyclerView.Adapter<AdapterBloodBank.MyViewHolder> {

    Context context;
    ArrayList<ModelBloodBank> list;

    public AdapterBloodBank(Context context, ArrayList<ModelBloodBank> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_blood_bank,parent,false);
        return new MyViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelBloodBank modelBloodBank  = list.get(position);

        holder.bb_name.setText(""+modelBloodBank.getBb_name());
        holder.bb_mobile.setText(""+modelBloodBank.getBb_mobile());
        holder.bb_location.setText(""+modelBloodBank.getBb_location());


        holder.bb_name.setOnClickListener(v->{

            startBBDetails(modelBloodBank.getBb_name(),modelBloodBank.getBb_addedBy(),modelBloodBank.getBb_description(),modelBloodBank.getBb_mobile(),modelBloodBank.getBb_location());

        });
        holder.bb_mobile.setOnClickListener(v->{

            startBBDetails(modelBloodBank.getBb_name(),modelBloodBank.getBb_addedBy(),modelBloodBank.getBb_description(),modelBloodBank.getBb_mobile(),modelBloodBank.getBb_location());

        });
        holder.bb_location.setOnClickListener(v->{

            startBBDetails(modelBloodBank.getBb_name(),modelBloodBank.getBb_addedBy(),modelBloodBank.getBb_description(),modelBloodBank.getBb_mobile(),modelBloodBank.getBb_location());

        });

    }

    private void startBBDetails(String bb_name, String bb_addedBy, String bb_description, String bb_mobile, String bb_location) {

        Intent intent = new Intent(context.getApplicationContext(), BBDetails.class);
        intent.putExtra("Name",bb_name );
        intent.putExtra("AddedBy",bb_addedBy);
        intent.putExtra("Description",bb_description);
        intent.putExtra("Mobile",bb_mobile);
        intent.putExtra("Location",bb_location);
        context.startActivity(intent);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView bb_name,bb_mobile,bb_location;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bb_name = itemView.findViewById(R.id.bb_name);
            bb_mobile = itemView.findViewById(R.id.bb_mobile);
            bb_location = itemView.findViewById(R.id.bb_location);


        }
    }
}
