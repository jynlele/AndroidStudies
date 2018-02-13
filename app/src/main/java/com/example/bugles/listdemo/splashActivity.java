package com.example.bugles.listdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.os.SystemClock.sleep;

public class splashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                sleep(3000);
//                Intent intent = new Intent(splashActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//
//            }
//
//        }).start();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);


    }
}
