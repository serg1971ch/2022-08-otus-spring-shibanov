package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuizSimpleDaoImpl implements QuizDao {
    String refSourseFile;
    final int INDEX_QUESTION = 0;
    final int INDEX_ANSWER_FIRST = 2;
    final int INDEX_ANSWER_SECOND = 5;
    final int INDEX_ANSWER_THIRD = 8;
    ArrayList<Quiz> quizzes = new ArrayList<>();

    public QuizSimpleDaoImpl(String refSourseFile) {
        this.refSourseFile = refSourseFile;
    }

    @Override
    public Quiz findById(int id) {
        quizzes = parseFile();
        return quizzes.get(id);
    }

    @Override
    public int getCountList() {
        return quizzes.size();
    }

//    @Override
//    public ArrayList<Quiz> getQuizList() {
//        return this.quizzes = quizzes;
//    }

    private ArrayList<Quiz> parseFile() {
        List<String> lines = null;
        String[] columns;
        String url = "C:\\Users\\ASUS\\Desktop\\otus\\2022-08-otus-spring-shibanov\\home_work1\\src\\main\\resources\\";
        try {
            lines = Files.readAllLines(Paths.get(url + refSourseFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < lines.size(); i++) {
            columns = lines.get(i).split(";", 10);
            Answer answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
            Answer answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
            Answer answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
        }
        return quizzes;
    }
}