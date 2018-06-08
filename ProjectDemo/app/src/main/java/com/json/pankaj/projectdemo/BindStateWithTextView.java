package com.json.pankaj.projectdemo;

import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class BindStateWithTextView extends BaseAdapter
{

    String[] STATE = {"State1","State2","State3","State4","State5","State6","State7","State8","State9","State10"};

    @Override
    public int getCount() {
        return STATE.length;
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
        convertView = inflater.inflate(R.layout.state_text, parent,false);

        TextView textName = (TextView)convertView.findViewById(R.id.textId);

        textName.setText(STATE[position]);

        return convertView;
    }
}
