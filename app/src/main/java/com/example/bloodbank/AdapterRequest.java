package com.example.bloodbank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterRequest extends RecyclerView.Adapter<AdapterRequest.MyViewHolder> {

    Context context;
    ArrayList<ModelRequest> list;


    public AdapterRequest(Context context, ArrayList<ModelRequest> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.row_request,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        ModelRequest modelRequest = list.get(position);

        holder.user_name_req.setText("Name : "+modelRequest.getName());
        holder.needed_blood_req.setText("Blood Group : "+modelRequest.getbGroup());
        holder.location_req.setText("Location : "+modelRequest.getLocation());


        holder.user_name_req.setOnClickListener(v->{

            startDetailsPage(modelRequest.getName(), modelRequest.getbGroup(),modelRequest.getMobile(),modelRequest.getDescription(),modelRequest.getLocation());

        });
        holder.needed_blood_req.setOnClickListener(v->{

            startDetailsPage(modelRequest.getName(), modelRequest.getbGroup(),modelRequest.getMobile(),modelRequest.getDescription(),modelRequest.getLocation());

        });

        holder.location_req.setOnClickListener(v->{

            startDetailsPage(modelRequest.getName(), modelRequest.getbGroup(),modelRequest.getMobile(),modelRequest.getDescription(),modelRequest.getLocation());

        });




    }

    private void startDetailsPage(String Name,String bGroup,String Mobile,String Description,String Address) {

        Intent intent = new Intent(context.getApplicationContext(), RequestDetails.class);
        intent.putExtra("Name",Name );
        intent.putExtra("bGroup",bGroup );
        intent.putExtra("Mobile",Mobile );
        intent.putExtra("Description",Description );
        intent.putExtra("Address",Address );
        context.startActivity(intent);



    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView user_name_req,needed_blood_req,location_req;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);


            location_req = itemView.findViewById(R.id.location_req);
            needed_blood_req = itemView.findViewById(R.id.needed_blood_req);
            user_name_req = itemView.findViewById(R.id.user_name_req);

        }
    }
}
