package com.example.netflix;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
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
    RecyclerView recyclerView;
    List<Movie> film;

    private String URL = "https://api.themoviedb.org/3/movie/popular?api_key=caa4226c251747a5c3bf3d6bc23b2d18&language=en-us";
    private String image_URL = "https://image.tmdb.org/t/p/w185";
    Adapter adapter;
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.netflixRow);
        film = new ArrayList<>();
        adapter = new Adapter(getApplicationContext(),film);
        llm = new LinearLayoutManager(getApplicationContext());
        llm.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        getNetflix();

    }



    private void getNetflix(){
        StringRequest request = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @SuppressLint("NotifyDataSetChanged")
            @Override
            public void onResponse(String response) {
                Log.d("Success",response.toString());
                try {
                    JSONObject json = new JSONObject(response);
                    JSONArray jsonArray = json.getJSONArray("results");
                    if(jsonArray.length() > 0){
                        for (int i =0; i<jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            Movie films = new Movie();
                            films.setMovieTitle(jsonObject.getString("original_title").toString());
                            films.setBackdrop_path(image_URL+jsonObject.getString("backdrop_path"));
                            films.setPoster_path(image_URL+jsonObject.getString("poster_path"));
                            films.setMovieRating(jsonObject.getString("vote_average").toString());
                            films.setMovie_detail(jsonObject.getString("overview").toString());
                            film.add(films);
                        }
                        adapter.notifyDataSetChanged();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }

            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}