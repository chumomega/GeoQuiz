package com.example.sneakerquiz.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sneakerquiz.R;

public class QuizListAdapter extends RecyclerView.Adapter<QuizListAdapter.QuizListViewHolder> {
    private String[] questions;

    public QuizListAdapter(String[] questions) {
        //TODO - check array to make sure non null and whatever other checks
        this.questions = questions;
    }

    @NonNull
    @Override
    public QuizListAdapter.QuizListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //we need to inflate a view
        View view = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.question, parent, false);
        return new QuizListViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return this.questions.length;
    };

    @Override
    public void onBindViewHolder(@NonNull QuizListViewHolder holder, int position) {

    }

    protected class QuizListViewHolder extends RecyclerView.ViewHolder {

        protected QuizListViewHolder(@NonNull View itemView) {
            super(itemView);
        }

    }

}
