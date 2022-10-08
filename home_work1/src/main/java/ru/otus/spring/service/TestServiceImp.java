package ru.otus.spring.service;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import java.util.Scanner;

public class TestServiceImp implements TestService{
    private int wrongResponse = 0;
    private int rigtResponse = 0;

    @Override
    public void printDao(String name, String surname, Quiz quiz) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n ===================================================");
        System.out.println("Dear  " + name + " " + surname + ", please answer the following question: " + "\n");
        System.out.println(quiz.getQuestion());
        System.out.println(".....................................");
        System.out.println("This is variants of response:");
        System.out.println(".....................................");
        String response1 = quiz.getAnswerFirst().getResponse();
        String response2 = quiz.getAnswerSecond().getResponse();
        String response3 = quiz.getAnswerThird().getResponse();
        System.out.println("1) " + response1);
        System.out.println("2) " + response2);
        System.out.println("3) " + response3);
        System.out.println("Shoose number of response");
        int id = sc.nextInt();
        while (true) {
            if (id > 3 || id == 0) {
                System.out.println("Write a correct number from 1 to 3");
                id = sc.nextInt();
            } else {
                break;
            }
        }
        getAnswerList(quiz, id);
    }

    private Answer[] getAnswerList(Quiz quiz, int id) {
        Answer[] answerList = new Answer[3];
        answerList[0] = quiz.getAnswerFirst();
        answerList[1] = quiz.getAnswerSecond();
        answerList[2] = quiz.getAnswerThird();
        if (answerList[id - 1].getType().equals(TypeResponse.RIGHT)) {
            System.out.println("this is right");
            rigtResponse++;
        } else {
            System.out.println("it's wrong");
            wrongResponse++;
        }
        return answerList;
    }

    @Override
    public void printResultTest(String name) {
        System.out.println("\n ===================================================");
        System.out.println("Dear " + name + ", you are right in - " + rigtResponse + " times" + " and wrong in - " + wrongResponse + " times");
        if (rigtResponse > wrongResponse) {
            System.out.println("\n ===================================================");
            System.out.println("Well done!, " + name + ",  you know the history of the Russian gas industry very well!");
        } else {
            System.out.println("\n ===================================================");
            System.out.println("Don't worry, " + name + ", it is few people know this...");
        }
    }
}
