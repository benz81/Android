package com.block.youtube;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String youtubeUrl = "https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyBbbw95I-YTfS09K3rNpff6rSGMFETyOhQ&maxResults=20&order=date&type=video";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 발리 라이브러리 이용해서, 호출
        // 로그 찍어본다.
        

    }
}