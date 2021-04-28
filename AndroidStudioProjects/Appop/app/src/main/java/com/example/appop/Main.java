package com.example.appop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class Main extends AppCompatActivity {
    private static  int S = 4500;
ImageView logo,appName,splashImg;
LottieAnimationView lottieAnimationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);
        logo = findViewById(R.id.logo);
        appName = findViewById(R.id.app_name);
        splashImg = findViewById(R.id.img);
        lottieAnimationView =findViewById(R.id.lottie);

        splashImg.animate().translationY(-2500).setDuration(1000).setStartDelay(4000);

        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);

        appName.animate().translationY(1400).setDuration(1000).setStartDelay(4000);

        lottieAnimationView.animate().translationY(1400).setDuration(1000).setStartDelay(4000);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Main.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },S);
    }

}