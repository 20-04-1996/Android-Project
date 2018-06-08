package com.json.pankaj.projectdemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class StateOfCountry extends AppCompatActivity {

    Toolbar toolbar;
    ListView indianStateList;
    TextView mTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_of_country);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        indianStateList = (ListView) findViewById(R.id.indian_state);
        BindStateWithTextView stateAdapter = new BindStateWithTextView();
        indianStateList.setAdapter(stateAdapter);

      Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            toolbar.setTitle(bundle.getString("TitleName"));
        }



    }
}
