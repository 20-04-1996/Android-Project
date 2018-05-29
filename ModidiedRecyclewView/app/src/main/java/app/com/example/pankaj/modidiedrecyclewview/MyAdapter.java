package app.com.example.pankaj.modidiedrecyclewview;

import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {


    private List<GallaryActivity> listItem;
    private Context context;

    public MyAdapter(List<GallaryActivity> listItem, Context context) {
        this.listItem = listItem;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_gallary,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        GallaryActivity gallaryActivity = listItem.get(position);
        holder.textHead.setText(gallaryActivity.getHeading());
        holder.textdes.setText(gallaryActivity.getDescription());
    }

    @Override
    public int getItemCount() {
        return listItem.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textHead;
        TextView textdes;

        public ViewHolder(View itemView) {
            super(itemView);
            textHead = (TextView)itemView.findViewById(R.id.textHeading);
            textdes = (TextView)itemView.findViewById(R.id.textDescription);
        }
    }
}
