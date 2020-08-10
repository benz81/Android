package com.block.movieapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.block.movieapp.adapter.RecyclerViewAdapter;
import com.block.movieapp.model.Movie;
import com.block.movieapp.util.Util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edit_search;
    ImageButton btn_search;
    Button btn_year;
    Button btn_attendance;
    RecyclerView recyclerView;

    RecyclerViewAdapter adapter;
    ArrayList<Movie> movieArrayList = new ArrayList<>();

    RequestQueue requestQueue;

    // 페이징 처리를 위한 변수
    int offset = 0;
    int limit = 25;
    int cnt;

    // 정렬을 위한 변수
    String order;

    String path = "/api/v1/movies";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_search = findViewById(R.id.edit_search);
        btn_search = findViewById(R.id.btn_search);
        btn_year = findViewById(R.id.btn_year);
        btn_attendance = findViewById(R.id.btn_attendance);
        recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager())
                        .findLastCompletelyVisibleItemPosition();
                int totalCount = recyclerView.getAdapter().getItemCount();

                if( (lastPosition + 1) == totalCount){
                    if(cnt == limit) {
                        // 네트워크 통해서, 데이터를 더 불러오면 된다.
                        addNetworkData(path);
                    }
                }
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        getNetworkData(path);

        btn_year.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 데이터를 담고 있는, 어레이리스트를 비워준다.
                movieArrayList.clear();
                offset = 0;
                order = "desc";
                path = "/api/v1/movies/year";
                getNetworkData(path);
            }
        });

    }

    private void getNetworkData(String path) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                Util.BASE_URL +  path + "?offset="+offset+"&limit="+limit+"&order="+order,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("AAA", response.toString());

                        try {
                            boolean success = response.getBoolean("success");
                            if(success == false){
                                // 유저한테 에러있다고 알리고 리턴.
                                return;
                            }
                            JSONArray items = response.getJSONArray("items");
                            for(int i = 0; i < items.length(); i++){
                                int id = items.getJSONObject(i).getInt("id");
                                String title = items.getJSONObject(i).getString("title");
                                String genre = items.getJSONObject(i).getString("genre");
                                int attendance = items.getJSONObject(i).getInt("attendance");
                                String year = items.getJSONObject(i).getString("year");

                                int reply_cnt;
                                if(items.getJSONObject(i).isNull("reply_cnt")){
                                    reply_cnt = 0;
                                }else{
                                    reply_cnt = items.getJSONObject(i).getInt("reply_cnt");
                                }

                                Double avg_rating;
                                if(items.getJSONObject(i).isNull("avg_rating")){
                                    avg_rating = 0.0;
                                }else{
                                    avg_rating = items.getJSONObject(i).getDouble("avg_rating");
                                }

                                Movie movie = new Movie(id, title, genre, attendance,year,reply_cnt,avg_rating);
                                movieArrayList.add(movie);
                            }

                            adapter = new RecyclerViewAdapter(MainActivity.this, movieArrayList);
                            recyclerView.setAdapter(adapter);

                            // 페이징을 위해서, 오프셋을 증가 시킨다. 그래야 리스트 끝에가서 네트워크 다시
                            // 호출할때, 해당 offset 으로 서버에 요청이 가능하다.
                            offset = offset + response.getInt("cnt");
                            cnt = response.getInt("cnt");


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );

        requestQueue.add(request);
    }

    private void addNetworkData(String path) {
        JsonObjectRequest request = new JsonObjectRequest(
                Request.Method.GET,
                Util.BASE_URL +  path + "?offset="+offset+"&limit="+limit+"&order="+order,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            boolean success = response.getBoolean("success");
                            if(success == false){
                                // 유저한테 네트워크 문제있다고 알려준다.
                                return;
                            }
                            JSONArray items = response.getJSONArray("items");
                            for(int i = 0; i < items.length(); i++){
                                int id = items.getJSONObject(i).getInt("id");
                                String title = items.getJSONObject(i).getString("title");
                                String genre = items.getJSONObject(i).getString("genre");
                                int attendance = items.getJSONObject(i).getInt("attendance");
                                String year = items.getJSONObject(i).getString("year");

                                int reply_cnt;
                                if(items.getJSONObject(i).isNull("reply_cnt")){
                                    reply_cnt = 0;
                                }else{
                                    reply_cnt = items.getJSONObject(i).getInt("reply_cnt");
                                }

                                Double avg_rating;
                                if(items.getJSONObject(i).isNull("avg_rating")){
                                    avg_rating = 0.0;
                                }else{
                                    avg_rating = items.getJSONObject(i).getDouble("avg_rating");
                                }

                                Movie movie = new Movie(id, title, genre, attendance,year,reply_cnt,avg_rating);
                                movieArrayList.add(movie);
                            }

                            adapter.notifyDataSetChanged();

                            // 페이징을 위해서 오프셋을 변경시켜놔야 한다.
                            offset = offset + response.getInt("cnt");
                            cnt = response.getInt("cnt");

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(request);
    }
}









