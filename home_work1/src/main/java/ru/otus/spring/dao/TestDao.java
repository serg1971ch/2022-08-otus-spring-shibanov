package ru.otus.spring.dao;

import ru.otus.spring.domain.Quiz;

public interface TestDao {
    void printDao(String name, String surname, Quiz quiz);
    void printResultTest(String name);
}
