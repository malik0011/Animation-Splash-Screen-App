package com.example.waiter.Adapters;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.waiter.Models.MainModel;
import com.example.waiter.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder> {

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainfood, parent, false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model = list.get(position);
        //binding the image and texts from model cls to adapter cls to show the things in recycler views
        holder.foodmage.setImageResource(model.getImage());
        holder.price.setText(model.getPrice());
        holder.mainName.setText(model.getName());
        holder.description.setText(model.getDescription());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

       ImageView foodmage;
       TextView mainName, price, description;

       public viewholder(@NonNull View itemView) {
           super(itemView);

           foodmage = itemView.findViewById(R.id.imageView);
           mainName = itemView.findViewById(R.id.orderName);
           price = itemView.findViewById(R.id.price);
           description = itemView.findViewById(R.id.description);
       }
   }
}
