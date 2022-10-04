package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.dao.TestDao;
import ru.otus.spring.domain.Quiz;

import java.util.Scanner;

public class QuizServiceImpl implements QuizService {
    private final QuizDao daoQuiz;

    public QuizServiceImpl(QuizDao daoQuiz, TestDao daoTest) {
        this.daoQuiz = daoQuiz;
    }

    @Override
    public Quiz getById(int id) {
        return daoQuiz.findById(id);
    }

}