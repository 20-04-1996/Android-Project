package com.json.pankaj.projectdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ListView mListview;
    Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListview = (ListView) findViewById(R.id.newListView);
        final CountryListAdapter adapter = new CountryListAdapter();


        mListview.setOnItemClickListener(new AdapterView.OnItemClickListener()

    {
        @Override
        public void onItemClick (AdapterView < ? > parent, View view,int position, long id){


        Intent intent = new Intent(MainActivity.this, StateOfCountry.class);
        intent.putExtra("TitleName", adapter.FLAG_NAME[position]);
        startActivity(intent);
    }
    });

        mListview.setAdapter(adapter);
}



}
