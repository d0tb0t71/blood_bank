package com.example.bloodbank;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterDonor extends RecyclerView.Adapter<AdapterDonor.MyViewHolder> {
    Context context;
    ArrayList<ModelDonor> list;

    public AdapterDonor(Context context, ArrayList<ModelDonor> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_donor,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelDonor modelDonor = list.get(position);

        holder.donor_bGroup.setText(modelDonor.getbGroup());
        holder.donor_name.setText(modelDonor.getName());
        holder.donor_mobile.setText(modelDonor.getMobile());
        holder.donor_location.setText(modelDonor.getAddress());





        holder.call_donor.setOnClickListener(v->{

            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel:"+modelDonor.getMobile()));
            context.startActivity(callIntent);

        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView donor_bGroup,donor_name,donor_mobile,donor_location;
        ImageView call_donor;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            donor_bGroup = itemView.findViewById(R.id.donor_bGroup);
            donor_name = itemView.findViewById(R.id.donor_name);
            donor_mobile = itemView.findViewById(R.id.donor_mobile);
            donor_location = itemView.findViewById(R.id.donor_location);

            call_donor = itemView.findViewById(R.id.call_donor);



        }
    }
}
