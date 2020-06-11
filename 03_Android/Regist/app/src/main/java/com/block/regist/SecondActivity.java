package com.block.regist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    ImageView img;
    Button btnRabbit;
    Button btnTurtle;
    Button btnOK;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        img = findViewById(R.id.img);
        btnRabbit = findViewById(R.id.btnRabbit);
        btnTurtle = findViewById(R.id.btnTurtle);
        btnOK = findViewById(R.id.btnOK);

        btnRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.bunny);
            }
        });
        btnTurtle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                img.setImageResource(R.drawable.turtles);
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder finishAlert = new AlertDialog.Builder(SecondActivity.this);
                finishAlert.setTitle("회원가입 완료");
                finishAlert.setMessage("완료 하시겠습니까?");
                finishAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // todo 액티비티 새로 만들고 여기 코드 작성.
                        Intent i = new Intent(SecondActivity.this, WelcomeActivity.class);
                        startActivity(i);
                    }
                });
                finishAlert.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                finishAlert.setCancelable(false);
                finishAlert.show();
            }
        });


    }
}