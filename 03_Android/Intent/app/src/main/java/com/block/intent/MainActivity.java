package com.block.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        openWebPage("http://naver.com");

    }
    // 연락처 선택
    public void selectContact(){
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if( i.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(i, 1);
        }
    }

    public void composeMmsMessage(String message, Uri attachment){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("smsto:012-3455-4455"));
        i.putExtra("sms_body", message);
        i.putExtra(Intent.EXTRA_STREAM, attachment);
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }

    public void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW, webpage);
        if(i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }

}







