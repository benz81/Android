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
    };

    int questionIndex = 0;



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
                questionIndex = questionIndex + 1;
                QuizModel q = questionArray[questionIndex];
                txtQuestion.setText(q.getmQuestion());
            }
        });
        // btnFalse 눌렀을때,
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                questionIndex = questionIndex + 1;
                QuizModel q = questionArray[questionIndex];
                txtQuestion.setText(q.getmQuestion());
            }
        });
        QuizModel q = questionArray[questionIndex];
        txtQuestion.setText(q.getmQuestion());

    }
}








