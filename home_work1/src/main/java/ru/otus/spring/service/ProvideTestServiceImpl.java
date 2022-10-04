package ru.otus.spring.service;

import ru.otus.spring.dao.TestDao;
import ru.otus.spring.domain.Quiz;

import java.util.Scanner;

public class ProvideTestServiceImpl implements ProvideTestService{
    private final TestDao daoTest;
    private final QuizServiceImpl quizService;
    String name;
    String surname;
    Scanner sc = new Scanner(System.in);

    public ProvideTestServiceImpl(TestDao daoTest, QuizServiceImpl  quizService) {
        this.daoTest = daoTest;
        this.quizService = quizService;
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
            Quiz quiz = quizService.getById(i);
            daoTest.printDao(name, surname, quiz);
        }
        daoTest.printResultTest(name);
    }
}
