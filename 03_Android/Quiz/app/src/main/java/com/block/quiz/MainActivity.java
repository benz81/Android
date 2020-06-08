package com.block.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtQuestion;
    ProgressBar quizPB;
    TextView txtStats;
    Button btnTrue;
    Button btnFalse;

    QuizModel[] questionArray = new QuizModel[]{
            new QuizModel(R.string.q1, true), // [0]
            new QuizModel(R.string.q2, false), // [1]
            new QuizModel(R.string.q3, true),  // [2]
            new QuizModel(R.string.q4, false), // [3]
            new QuizModel(R.string.q5, true),  // [4]
            new QuizModel(R.string.q6, false),  // [5]
            new QuizModel(R.string.q7, true),  // [6]
            new QuizModel(R.string.q8, false),  // [7]
            new QuizModel(R.string.q9, true),  // [8]
            new QuizModel(R.string.q10, false)  // [9]
    };                                                    //  [12]

    int questionIndex = 0;
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtQuestion = findViewById(R.id.txtQuestion);
        quizPB = findViewById(R.id.quizPB);
        txtStats = findViewById(R.id.txtStats);
        btnTrue = findViewById(R.id.btnTrue);
        btnFalse = findViewById(R.id.btnFalse);

        // btnTrue 눌렀을때,
        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateUserAnswer(true);

                questionIndex = (questionIndex + 1 ) % 10 ;
                // 인덱스에는 10 이상은 올수가 없다.
                QuizModel q = questionArray[questionIndex];
                txtQuestion.setText(q.getmQuestion());
            }
        });
        // btnFalse 눌렀을때,
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                evaluateUserAnswer(false);

                questionIndex = (questionIndex + 1 ) % 10;
                QuizModel q = questionArray[questionIndex];
                txtQuestion.setText(q.getmQuestion());
            }
        });

        QuizModel q = questionArray[questionIndex];
        txtQuestion.setText(q.getmQuestion());
        txtStats.setText("점수는 : "+score);

    }
    // 유저의 대답을 체크하는 함수 : 토스트로 "정답입니다" , "오답입니다" 를 보여준다.
    void evaluateUserAnswer(boolean userAnswer){
        // 현재 문제의 정답을 가져오는 코드
        QuizModel q = questionArray[questionIndex];
        boolean answer = q.getAnswer();

        // 유저의 대답과, 현재 정답을 비교하여, 토스트 하는 코드
        if(userAnswer == answer){
            score = score + 1;
            Toast.makeText(MainActivity.this, "정답입니다.", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(MainActivity.this, "오답입니다.", Toast.LENGTH_SHORT).show();
        }
        txtStats.setText("점수는 : "+score);
        quizPB.incrementProgressBy(1);

    }


}








