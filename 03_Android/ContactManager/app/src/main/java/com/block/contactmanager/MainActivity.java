package com.block.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.block.contactmanager.data.DatabaseHandler;
import com.block.contactmanager.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 우리가 만든 데이터베이스 핸들러 클래스를, 객체 생성한다. => contacts 테이블이 생성된다.
        DatabaseHandler db = new DatabaseHandler(MainActivity.this);

        // 데이터 하나를 만들어서, 디비(테이블)에 저장해 보자.
//        Contact new_contact = new Contact();
//        new_contact.setName("Jeremy");
//        new_contact.setPhoneNumber("010-1234-5678");
//
//        db.addContact(new_contact);

        // 저장된 데이터를 읽어오는 코드.
        ArrayList<Contact> contactList = db.getAllContacts();
        for(Contact contact : contactList){
            Log.i("myDB", "저장된 주소록의 데이터 id : " + contact.getId() +
                    " 이름은 : " +contact.getName());
        }

    }
}










