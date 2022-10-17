package ru.otus.spring.dao;

import ru.otus.spring.domain.Quiz;

import java.util.ArrayList;

public interface QuizDao {
    Quiz findById(int id);
    int getCountList();
}
