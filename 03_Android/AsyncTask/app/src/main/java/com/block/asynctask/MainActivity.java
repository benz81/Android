package com.block.asynctask;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        btn = findViewById(R.id.btn);

    }
    // 이미지를 네트워크 통해서 다운로드 하여, 화면에 표시할 쓰레드.
    // 쓰레드란? 동시에 여러가지 작업을 가능하게 해주는 것.
    // 이러한 쓰레드를, 사용하기 편하게, 안드로이드에서 제공해 주는 클래스가,
    // AsyncTask 어씽크 태스크
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap>{
        ProgressDialog progressDialog;
        Context context;
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            // 아래 doInBackground 함수 실행하기 전에, 해야할 일을, 여기에 작성.
        }
        @Override
        protected Bitmap doInBackground(String... strings) {
            // 오래걸리는 일이나, 동시 작업이 필요한 일은 이 함수 안에 작성.
            return null;
        }
        @Override
        protected void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            // 위의 doInBackground 함수가 다 실행되고 나서, 해야할 일을, 여기에 작성.
        }
    }
}









