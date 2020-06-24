package com.block.customalert;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.block.customalert.adapter.RecyclerViewAdapter;
import com.block.customalert.model.Post;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    public static final String URL = "https://jsonplaceholder.typicode.com/posts";

    ArrayList<Post> postArrayList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    EditText editTitle;
    EditText editBody;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        recyclerView = findViewById(R.id.recycylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        // 그리드레이아웃 매니저를 이용하면, 하나의 행에, 여러개의 셀을 표시할 수 있다.
//        recyclerView.setLayoutManager(
//                new GridLayoutManager(MainActivity.this, 3));

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("AAA", response.toString());

                        for(int i = 0; i < response.length(); i ++){
                            try {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int userId = jsonObject.getInt("userId");
                                int id = jsonObject.getInt("id");
                                String title = jsonObject.getString("title");
                                String body = jsonObject.getString("body");

                                Post post = new Post(userId, id, title, body);
                                postArrayList.add(post);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        // 리스트에 데이터가 모두 다 들어간 후,
                        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, postArrayList);
                        recyclerView.setAdapter(recyclerViewAdapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_add) {
            Intent i = new Intent(MainActivity.this, AddPosting.class);
            //startActivity(i);
            startActivityForResult(i, 0);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void createPopupDialog(){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View alertView = getLayoutInflater().inflate(R.layout.add_alert,null);

        editTitle = alertView.findViewById(R.id.editTitle);
        editBody = alertView.findViewById(R.id.editBody);

        alert.setView(alertView);
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = editTitle.getText().toString().trim();
                String body = editBody.getText().toString().trim();

                if(title.isEmpty() || body.isEmpty()){
                    Toast.makeText(MainActivity.this,
                            "글자를 꼭 입력하셔야 합니다.", Toast.LENGTH_SHORT).show();
                    return;
                }

                Post post = new Post(1, 1, title, body);
                postArrayList.add(post);
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, postArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });
        alert.setNegativeButton("NO", null);

        alert.setCancelable(false);

        dialog = alert.create();
        dialog.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0 && resultCode == RESULT_OK){
            Post post = (Post) data.getSerializableExtra("PostClass");

            postArrayList.add(post);

            recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, postArrayList);
            recyclerView.setAdapter(recyclerViewAdapter);

        }

    }
}






