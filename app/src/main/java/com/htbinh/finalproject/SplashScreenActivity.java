package com.htbinh.finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.htbinh.finalproject.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {

    ImageView main;
    TextView name;

    Animation topAnim, botAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation);
        botAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);

        main = findViewById(R.id.imageView);
        name = findViewById(R.id.appName);

        main.setAnimation(topAnim);
        name.setAnimation(botAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(SplashScreenActivity.this, LoginActivity.class);
                startActivity(in);
                finish();
            }
        },3000);

    }
}