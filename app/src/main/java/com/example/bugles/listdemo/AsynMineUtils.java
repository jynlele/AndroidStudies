package com.example.bugles.listdemo;


import android.os.Handler;


/**
 * Created by bugles on 2018-02-10.
 */

public class AsynMineUtils {
    public interface Callback {
        void onResponse(String response);
    }

    public static void get(final String url, final Callback callback) {
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
               final  String response = MineUtil.get(url);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                callback.onResponse(response);
                            }
                        });
                    }


                });
            }
        }).start();

    }

    public static void post(final String url, final String params, final Callback callback){
        final Handler handler = new Handler();
        new Thread(new Runnable() {
            @Override
            public void run() {
                final String response = MineUtil.post(url, params);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        callback.onResponse(response);
                    }
                });
            }
        }).start();
    }



}









