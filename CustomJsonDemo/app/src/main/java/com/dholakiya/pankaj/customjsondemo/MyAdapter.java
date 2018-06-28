package com.dholakiya.pankaj.customjsondemo;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;


import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {

    Context c;
    List<GetJsonData> kkk;


    public MyAdapter(List<GetJsonData> list, Context c){
        this.c = c;
        this.kkk = list;

    }

    @Override
    public int getCount() {
        return kkk.size();
    }

    @Override
    public Object getItem(int position) {
        return kkk.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.list_item, parent, false);

        TextView tvN = (TextView)convertView.findViewById(R.id.hero_name);
        TextView tvS = (TextView)convertView.findViewById(R.id.hero_surname);
        ImageView tvM = (ImageView)convertView.findViewById(R.id.image_flag);
        GetJsonData getJsonData = kkk.get(position);

        tvN.setText(getJsonData.getHeroName());
        tvS.setText(getJsonData.getHeroSurname());

        Glide.with(c).load(getJsonData.getImageUrl()).into(tvM);

        return convertView;
    }
}
