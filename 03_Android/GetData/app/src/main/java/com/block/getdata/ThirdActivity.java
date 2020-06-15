package com.block.getdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdActivity extends AppCompatActivity {

    TextView txtData;
    EditText editData;
    Button btnOK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        txtData = findViewById(R.id.txtData);
        editData = findViewById(R.id.editData);
        btnOK = findViewById(R.id.btnOK);

        // 인텐트에 담긴 정보를 가져와서, 텍스트뷰에 표시
        Intent i = getIntent();
        String data = i.getStringExtra("data");
        txtData.setText(data);

        // 버튼 누르면, 메인 액티비티로 정보를 전송하고, 이 액티비티는 종료
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String data = editData.getText().toString().trim();
                Intent i = getIntent();
                i.putExtra("data", data);
                setResult(RESULT_OK, i);
                finish();
            }
        });

    }
}






