package com.example.bugles.listdemo;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

public class ListViewInListActivity extends ListActivity {
    private static final String[] names = new String[]{"斗破苍穹","网游之终极牧师","琴帝"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abc_action_bar_view_list_nav_layout);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout. abc_list_menu_item_layout, names);
        setListAdapter(adapter);
    }

}