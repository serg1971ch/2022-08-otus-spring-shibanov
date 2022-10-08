package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;
import ru.otus.spring.service.ParseCSVFileServiceimp;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizSimpleDaoImpl implements QuizDao {
    ParseCSVFileServiceimp parse;
    ArrayList<Quiz> quizzesList = new ArrayList<>();

    public QuizSimpleDaoImpl(ParseCSVFileServiceimp parse) {
        this.parse = parse;
    }

    @Override
    public Quiz findById(int id) {
        return quizzesList.get(id);
    }
}
