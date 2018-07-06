package com.dholakiya.pankaj.databasepractice;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;


public class RowAdaapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> id;
    private ArrayList<String> name;
    private ArrayList<String> email;
    private ArrayList<String> address;
    private ArrayList<String> gender;

    public RowAdaapter(Context context, ArrayList<String> id, ArrayList<String> name, ArrayList<String> email, ArrayList<String> address, ArrayList<String> gender) {

        this.context = context;
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
        this.gender = gender;
    }

    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return name.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class MyViewHolder{

        TextView tvId;
        TextView tvName;
        TextView tvEmail;
        TextView tvAddress;
        TextView tvGender;

        public MyViewHolder(View v){

            tvId = (TextView)v.findViewById(R.id.userId);
            tvName = (TextView)v.findViewById(R.id.userName);
            tvEmail = (TextView)v.findViewById(R.id.userEmail);
            tvAddress = (TextView)v.findViewById(R.id.userAddress);
            tvGender = (TextView)v.findViewById(R.id.userGender);

        }

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        MyViewHolder holder;
        LayoutInflater inflater;
        new MyDatabaseClass.MyDBClass(context);
        if(row == null) {

            inflater = (LayoutInflater) LayoutInflater.from(context);
            row = inflater.inflate(R.layout.list_item, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
        }else{

            holder = (MyViewHolder)row.getTag();
        }

        holder.tvId.setText(id.get(position));
        holder.tvName.setText(name.get(position));
        holder.tvEmail.setText(email.get(position));
        holder.tvAddress.setText(address.get(position));
        holder.tvGender.setText(gender.get(position));

        return row;
    }

}
