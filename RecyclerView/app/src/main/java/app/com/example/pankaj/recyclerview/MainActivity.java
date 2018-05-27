package app.com.example.pankaj.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    String[] languages = {"Java","Advance Java","C","C++","PHP","CSS","JavaScript","LISP","Borland"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView list = (RecyclerView)findViewById(R.id.recyclerView);

        list.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

       // list.setLayoutManager(new LinearLayoutManager(this));
        list.setAdapter(new PrograamingData(languages));

    }
}
