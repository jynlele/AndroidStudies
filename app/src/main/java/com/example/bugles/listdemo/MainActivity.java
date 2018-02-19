package com.example.bugles.listdemo;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Handler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.util.ArrayList;
import java.util.List;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {


    Response responseObj;
    readerAdapter adapter;
    String url = "https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=0&limit=2";
    Gson gson;
    AsyncHttpClient client;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


                     AsynMineUtils.get("https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=0&limit=2", new AsynMineUtils.Callback() {
                         @Override
                         public void onResponse(String response) {
                             Log.d("test", response);

                             //parse json
                           gson = new Gson();
                           responseObj = gson.fromJson(response, Response.class);

                           //set adapter to list view
                           adapter = new readerAdapter(MainActivity.this, responseObj.getData());
                             Log.d("test", "I got here");
                             ListView listView = (ListView) findViewById(R.layout.activity_main);
                           listView.setAdapter(adapter);






                         }
                     });




//        listView =(ListView) findViewById(R.id.listViewMain);
//
//
//
//        client = new AsyncHttpClient();
//        client.get(MainActivity.this, url, new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//                //get response string
//                String responsesStr = new String(responseBody);
//                Log.d("debug", responsesStr);
//                //parse json
//                gson = new Gson();
//                responseObj = gson.fromJson(responsesStr, Response.class);
//                //set adapter to list view
//                adapter = new readerAdapter(MainActivity.this, responseObj.getData());
//                listView.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
//
//            }
//        });
        /*
        to test new Activity avaliable
         */
//        Intent it = new Intent(MainActivity.this, ListViewInListActivity.class);
//        startActivity(it);
//

/*
this is for refresh on Listviw
 */

//        String[] ln = {"a", "b", "c"};
//        showMyStuff(ln);
//
//        final SwipeRefreshLayout srl = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
//        srl.setColorSchemeColors(R.color.refresh, R.color.refresh1, R.color.refresh2);
//        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
//            @Override
//            public void onRefresh() {
//                srl.setRefreshing(true);
//                (new Handler()).postDelayed(new Runnable() {
//                    @Override
//                    public void run() {
//                        srl.setRefreshing(false);
//
//                     AsynMineUtils.get("https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=0&limit=20", new AsynMineUtils.Callback() {
//                         @Override
//                         public void onResponse(String response) {
//                             List<String> aList = new ArrayList<String>();
//                             aList.add(response);
//                             aList.add("it is done");
//                             aList.add("haha");
//                             aList.add("lala");
//                             String[] list = new String[aList.size()];
//                             list = aList.toArray(list);
//                             showMyStuff(list);
//                         }
//                     });
//
//
//
//
//                    }
//                },2000);
//            }
//        });










    }


    /*
    this is for listView
     */
    private void showMyStuff (String[] str){


        //build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.simple_list_item_1,
                str);
        //Configure the list view
        ListView list = (ListView) findViewById(R.id.listViewMain);

        list.setAdapter(adapter);
        Log.d("debug", "showMyStuff is running");

    }

}






