package com.example.bugles.listdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private Button bbb;
    private TextView tv;
    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(MainActivity.this, ListViewInListActivity.class);
            startActivity(intent);
        }
    };

    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bbb.setOnClickListener(listener);


        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = MineUtil.get("https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=0&limit=20");

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("debug", result);
                        Log.d("debug", "I got here!!!");
                    }
                });
            }

            }).start();



    }
}






