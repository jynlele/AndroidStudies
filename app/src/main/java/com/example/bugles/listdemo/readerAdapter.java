package com.example.bugles.listdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.List;

/**
 * Created by bugles on 2018-02-13.
 */

public class readerAdapter extends BaseAdapter {

    private List<Response.DataBean> dData;
    private Context dContext;
    private LayoutInflater inflater;

    public readerAdapter(Context dContext, List<Response.DataBean> dData) {
        this.dData = dData;
        this.dContext = dContext;
    }

    @Override
    public int getCount() {
        return dData.size();
    }

    @Override
    public Object getItem(int position) {
        return dData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //encapsulation of layout
        LayoutInflater inflater = (LayoutInflater) dContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.simple_list_item_1, parent, false);
        //get respose
        Response.DataBean item = (Response.DataBean) getItem(position);
        //find IDS
        ImageView pic = rowView.findViewById(R.id.picture);
        TextView title = rowView.findViewById(R.id.title);
        TextView summary = rowView.findViewById(R.id.summary);
        TextView contact = rowView.findViewById(R.id.contact);
        TextView city = rowView.findViewById(R.id.city);

        //setText
        String imageURL = item.getCount_image_src();
//        Picasso.with(dContext).load(imageURL).into(pic);
        title.setText(item.getTitle());
        summary.setText(item.getSummary());
        contact.setText(item.getContact().getName()+" "+item.getContact().getPhone1());
//        city.setText((CharSequence) item.getCity());



        return  rowView;

    }
}
