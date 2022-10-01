package ru.otus.spring.dao;

import ru.otus.spring.domain.Quiz;

public interface QuizDao {
    Quiz findById(int id);
}
