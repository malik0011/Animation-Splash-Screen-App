package com.example.booking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AllData extends AppCompatActivity {

    RecyclerView rcv;
    Adapter adapter;
    EditText editText;
    ArrayList<Model> holder = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_data);
        rcv = findViewById(R.id.rcView);
        rcv.setLayoutManager(new LinearLayoutManager(this));
        editText = findViewById(R.id.search_bar);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                filteredList(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

//            val+= i+"name : " +cursor.getString(1)
//                    +"\nEmail : "+cursor.getString(2)
//                    +"\nPhone : " +cursor.getString(3)
//                    +"\nAddress : " +cursor.getString(4)
//                    +"\nPin : " +cursor.getString(5)
//                    +" \nCheck in Date : "+ cursor.getString(6)
//                    +"\nCheck out Date : " +cursor.getString(7)
//                    +"\nCountry : "+cursor.getString(8)
//                    +"\nOther req :"+cursor.getString(9)
//                    +"\nnumber of adults : "+cursor.getString(10)
//                    +"\nNumbers of Child : "+cursor.getString(11)
//                    +"\nRoom type : "+cursor.getString(12);
//
//            val += "   -------------------------------------------   \n";
       // tv.setText(val);



        adapter = new Adapter(dataQueue()) ;
        rcv.setAdapter(adapter);


    }

    private void filteredList(CharSequence charSequence) {
    String text = charSequence.toString();

        ArrayList<Model> filteredList = new ArrayList<>();
        for(Model model : holder){

            if(model.getName().toLowerCase().contains(text.toLowerCase()) ||
                    model.getAddress().toLowerCase().contains(text.toLowerCase()) ||
                    model.getAdultsNumber().toLowerCase().contains(text.toLowerCase()) ||
                    model.getCountry().toLowerCase().contains(text.toLowerCase()) ||
                    model.getChildsNumber().toLowerCase().contains(text.toLowerCase()) ||
                    model.getId().toLowerCase().contains(text.toLowerCase()) ||
                    model.getInDate().toLowerCase().contains(text.toLowerCase()) ||
                    model.getMail().toLowerCase().contains(text.toLowerCase()) ||
                    model.getOther().toLowerCase().contains(text.toLowerCase()) ||
                    model.getPh().toLowerCase().contains(text.toLowerCase()) ||
                    model.getPin().toLowerCase().contains(text.toLowerCase()) ||
                    model.getRoomtype().toLowerCase().contains(text.toLowerCase())
            ){
                filteredList.add(model);
            }
            
            if(filteredList.isEmpty()){
                Toast.makeText(this, "No data found!", Toast.LENGTH_SHORT).show();
            }else{
                adapter.setFilteredlist(filteredList);
            }

        }

    }

    public ArrayList<Model> dataQueue(){

        //to fetch data form db
        Cursor cursor = new dbManager(this).ShowAllData(); //here we get the db ref.


        //now we have go through the cursor || 12 items are there
        int i=cursor.getCount();
        while(cursor.moveToNext()){

            holder.add(new Model(String.valueOf(i),
                    "name : " +cursor.getString(1),
                    "Email : "+cursor.getString(2),
                    "Phone : " +cursor.getString(3),
                    "Address : " +cursor.getString(4),
                    "Pin : " +cursor.getString(5),
                    " Check in Date : "+ cursor.getString(6),
                    "Check out Date : " +cursor.getString(7),
                    "Country : "+cursor.getString(8),
                    "Other req :"+cursor.getString(9),
                    "Number of adults : "+cursor.getString(10),
                    "Numbers of Child : "+cursor.getString(11),
                    "Room type : "+cursor.getString(12)
                    ));
            i--;
        }

        Collections.reverse(holder);
        return holder;
    }
}