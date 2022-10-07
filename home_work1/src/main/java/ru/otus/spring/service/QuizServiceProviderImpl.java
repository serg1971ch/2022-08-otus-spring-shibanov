package ru.otus.spring.service;

import ru.otus.spring.dao.TestDao;
import ru.otus.spring.domain.Quiz;

import java.util.Scanner;

public class QuizServiceProviderImpl implements TestDao, QuizServiceProvider {
    private final TestDao daoTest;
    private final QuizServiceProvider serviceProvider;
    String name;
    String surname;
    Scanner sc = new Scanner(System.in);

    public QuizServiceProviderImpl(TestDao daoTest, QuizServiceProvider serviceProvider) {
        this.daoTest = daoTest;
        this.serviceProvider = serviceProvider;
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
    public void printDao(String name, String surname, Quiz quiz) {
        name = getName();
        surname = getSurname();

        daoTest.printDao(name,surname,quiz);
    }

    @Override
    public void printResultTest(String name) {
        daoTest.printResultTest(name);
    }

    @Override
    public void getTest() {

        for (int i = 0; i < 5; i++) {
//            Quiz quiz = this.getById(i);
//            daoTest.printDao(name, surname, quiz);
        }
        daoTest.printResultTest(name);
    }
}
