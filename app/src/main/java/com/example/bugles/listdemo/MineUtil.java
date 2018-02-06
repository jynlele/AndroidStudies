package com.example.bugles.listdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by bugles on 2018-02-05.
 */

public class MineUtil {
    public static String post(String url, String params){
        String result = null;
        HttpURLConnection conn = null;
        try {
            URL adrs = new URL(url);
            conn = (HttpURLConnection) adrs.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoInput(true);

            conn.getOutputStream().write(params.getBytes());

            StringBuilder stringBuilder = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String ln = null;
            while ((ln = bufferedReader.readLine()) != null) {
                stringBuilder.append(ln);
            }
            result = stringBuilder.toString();

        }catch(Exception e){
                e.printStackTrace();

            }
            return JsonFormatUtil.formatJson(result);






    }



    public static String get(String url){
        String res = "";
        HttpURLConnection conn = null;
        try{
            //convert input string url to HTTPURLConneciton
            URL adrs = new URL(url);
            conn = (HttpURLConnection)adrs.openConnection();

            //set request method
            conn.setRequestMethod("GET");

            //set input
            conn.setDoInput(true);

            //build a string builder and get input stream to string
            StringBuilder sb = new StringBuilder();
            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String ln = "";
            while((ln = br.readLine())!=null){
                sb.append(ln);
            }
            res = sb.toString();




        }catch (Exception e){
            e.printStackTrace();
        }
        return JsonFormatUtil.formatJson(res);


    }





}
