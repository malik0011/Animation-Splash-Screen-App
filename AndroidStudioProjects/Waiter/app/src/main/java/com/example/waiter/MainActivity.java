package com.example.waiter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.waiter.Adapters.MainAdapter;
import com.example.waiter.Models.MainModel;
import com.example.waiter.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //now i have to make a array list to store the item in list.....so,

        ArrayList<MainModel> list  = new ArrayList<>(); //list creation done!

        //adding values into the lists...

        list.add(new MainModel(R.drawable.biriyani,"Biriyani","3","biryani is a spiced mix of meat and rice,traditionally cooked over an open fire in a leather pot"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","10","This is a Pizza,with toffings"));
        list.add(new MainModel(R.drawable.burger,"Burger","0","this if burger"));
        list.add(new MainModel(R.drawable.coffe,"Coffe","30","This is Black Coffe!"));
        list.add(new MainModel(R.drawable.sod,"SOD","12","Don't know the name but is Grate to have!"));


        MainAdapter adapter = new MainAdapter(list, this);
        binding.recycleView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recycleView.setLayoutManager(layoutManager);
    }
}