package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParseQuizDaoImpl implements ParseDao {
    final int INDEX_QUESTION = 0;
    final int INDEX_ANSWER_FIRST = 2;
    final int INDEX_ANSWER_SECOND = 5;
    final int INDEX_ANSWER_THIRD = 8;
    Answer answerFirst;
    Answer answerSecond;
    Answer answerThird;
    ArrayList<Quiz> quizzes = new ArrayList<>();

    @Override
    public ArrayList<Quiz> parseFile() {
        List<String> lines = null;
        String[] columns;
        String url = "home_work1/src/main/resources/quiz.csv";
        try {
            lines = Files.readAllLines(Paths.get(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 6; i++) {
            columns = lines.get(i).split(";", 10);
            answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
            answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
            answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
        }
        return quizzes;
    }
}
