package com.example.bugles.listdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.squareup.picasso.Downloader;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    private PullUpLoadListView listView;
    private Response responseObj;
    private readerAdapter adapter;
    public int offset = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);;
        /*try to use completableFuture to solve return
         */

/*
AsyncHttpClient
 */
//    listView = (ListView) findViewById(R.id.listViewMain);
//        client = new AsyncHttpClient();
//        client.get(MainActivity.this, url, new AsyncHttpResponseHandler() {
//    public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
//        //get response string
//        String responsesStr = new String(responseBody);
//        //parse json
//        gson = new Gson();
//        responseObj = gson.fromJson(responsesStr, Response.class);
//        Log.d("debug", "I got here");
//        //set adapter to list view
//        adapter = new readerAdapter(MainActivity.this, responseObj.getData());
//        listView.setAdapter(adapter);
//
//
//    }
        listView = (PullUpLoadListView) findViewById(R.id.pull_up_add_list_view);
        adapter = new readerAdapter(MainActivity.this);
        listView.setAdapter(adapter);

        listView.setOnPullUpLoadListener(new PullUpLoadListView.OnPullUpLoadListener() {
            @Override
            public void onPullUpLoading() {
                new LoadDataAsyncTask().execute();
            }
        });
/*
this is for refresh on Listviw
 */

// test refres working
//        String[] ln = {"a", "b", "c"};
//        showMyStuff(ln);
//        final ListView listView = (ListView) findViewById(R.id.listViewMain);
        final SwipeRefreshLayout srl = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        srl.setColorSchemeColors(R.color.refresh, R.color.refresh1, R.color.refresh2);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                srl.setRefreshing(true);
                (new Handler()).postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        srl.setRefreshing(false);
                        adapter.removeAllItem();
                        offset =0;
                        listView.setAdapter(adapter);
                        listView.setOnPullUpLoadListener(new PullUpLoadListView.OnPullUpLoadListener() {
                            @Override
                            public void onPullUpLoading() {
                                new LoadDataAsyncTask().execute();
                            }
                        });


                    }
                }, 1500);

            }
        });


//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        Future<String> future = threadPool.submit(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                String response = MineUtil.get("https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=" + offset + "&limit=2");
//                offset = offset - 1;
//                return response;
//            }
//        });
//
//        try {
//            String responseBody = future.get();
////            Log.d("Debug", responseBodyAdd);
//            responseObj = gson.fromJson(responseBody, Response.class);
//            dData.addAll(responseObj.getData());
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }



    }

    private class LoadDataAsyncTask extends SafeAsyncTask<List<Response.DataBean>> {
        @Override
        public List<Response.DataBean> call() throws Exception {

            List<Response.DataBean> result = null;
                String response = MineUtil.get("https://news-app.apidev.51.ca/get_yellowpages_list?category=46&offset=" + offset + "&limit=5");
                Log.d("debug", response);
                Gson g = new Gson();
                responseObj = g.fromJson(response, Response.class);
                result = responseObj.getData();

                String s = "" + result.isEmpty();
                Log.d("debug", s);
//                if(offset!=0)
                   // Thread.sleep(1300);



            return result;


        }

        @Override
        protected void onSuccess(List<Response.DataBean> newItems) throws Exception {
            super.onSuccess(newItems);
            Log.d("debug", "onSuccess is running!");
            offset = offset + 5;
            if (newItems != null) {
                listView.onPullUpLoadFinished(false);
//            dData.addAll(newItems);
                adapter.addListItemToAdapter(newItems);
//                listView.setAdapter(adapter);
            } else {
                listView.onPullUpLoadFinished(true);
            }


        }
    }


    /*
    this is for simple listView
     */
    private void showMyStuff(String[] str) {


        //build Adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this,
                R.layout.simple_list_item_1,
                str);
        //Configure the list view
        ListView list = (ListView) findViewById(R.id.pull_up_add_list_view);

        list.setAdapter(adapter);
        Log.d("debug", "showMyStuff is running");

    }
}











