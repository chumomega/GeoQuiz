package com.example.sneakerquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sneakerquiz.adapters.QuizListAdapter;

import android.os.Bundle;

public class QuizResultsActivity extends AppCompatActivity {
    private QuizListAdapter quizListAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_results);
        this.quizListAdapter = new QuizListAdapter(new String[10]);
        this.recyclerView = findViewById(R.id.quiz_recycler_view);

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(this.quizListAdapter);
    }
}
