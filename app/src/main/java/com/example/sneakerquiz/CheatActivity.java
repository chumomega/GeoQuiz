package com.example.sneakerquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    //use the package name to qualify your extra names to void collisions from other activities
    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.sneakerquiz.answer_is_true";
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
            }
        });
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent intent = new Intent(packageContext, CheatActivity.class);
        intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return intent;
    }
}
