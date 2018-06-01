package com.json.pankaj.jsonparsing.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.request.RequestOptions;
import com.json.pankaj.jsonparsing.R;
import com.json.pankaj.jsonparsing.model.Anim;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final String JSON_URL = "https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    private JsonArrayRequest jsonArrayRequest;
    private RequestQueue requestQueue;
    private List<Anim> listAnim;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listAnim = new ArrayList<>();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        jsonRequest();
    }

    private void jsonRequest() {
        jsonArrayRequest = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for(int i = 0; i < response.length(); i++){
                    try{
                        jsonObject = response.getJSONObject(i);
                        Anim anim = new Anim();
                        anim.setName(jsonObject.getString("name"));
                        anim.setDescription(jsonObject.getString("description"));
                        anim.setRating(jsonObject.getString("Rating"));
                        anim.setEpisode(jsonObject.getString("episode"));
                        anim.setCatagories(jsonObject.getString("categorie"));
                        anim.setStudio(jsonObject.getString("studio"));
                        anim.setImage_url(jsonObject.getString("img"));
                        listAnim.add(anim);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                setUpRecyclerView(listAnim);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }

    private void setUpRecyclerView(List<Anim> listAnim) {

    RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,listAnim);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(myAdapter);
    }



}
