package com.block.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    String youtubeUrl = "https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyBbbw95I-YTfS09K3rNpff6rSGMFETyOhQ&maxResults=20&order=date&type=video&type=video&q=벤츠";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 발리 라이브러리 이용해서, 호출
        // 로그 찍어본다.
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                Request.Method.GET,
                youtubeUrl,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("AAA", response.toString());
                        try {
                            JSONArray items = response.getJSONArray("items");
                            for(int i = 0; i < items.length(); i++){
                                JSONObject jsonObject = items.getJSONObject(i);
                                JSONObject id = jsonObject.getJSONObject("id");
                                String videoId = id.getString("videoId");
                                JSONObject snippet = jsonObject.getJSONObject("snippet");
                                String title = snippet.getString("title");
                                String desc = snippet.getString("description");
                                JSONObject thumbnails = snippet.getJSONObject("thumbnails");
                                JSONObject def = thumbnails.getJSONObject("default");
                                String url = def.getString("url");

                                Log.i("AAA", videoId +","+title+", "+desc+", "+url);
                            }

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
        requestQueue.add(jsonObjectRequest);

    }
}