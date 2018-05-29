package app.com.example.pankaj.modidiedrecyclewview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<GallaryActivity> listItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        listItem = new ArrayList<>();

        for(int i=0; i<=10; i++){
            GallaryActivity gallaryActivity = new GallaryActivity(
                    "Heading" + (i+1),
                    "Here are some data"
            );

            listItem.add(gallaryActivity);
        }

        adapter= new MyAdapter(listItem,this);
        recyclerView.setAdapter(adapter);



    }
}
