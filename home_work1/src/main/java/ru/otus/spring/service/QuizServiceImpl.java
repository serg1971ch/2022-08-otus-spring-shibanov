package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.dao.TestDao;
import ru.otus.spring.domain.Quiz;

import java.util.Scanner;

public class QuizServiceImpl implements QuizDao {
    final private QuizDao daoQuiz;
    final private TestDao daoTest;
    String name;
    String surname;
    Scanner sc = new Scanner(System.in);

    public QuizServiceImpl(QuizDao daoQuiz, TestDao daoTest) {
        this.daoQuiz = daoQuiz;
        this.daoTest = daoTest;
    }

    @Override
    public Quiz findById(int id) {
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

    public void getTest() {
        for (int i = 0; i < 5; i++) {
            Quiz quiz = this.findById(i);
            name = getName();
            surname = getSurname();
            daoTest.printDao(name, surname, quiz);
        }
        daoTest.printResultTest(name);
    }
}
