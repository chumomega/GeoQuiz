package com.example.sneakerquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {

    private static final String TAG = "QuizActivity";
//    private static final String KEY_INDEX = "index";
//    private static final int REQUEST_CODE_CHEAT = 0;
//
//    private Button mTrueButton;
//    private Button mFalseButton;
//    private Button mNextButton;
//    private Button cheatButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
//    private int runningTotal = 0;
//    private boolean isCheater;
//    private int numCheats = 0;

    private Question[] mQuestionBank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mQuestionBank = QuestionBank.getQuestions();
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        setContentView(R.layout.activity_quiz);

        //get the question view
//        this.mQuestionTextView = findViewById(R.id.question_text_view);
//        this.updateQuestion();
//
//        this.mQuestionTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getNextQuestion();
//            }
//        });
//
//        this.mTrueButton = findViewById(R.id.true_button);
//        this.mTrueButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkAnswer(true);
//            }
//        });
//
//        this.mFalseButton = (Button) findViewById(R.id.false_button);
//        this.mFalseButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                checkAnswer(false);
//            }
//        });
//
//        this.mNextButton = (Button) findViewById(R.id.next_button);
//        this.mNextButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                getNextQuestion();
//            }
//        });

    }

    private void getNextQuestion() {
//        mCurrentIndex = mCurrentIndex + 1;
//
//        if (mCurrentIndex > this.mQuestionBank.length - 1) {
//            showScore();
//        }
//        else {
//            updateQuestion();
//            mTrueButton.setEnabled(true);
//            mFalseButton.setEnabled(true);
//        }
//        this.isCheater = false;
    }

//    private void showScore() {
//        double score = ((double) this.runningTotal / (double) this.mQuestionBank.length) * 100;
//        String toastString = getString(R.string.quiz_complete, score);
//        Toast toast = Toast.makeText(this, toastString, Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.TOP, 0, 0);
//        toast.show();
//        //open questions activity
//        Intent intent = new Intent(this, QuizResultsActivity.class);
//        startActivity(intent);
//
//    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
//        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    private void updateQuestion() {
//        int question = mQuestionBank[mCurrentIndex].getTextResId();
//        this.mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userAnswer) {
//        this.mTrueButton.setEnabled(false);
//        this.mFalseButton.setEnabled(false);
//        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();
//
//        int messageResId = 0;
//
//        if (isCheater) {
//            messageResId = R.string.judgement_toast;
//        }
//        else if (userAnswer == answerIsTrue) {
//            messageResId = R.string.correct_toast;
//            this.runningTotal++;
//        }
//        else {
//            messageResId = R.string.incorrect_toast;
//        }
//
//        Toast toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.TOP, 0, 0);
//        toast.show();
    }
}
