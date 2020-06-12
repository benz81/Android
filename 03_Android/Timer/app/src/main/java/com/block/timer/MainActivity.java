package com.block.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

public class MainActivity extends AppCompatActivity {

    ImageView imgTimer;
    TextView txtSec;
    EditText editSec;
    Button btnCancel;
    Button btnStart;

    CountDownTimer timer;
    int sec;
    long millisec;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgTimer = findViewById(R.id.imgTimer);
        txtSec = findViewById(R.id.txtSec);
        editSec = findViewById(R.id.editSec);
        btnCancel = findViewById(R.id.btnCancel);
        btnStart = findViewById(R.id.btnStart);

        mp = MediaPlayer.create(this, R.raw.alarm);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String secStr = editSec.getText().toString().trim();
                sec = Integer.parseInt(secStr);
                millisec = (long)sec * 1000;
                timer = new CountDownTimer(millisec, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Log.i("MyTimer", " "  + millisUntilFinished);
                        int remainingTime = (int)millisUntilFinished / 1000;
                        txtSec.setText(""+remainingTime);
                    }

                    @Override
                    public void onFinish() {
                        // 타이머 완료시, 소리와 에니메이션
                        mp.start();
                        YoYo.with(Techniques.Shake)
                                .duration(300)
                                .repeat(3)
                                .playOn(imgTimer);
                    }
                };
                timer.start();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                txtSec.setText(""+sec);
            }
        });


    }
}