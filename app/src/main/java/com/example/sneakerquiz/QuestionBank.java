package com.example.sneakerquiz;

public class QuestionBank {
    private Question[] questions;

    public static Question[] getQuestions() {
        return new Question[] {
            new Question(R.string.question_sneaker1, false),
            new Question(R.string.question_sneaker2, false),
            new Question(R.string.question_sneaker3, false),
            new Question(R.string.question_sneaker4, true),
            new Question(R.string.question_sneaker5, false),
            new Question(R.string.question_sneaker6, true),
        };
    }

}
