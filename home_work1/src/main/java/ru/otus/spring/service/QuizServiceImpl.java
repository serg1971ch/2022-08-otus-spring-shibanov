package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.domain.Quiz;

public class QuizServiceImpl implements QuizDao {
    final private QuizSimpleDaoImpl dao;

    public QuizServiceImpl(QuizSimpleDaoImpl dao) {
        this.dao = dao;
    }

    @Override
    public Quiz findById(int id) {
        return dao.findById(id);
    }
}
