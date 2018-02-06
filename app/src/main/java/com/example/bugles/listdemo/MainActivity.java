package com.example.bugles.listdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {


    private Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent it = new Intent(MainActivity.this, ListViewInListActivity.class);
        startActivity(it);




        new Thread(new Runnable() {
            @Override
            public void run() {
                final String result = MineUtil.get("https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=0&limit=20");
                final String[] res = {result, "haha", "lala"};

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        Log.d("debug", result);
                        Log.d("debug", "I got here!!!");
                        showMyStuff(res);
                    }
                });
            }

            }).start();



    }

    private void showMyStuff (String[] str){
        //build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.item,
                str);
        //Configure the list view
        ListView list = (ListView) findViewById(R.id.listViewMain);
        list.setAdapter(adapter);

    }
}






