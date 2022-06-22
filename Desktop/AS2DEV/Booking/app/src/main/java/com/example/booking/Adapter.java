package com.example.booking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<myViewHolder>{

    ArrayList<Model> data;

    public Adapter(ArrayList<Model> data) {
        this.data = data;
    }

    public void setFilteredlist(ArrayList<Model> filteredlist){
    this.data  = filteredlist;
    notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.custom_view,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        //binding the data to the view
        holder.id.setText(data.get(position).getId());
        holder.name.setText(data.get(position).getName());
        holder.mail.setText(data.get(position).getMail());
        holder.ph.setText(data.get(position).getPh());
        holder.address.setText(data.get(position).getAddress());
        holder.pin.setText(data.get(position).getPin());
        holder.Other.setText(data.get(position).getOther());
        holder.inDate.setText(data.get(position).getInDate());
        holder.outDate.setText(data.get(position).getOutDate());
        holder.adultsNumber.setText(data.get(position).getAdultsNumber());
        holder.childsNumber.setText(data.get(position).getChildsNumber());
        holder.roomtype.setText(data.get(position).getRoomtype());
        holder.country.setText(data.get(position).getCountry());
//        holder.update.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//
//
//                Toast.makeText(view.getContext(), "Coming soon!", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
