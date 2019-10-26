package com.example.sneakerquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    //use the package name to qualify your extra names to void collisions from other activities
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.sneakerquiz.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.example.sneakerquiz.answer_shown";
    private boolean answerIsTrue;

    private Button show_answer_button;
    private TextView answer_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        answerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        this.answer_text_view = findViewById(R.id.answer_text_view);

        this.show_answer_button = findViewById(R.id.show_answer_button);
        this.show_answer_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (answerIsTrue) {
                    answer_text_view.setText(R.string.true_button);
                } else {
                    answer_text_view.setText(R.string.false_button);
                }
                setAnswerShownResult(true);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    int cx = show_answer_button.getWidth() / 2;
                    int cy = show_answer_button.getHeight() / 2;
                    float radius = show_answer_button.getWidth();
                    Animator anim = ViewAnimationUtils.createCircularReveal(show_answer_button, cx, cy, radius, 0);
                    anim.addListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            super.onAnimationEnd(animation);
                            show_answer_button.setVisibility(View.INVISIBLE);
                        }
                    });
                    anim.start();
                }
                else {
                    show_answer_button.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void setAnswerShownResult(boolean isAnswerShown) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    public static boolean wasAnswerShown(Intent result) {
        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }
}
