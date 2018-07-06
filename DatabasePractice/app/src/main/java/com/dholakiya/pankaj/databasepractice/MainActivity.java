package com.dholakiya.pankaj.databasepractice;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {

    Context context;
    MyDatabaseClass adapter;
    EditText Username;
    SQLiteDatabase db;
    EditText Password;
    Button button,button1;
    private ProgressDialog pDialog;
    private ListView lv;
    private String TAG = MainActivity.class.getSimpleName();
    private static final String json_url = "https://api.myjson.com/bins/nbsve";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Username = (EditText) findViewById(R.id.name);
        Password = (EditText) findViewById(R.id.address);
        button = (Button) findViewById(R.id.button);
        button1 = (Button)findViewById(R.id.showListView);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,ListViewActivity.class);
                startActivity(intent);
            }
        });

        adapter = new MyDatabaseClass(this);

        GetContacts getContacts = new GetContacts();
        getContacts.execute(json_url);

    }

    private class GetContacts extends AsyncTask<String, Void , String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // Showing progress dialog
            pDialog = new ProgressDialog(MainActivity.this);
            pDialog.setMessage("Please wait...");
            pDialog.setCancelable(false);
            pDialog.show();

        }

        @Override
        protected String doInBackground(String... strings) {

            HttpHandler sh = new HttpHandler();

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(json_url);

            Log.e(TAG, "Response from url: " + jsonStr);

            return jsonStr;
        }

        @Override
        protected void onPostExecute(String result) {

            // Dismiss the progress dialog
            if (pDialog.isShowing())
                pDialog.dismiss();

            try {
                JSONObject jsonObj = new JSONObject(result);

                // Getting JSON Array node
                JSONArray contacts = jsonObj.getJSONArray("contacts");

                // looping through All Contacts
                for (int i = 0; i < contacts.length(); i++) {
                    JSONObject c = contacts.getJSONObject(i);

                    String name = c.getString("name");

                    String email = c.getString("email");

                    String address = c.getString("address");

                    String gender = c.getString("gender");

                    adapter.insert(name, email, address, gender);


                }

            } catch (JSONException e) {
                e.getMessage();
            }


        }
    }
}