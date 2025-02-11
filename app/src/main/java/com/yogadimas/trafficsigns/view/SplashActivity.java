package com.yogadimas.trafficsigns.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.yogadimas.trafficsigns.R;

public class SplashActivity extends AppCompatActivity {

    final long lDelay = 2000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Animation animFade = AnimationUtils.loadAnimation(this, R.anim.anim_fade);
        ImageView ivApp = findViewById(R.id.iv_header_logo);

        ivApp.startAnimation(animFade);

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent goToMainActivity = new Intent(SplashActivity.this, MainActivity.class);
                SplashActivity.this.startActivity(goToMainActivity);
                SplashActivity.this.finish();
            }
        }, lDelay);
    }
}