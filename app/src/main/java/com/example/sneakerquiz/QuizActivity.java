package com.example.sneakerquiz;

import androidx.appcompat.app.AppCompatActivity;

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
    private static final String KEY_INDEX = "index";

    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private TextView mQuestionTextView;
    private int mCurrentIndex = 0;
    private int runningTotal = 0;

    private Question[] mQuestionBank = new Question[] {
        new Question(R.string.question_sneaker1, false),
        new Question(R.string.question_sneaker2, false),
        new Question(R.string.question_sneaker3, false),
        new Question(R.string.question_sneaker4, true),
        new Question(R.string.question_sneaker5, false),
        new Question(R.string.question_sneaker6, true),
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle) called");
        if (savedInstanceState != null) {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }
        setContentView(R.layout.activity_quiz);

        this.mQuestionTextView = findViewById(R.id.question_text_view);
        this.updateQuestion();

        this.mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNextQuestion();
            }
        });

        this.mTrueButton = findViewById(R.id.true_button);
        this.mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        this.mFalseButton = (Button) findViewById(R.id.false_button);
        this.mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });

        this.mNextButton = (ImageButton) findViewById(R.id.next_button);
        this.mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getNextQuestion();
            }
        });

    }

    private void getNextQuestion() {
        mCurrentIndex = mCurrentIndex + 1;

        if (mCurrentIndex > this.mQuestionBank.length - 1) {
            showScore();
        }
        else {
            updateQuestion();
            mTrueButton.setEnabled(true);
            mFalseButton.setEnabled(true);
        }
    }

    private void showScore() {
        double score = ((double) this.runningTotal / (double) this.mQuestionBank.length) * 100;
        String toastString = getString(R.string.quiz_complete, score);
        Toast toast = Toast.makeText(this, toastString, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG, "onSaveInstanceState");
        savedInstanceState.putInt(KEY_INDEX, mCurrentIndex);
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
        int question = mQuestionBank[mCurrentIndex].getTextResId();
        this.mQuestionTextView.setText(question);
    }

    private void checkAnswer(boolean userAnswer) {
        this.mTrueButton.setEnabled(false);
        this.mFalseButton.setEnabled(false);
        boolean answerIsTrue = mQuestionBank[mCurrentIndex].isAnswerTrue();

        int messageResId = 0;

        if (userAnswer == answerIsTrue) {
            messageResId = R.string.correct_toast;
            this.runningTotal++;
        }
        else {
            messageResId = R.string.incorrect_toast;
        }

        Toast toast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);
        toast.show();
    }
}
