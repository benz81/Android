package com.block.regist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    EditText editEmail;
    EditText editPasswd;
    Button btnLogin;

    String savedEmail;
    String savedPassed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editEmail = findViewById(R.id.editEmail);
        editPasswd = findViewById(R.id.editPasswd);
        btnLogin = findViewById(R.id.btnLogin);

        SharedPreferences sp = getSharedPreferences("regist_pref", MODE_PRIVATE);
        savedEmail = sp.getString("email", null);
        savedPassed = sp.getString("passwd", null);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 에디트 텍스트에 유저가 입력한 이메일과 비번을 가져와서
                // 쉐어드프리퍼런스에 저장되어 있던, 저장된 이메일과 비번을 서로 비교.

            }
        });

    }
}





