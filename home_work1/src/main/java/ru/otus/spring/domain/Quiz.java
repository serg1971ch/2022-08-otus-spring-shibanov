package ru.otus.spring.domain;

import java.util.ArrayList;

public class Quiz {
    private int id_quiz;
    private String question;
    private Answer answerFirst;
    private Answer answerSecond;
    private Answer answerThird;

    public Quiz(int id_quiz, String question,
                Answer answerFirst, Answer answerSecond, Answer answerThird) {
        this.id_quiz = id_quiz;
        this.question = question;
        this.answerFirst = answerFirst;
        this.answerSecond = answerSecond;
        this.answerThird = answerThird;
    }

    public void setId_quiz(int id_quiz) {
        this.id_quiz = id_quiz;
    }

    public int getId_quiz() {
        return id_quiz;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestion() {
        return question;
    }

    public void setAnswerFirst(Answer answerFirst) {
        this.answerFirst = answerFirst;
    }

    public Answer getAnswerFirst() {
        return answerFirst;
    }

    public void setAnswerSecond(Answer answerSecond) {
        this.answerSecond = answerSecond;
    }

    public Answer getAnswerSecond() {
        return answerSecond;
    }

    public void setAnswerThird(Answer answerThird) {
        this.answerThird = answerThird;
    }

    public Answer getAnswerThird() {
        return answerThird;
    }
}
