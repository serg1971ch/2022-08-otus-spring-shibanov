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

public class QuizSimpleDaoImpl implements QuizDao {
    ParseDao parse;
    ArrayList<Quiz> quizzesList = new ArrayList<>();

    public QuizSimpleDaoImpl(ParseDao parse) {
        this.parse = parse;
    }

    @Override
    public Quiz findById(int id) {
        quizzesList = parse.parseFile();
        return quizzesList.get(id);
    }
}
