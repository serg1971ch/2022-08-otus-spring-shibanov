package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;
import ru.otus.spring.service.QuizServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuizServiceImpl quizServiceImpl = context.getBean("quizServiceImpl", QuizServiceImpl.class);
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your name:  ");
        String name = String.valueOf(sc.nextLine());
        System.out.println("Write your surname:  ");
        String surname = String.valueOf(sc.nextLine());
        for (int i = 0; i < 5; i++) {
            Quiz quiz = quizServiceImpl.findById(i);
            QuizSimpleDaoImpl.printDao(name, surname, quiz);
        }
        QuizSimpleDaoImpl.printResult(name);
    }
}


