package com.example.booking;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myViewHolder extends RecyclerView.ViewHolder {
    TextView id,name,mail,ph,address,pin,inDate,outDate,country,Other,adultsNumber,childsNumber,roomtype;
    Button update;
    public myViewHolder(@NonNull View itemView) {
        super(itemView);
        id = itemView.findViewById(R.id.idNumber);
        name = itemView.findViewById(R.id.name);
        mail = itemView.findViewById(R.id.Email);
        ph = itemView.findViewById(R.id.phone);
        address = itemView.findViewById(R.id.address);
        pin = itemView.findViewById(R.id.pin);
        inDate = itemView.findViewById(R.id.indate);
        outDate = itemView.findViewById(R.id.outDate);
        country = itemView.findViewById(R.id.Country);
        Other = itemView.findViewById(R.id.other);
        adultsNumber = itemView.findViewById(R.id.adults);
        childsNumber = itemView.findViewById(R.id.child);
        roomtype = itemView.findViewById(R.id.room);
        //update = itemView.findViewById(R.id.update);

    }
}
