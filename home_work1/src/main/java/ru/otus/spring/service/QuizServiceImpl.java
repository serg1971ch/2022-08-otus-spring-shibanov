package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.dao.TestDao;
import ru.otus.spring.domain.Quiz;

import java.util.Scanner;

public class QuizServiceImpl implements QuizDao {
    final private QuizDao daoQuiz;
    final private TestDao daoTest;


    public QuizServiceImpl(QuizDao daoQuiz, TestDao daoTest) {
        this.daoQuiz = daoQuiz;
        this.daoTest = daoTest;
    }

    @Override
    public Quiz findById(int id) {
        return daoQuiz.findById(id);
    }

}
