package com.block.fingerspeed;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtTimer;
    TextView txtCount;
    Button btnTap;
    // 타이머 멤버변수
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtTimer = findViewById(R.id.txtTimer);
        txtCount = findViewById(R.id.txtCount);
        btnTap = findViewById(R.id.btnTap);
        btnTap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        countDownTimer = new CountDownTimer(60000 ,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int remainingTime = (int)millisUntilFinished / 1000;
                Log.i("Finger", "남은 시간 : " + remainingTime);
                txtTimer.setText(""+remainingTime);
            }
            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this, "시간이 종료되었습니다.",
                        Toast.LENGTH_LONG).show();
            }
        };
        countDownTimer.start();
    }
}





