package com.test.places;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.test.places.adapter.RecyclerViewAdapter;
import com.test.places.model.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editSearch;
    Button btnSearch;
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    ArrayList<Store> storeArrayList = new ArrayList<>();

    RequestQueue requestQueue;
    String baseUrl = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?language=ko&radius=20000";
    String key = "&key=AIzaSyD3KC2ug6UrcFciDoqR8LrWd98rn59mit0";

    // GPS 좌표 가져오기 위한 LocationManager 멤버변수 선언.
    LocationManager locationManager;
    // 위치가 변경될 때마다, 처리해줄 리스너 멤버변수로 선언.
    LocationListener locationListener;

    String nextPageToken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editSearch = findViewById(R.id.editSearch);
        btnSearch = findViewById(R.id.btnSearch);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        // 위치기반 서비스를 위해서, 안드로이드 시스템에 위치기반서비스 요청.
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(@NonNull Location location) {
                  Log.i("AAA", location.toString());
                  double lat = location.getLatitude();
                  double lng = location.getLongitude();
                  // 네트워크로 구글 플레이스 api 호출.
                getNetworkData(lat, lng);
            }
        };

    }

    void getNetworkData(double lat, double lng) {
        StringRequest request = new StringRequest(
                Request.Method.GET,
                baseUrl + key,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            // Exception : 실행도중에 문제가 발생할 경우, catch 에서 처리할 수 있도록
                            JSONObject jsonObject = new JSONObject(response);
                            nextPageToken = jsonObject.getString("next_page_token");
                            JSONArray results = jsonObject.getJSONArray("results");
                            for(int i = 0; i < results.length(); i++){
                                JSONObject item = results.getJSONObject(i);
                                JSONObject geometry = item.getJSONObject("geometry");
                                JSONObject location = geometry.getJSONObject("location");
                                double storeLat = location.getDouble("lat");
                                double storeLng = location.getDouble("lng");
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
    }
}