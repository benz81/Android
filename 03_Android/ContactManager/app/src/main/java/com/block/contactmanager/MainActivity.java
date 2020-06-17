package com.block.contactmanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.block.contactmanager.adapter.RecyclerViewAdapter;
import com.block.contactmanager.data.DatabaseHandler;
import com.block.contactmanager.model.Contact;

import java.time.chrono.MinguoChronology;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    RecyclerView recyclerView;  // 메인 화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;    // 우리가 만든, 하나의 셀을 연결시키는 어댑터
    ArrayList<Contact> contactArrayList;    // 데이터베이스에서 읽어온 주소록 정보를 저장할 리스트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        // 리사이클러뷰 연결하고, 기본적인 셋팅.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // 데이터베이스에서 테이블에 저장된 데이터 읽어서, 어레이리스트에 저장
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        contactArrayList = db.getAllContacts();

        // 우리가만든 하나의 셀 표시하는 어댑터를 생성해서, 리사이클러뷰에 연결
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, contactArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 액티비티 실행.
                Intent i = new Intent(MainActivity.this, AddContact.class);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        // 우리가 만든 데이터베이스 핸들러 클래스를, 객체 생성한다. => contacts 테이블이 생성된다.
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);
        // 저장된 데이터를 읽어오는 코드.
        ArrayList<Contact> contactList = db.getAllContacts();
        for(Contact contact : contactList){
            Log.i("myDB", "저장된 주소록의 데이터 id : " + contact.getId() +
                    " 이름은 : " +contact.getName());
        }
    }
}












