package ru.otus.spring.service;

import ru.otus.spring.domain.Student;

import java.io.PrintStream;
import java.util.Scanner;

import static java.lang.System.out;

public class IOServiceTestImpl implements IOServiceTest{
    private final Scanner sc = new Scanner(System.in);

    @Override
    public void out(String message) {
        out.println(message);
    }

    @Override
    public String readString() {
        return sc.nextLine();
    }

    @Override
    public int readIdQuiz() {
        return sc.nextInt();
    }

//    public void poll() {
//        ioServiceTest.out("start");
//
//        ioServiceTest.out("what is your name?");
//        String name = ioServiceTest.readString();
//        ioServiceTest.out(String.format("nice to meet you:%s, name"));
//        ioServiceTest.out("How are you? If it's all right\"OK\"");
//        String res = ioServiceTest.readString();
//        if (res.equalsIgnoreCase("OK")) {
//            ioServiceTest.out("Great!");
//        } else {
//            ioServiceTest.out("It's will be all right");
//        }
//        ioServiceTest.out(String.format("Goodby%s", name));
//    }


//    @Override
//    public void printDao(String name, String surname, Quiz quiz) {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("\n ===================================================");
//        System.out.println("Dear  " + name + " " + surname + ", please answer the following question: " + "\n");
//        System.out.println(quiz.getQuestion());
//        System.out.println(".....................................");
//        System.out.println("This is variants of response:");
//        System.out.println(".....................................");
//        String response1 = quiz.getAnswerFirst().getResponse();
//        String response2 = quiz.getAnswerSecond().getResponse();
//        String response3 = quiz.getAnswerThird().getResponse();
//        System.out.println("1) " + response1);
//        System.out.println("2) " + response2);
//        System.out.println("3) " + response3);
//        System.out.println("Shoose number of response");
//        int id = sc.nextInt();
//        while (true) {
//            if (id > 3 || id == 0) {
//                System.out.println("Write a correct number from 1 to 3");
//                id = sc.nextInt();
//            } else {
//                break;
//            }
//        }
//        getAnswerList(quiz, id);
//    }
//

//
//    @Override
//    public void printResultTest(String name) {
//        System.out.println("\n ===================================================");
//        System.out.println("Dear " + name + ", you are right in - " + rigtResponse + " times" + " and wrong in - " + wrongResponse + " times");
//        if (rigtResponse > wrongResponse) {
//            System.out.println("\n ===================================================");
//            System.out.println("Well done!, " + name + ",  you know the history of the Russian gas industry very well!");
//        } else {
//            System.out.println("\n ===================================================");
//            System.out.println("Don't worry, " + name + ", it is few people know this...");
//        }
//    }
//    @Override
//    public void getTest() {
//        name = getName();
//        surname = getSurname();
//        for (int i = 0; i < 5; i++) {
//            Quiz quiz = this.getById(i);
//            serviceTest.printDao(name, surname, quiz);
//        }
//        serviceTest.printResultTest(name);
//    }
}
