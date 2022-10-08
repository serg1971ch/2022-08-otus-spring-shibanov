package ru.otus.spring.service;

import ru.otus.spring.domain.Quiz;

public interface TestService {
    void printDao(String name, String surname, Quiz quiz);
    void printResultTest(String name);
}
