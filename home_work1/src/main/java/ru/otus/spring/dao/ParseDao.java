package ru.otus.spring.dao;

import ru.otus.spring.domain.Quiz;

import java.util.ArrayList;

public interface ParseDao {
    ArrayList<Quiz> parseFile();
}
