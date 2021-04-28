package com.example.appop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;

public class MainActivity extends AppCompatActivity {
TextView textView,textView2;
LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        textView2 = findViewById(R.id.textView2);
        textView = findViewById(R.id.textView);
        lottieAnimationView = findViewById(R.id.lottie);

        

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                textView2.setText("Contact Ayan!");
            }
        },4000);
        textView.animate().translationY(200).setDuration(1000).setStartDelay(3000);
    }
}