package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.Student;
import ru.otus.spring.domain.TypeResponse;

import java.util.ArrayList;

public class QuizServiceImpl implements QuizService {
    private final QuizDao daoQuiz;
    private final IOServiceTest test;
    Student student;
    ArrayList<Quiz> serviceQuizezez;
    private int wrongResponse = 0;
    private int rigtResponse = 0;

    public QuizServiceImpl(QuizDao daoQuiz, IOServiceTest test) {
        this.daoQuiz = daoQuiz;
        this.test = test;
    }

    public void testProvider() {
        System.out.println("Write you name: ");
        String name = test.readString();
        System.out.println("Write you surname: ");
        String surname = test.readString();

        student = new Student(name, surname);
        test.out("Dear,  " + student.getName() + " " + student.getSurname() + ", please answer the following question: " + "\n");
        serviceQuizezez = daoQuiz.getQuizList();
        for (int i = 0; i < serviceQuizezez.size(); i++) {
            Quiz serviceQuizez = serviceQuizezez.get(i);
            test.out(serviceQuizez.getQuestion());
            test.out("....................................\n This is variants of response:");
            String response1 = serviceQuizez.getAnswerFirst().getResponse();
            String response2 = serviceQuizez.getAnswerSecond().getResponse();
            String response3 = serviceQuizez.getAnswerThird().getResponse();
            test.out(" 1) " + response1 + "\n 2) " + response2 + "\n 3) " + response3);
            test.out("Shoose number of response\"");
            int id = test.readIdQuiz();
            getAnswerList(serviceQuizez, id);
            test.out("======================================================");
        }
        System.out.println("You are right in " + rigtResponse + " times and you are wrong in " + wrongResponse + " times.");
    }

        private void getAnswerList (Quiz quiz, int id){
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
        }
    }
