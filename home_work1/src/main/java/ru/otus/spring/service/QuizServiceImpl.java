package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.dao.TestDao;
import ru.otus.spring.domain.Quiz;

import java.util.Scanner;

public class QuizServiceImpl implements QuizService {
    private final QuizDao daoQuiz;
    private final TestDao daoTest;
    String name;
    String surname;
    Scanner sc = new Scanner(System.in);

    public QuizServiceImpl(QuizDao daoQuiz, TestDao daoTest) {
        this.daoQuiz = daoQuiz;
        this.daoTest = daoTest;
    }

    @Override
    public Quiz getById(int id) {
        return daoQuiz.findById(id);
    }

    private String getName() {
        System.out.println("Write your name:  ");
        return String.valueOf(sc.nextLine());
    }

    private String getSurname() {
        System.out.println("Write your surname:  ");
        return String.valueOf(sc.nextLine());
    }

    @Override
    public void getTest() {
        name = getName();
        surname = getSurname();
        for (int i = 0; i < 5; i++) {
            Quiz quiz = this.getById(i);
            daoTest.printDao(name, surname, quiz);
        }
        daoTest.printResultTest(name);
    }
}
