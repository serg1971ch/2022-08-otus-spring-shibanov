package ru.otus.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;
import ru.otus.spring.service.QuizService;
import ru.otus.spring.service.QuizServiceImpl;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        QuizService quizService = context.getBean(QuizService.class);
        quizService.getTest();
    }
}


