package com.dholakiya.pankaj.databasepractice;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {


    ListView listView;
    SQLiteDatabase db;
    private  ArrayList<String> id = new ArrayList<>();
    private ArrayList<String> name = new ArrayList<>();
    private ArrayList<String> email = new ArrayList<>();
    private ArrayList<String> address = new ArrayList<>();
    private ArrayList<String> gender = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView)findViewById(R.id.listView);
        displayData();



        final RowAdaapter adaapter = new RowAdaapter(ListViewActivity.this,id, name, email, address, gender);
        listView.setAdapter(adaapter);



        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                db.execSQL("DELETE FROM "+MyDatabaseClass.MyDBClass.getTable_Name()+ " WHERE _id = "+position);

                name.remove(position);
                email.remove(position);
                address.remove(position);
                gender.remove(position);

                adaapter.notifyDataSetChanged();

                return false;
            }
        });

    }



    public void displayData(){

        db = new MyDatabaseClass.MyDBClass(this).getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM  Contact_Detail",null);

        id.clear();
        name.clear();
        email.clear();
        address.clear();
        gender.clear();

        if(cursor.moveToFirst()) {
            do {
                id.add(cursor.getString(cursor.getColumnIndex("_id")));
                name.add(cursor.getString(cursor.getColumnIndex("Name")));
                email.add(cursor.getString(cursor.getColumnIndex("Email")));
                address.add(cursor.getString(cursor.getColumnIndex("Address")));
                gender.add(cursor.getString(cursor.getColumnIndex("Gender")));

            } while (cursor.moveToNext());
        }

        cursor.close();

    }
}
