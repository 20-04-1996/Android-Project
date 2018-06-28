package com.dholakiya.pankaj.customjsondemo;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context c;
    List<GetJsonData> dataList;
    ListView listView;

    final String json_url = "https://api.myjson.com/bins/phqcm";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.list_view);
        dataList = new ArrayList<>();
        loadJsonData();
    }

    public void loadJsonData(){

        StringRequest request = new StringRequest(Request.Method.GET, json_url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject object = new JSONObject(response);
                            JSONArray array = object.getJSONArray("heroes");

                            for(int i=0; i<array.length(); i++){
                                JSONObject heroList = array.getJSONObject(i);
                                GetJsonData addItem = new GetJsonData(heroList.getString("name"),
                                        heroList.getString("surname"),
                                        heroList.getString("image"));

                                dataList.add(addItem);
                            }

                            MyAdapter adapter = new MyAdapter(dataList,getApplicationContext());
                            listView.setAdapter(adapter);
                        }
                        catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, "Please check your internet Connetion",
                        Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }

}

