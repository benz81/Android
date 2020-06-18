package com.block.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.block.memo.adapter.RecyclerViewAdapter;
import com.block.memo.data.DatabaseHandler;
import com.block.memo.model.Memo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Memo> memoArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddMemo.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        DatabaseHandler dh = new DatabaseHandler(MainActivity.this);
        memoArrayList = dh.getAllMemo();
        // 어댑터를 연결해야지 화면에 표시가 됨.
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, memoArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}



