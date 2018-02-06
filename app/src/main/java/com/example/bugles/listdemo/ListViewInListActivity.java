package com.example.bugles.listdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;

public class ListViewInListActivity extends AppCompatActivity {
    private static final String[] names = new String[]{"斗破苍穹", "网游之终极牧师", "琴帝"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("debug","To the second Activity");
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list, names);
//        setListAdapter(adapter);
    }
}

