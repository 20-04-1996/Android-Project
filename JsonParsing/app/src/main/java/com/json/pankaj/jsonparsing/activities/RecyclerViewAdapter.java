package com.json.pankaj.jsonparsing.activities;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.json.pankaj.jsonparsing.model.Anim;
import com.json.pankaj.jsonparsing.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder> {

    private Context mContext;
    private List<Anim> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Anim> mData) {
        this.mContext = mContext;
        this.mData = mData;

        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading).error(R.drawable.loading);
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.anim_item,parent,false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_studio.setText(mData.get(position).getRating());
        holder.tv_catagory.setText(mData.get(position).getCatagories());

        //Loading Image through library and set it into imageView
        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(
                option).into(holder.img_raw);


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder{

        TextView tv_name;
        TextView tv_rating;
        TextView tv_studio;
        TextView tv_catagory;
        ImageView img_raw;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            tv_name = itemView.findViewById(R.id.nameRaw);
            tv_rating = itemView.findViewById(R.id.ratingRaw);
            tv_studio = itemView.findViewById(R.id.studioRaw);
            tv_catagory = itemView.findViewById(R.id.catagoryRaw);
            img_raw = itemView.findViewById(R.id.imageRaw);




        }
    }
}
