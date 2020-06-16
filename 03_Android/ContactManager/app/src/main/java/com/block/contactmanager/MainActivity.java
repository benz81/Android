package com.block.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.block.contactmanager.data.DatabaseHandler;
import com.block.contactmanager.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
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












