package com.example.bugles.listdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by bugles on 2018-02-13.
 */

public class readerAdapter extends BaseAdapter {

    private List<Response.DataBean> dData;
    private Context dContext;
    private LayoutInflater inflater;

    public readerAdapter(List<Response.DataBean> dData, Context dContext, LayoutInflater inflater) {
        this.dData = dData;
        this.dContext = dContext;
        this.inflater = inflater;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
