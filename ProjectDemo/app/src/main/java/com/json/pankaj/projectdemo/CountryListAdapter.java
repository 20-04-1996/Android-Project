package com.json.pankaj.projectdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class CountryListAdapter extends BaseAdapter {

    ImageView imageView;
    TextView textName;
    TextView textDesc;




    private int[] IMAGE = {
            R.drawable.img1, R.drawable.img2, R.drawable.img3, R.drawable.img4, R.drawable.img5,
            R.drawable.img6, R.drawable.img7, R.drawable.img8, R.drawable.img9, R.drawable.img10,
            R.drawable.img11, R.drawable.img12, R.drawable.img13, R.drawable.img14, R.drawable.img15
    };

    public String[] FLAG_NAME= {"India", "Australia", "Rashiya", "China", "England", "Pakistan","Afghanistan",
            "Belgium", "Bhutan", "Brazil", "Bulgaria", "Denmark", "Egypt", "France", "Germany"};

    private String[] FLAG_DESCRIPTION = {"Awsom Country!!","Time Paas", "Bekar Country", "Navri Country","Bhangar Country",
            "Kain levanu nathi aama","Nonvage Country","Mel vagar nu tantra", "Koi facility nathi ahiya",
            "Awson Nature","Famous places here","Kantalo aave evi country","Koi sara place j nhi farvana","Nie Place","Amazing"};




    @Override
    public int getCount() {
        return IMAGE.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }




    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.list_item,null);

        imageView = (ImageView)convertView.findViewById(R.id.imageId);
        textName  = (TextView)convertView.findViewById(R.id.itemName);
        textDesc = (TextView)convertView.findViewById(R.id.itemDescription);

        imageView.setImageResource(IMAGE[position]);
        textName.setText(FLAG_NAME[position]);
        textDesc.setText(FLAG_DESCRIPTION[position]);

       return convertView;


    }
}
