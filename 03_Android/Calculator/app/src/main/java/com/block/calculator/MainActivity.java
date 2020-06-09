package com.block.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editPercent;
    EditText editNumber;
    Button btnCal;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPercent = findViewById(R.id.editPercent);
        editNumber = findViewById(R.id.editNumber);
        btnCal = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.txtResult);

        // 유저가 버튼을 누르면, editPercent 와 editNumber 에서 숫자 가져와서
        // 공식에 따라 계산하고,
        // txtResult 텍스트뷰에 표시한다.
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String percent = editPercent.getText().toString();
                String number = editNumber.getText().toString();
                Log.i("MyCal", "유저가 입력한 값 : " + percent + ", " + number);

                if(percent.isEmpty() || number.isEmpty()){
                    Toast.makeText(MainActivity.this, "둘다 숫자를 입력하시오.",
                            Toast.LENGTH_SHORT).show();
                    return;
                }

                // number * percent / 100 ; 계산하려는데, 계산이 안된다. 그래서
                // 아래처럼 문자열을 플롯으로 바꿔줘야 한다.

                float myPercent = Float.parseFloat(percent);
                float myNumber = Float.parseFloat(number);
                float result = myNumber * myPercent / 100f;

                Log.i("MyCal", "계산 결과는 : " + result);

                txtResult.setText(""+result);

            }
        });


    }
}
