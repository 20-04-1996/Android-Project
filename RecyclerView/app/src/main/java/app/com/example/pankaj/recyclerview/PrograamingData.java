package app.com.example.pankaj.recyclerview;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PrograamingData extends RecyclerView.Adapter<PrograamingData.ProgrammingViewHolder> {

    private String[] data;

    public PrograamingData(String[] data){
        this.data = data;
    }

    @NonNull
    @Override
    public ProgrammingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_in_recyclerview,parent,false);

        return new ProgrammingViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProgrammingViewHolder holder, int position) {

        String title = data[position];
        holder.text_name.setText(title);
    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ProgrammingViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView text_name;

        public ProgrammingViewHolder(View itemView) {
            super(itemView);

            image = (ImageView)itemView.findViewById(R.id.image);
            text_name = (TextView)itemView.findViewById((R.id.text_name));

        }
    }

}
