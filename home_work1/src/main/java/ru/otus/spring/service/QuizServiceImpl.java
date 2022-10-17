package ru.otus.spring.service;

import ru.otus.spring.dao.QuizDao;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.Student;
import ru.otus.spring.domain.TypeResponse;

public class QuizServiceImpl implements QuizService {
    private final QuizDao daoQuiz;
    private final IOServiceTest test;
    Student student;
    private int wrongResponse = 0;
    private int rigtResponse = 0;

    public QuizServiceImpl(QuizDao daoQuiz, IOServiceTest test) {
        this.daoQuiz = daoQuiz;
        this.test = test;
    }

    // на то это и Spring, что все уже проинжекшено без тебя, не нужны больше дедовские методы внедрения зависимостей, главное правильно все собрать. Контекст.
    @Override
    public Quiz getById(int id) {
        return daoQuiz.findById(id);
    }

    public void testProvider() {
        System.out.println("Write you name: ");
        String name = test.readString();
        System.out.println("Write you surname: ");
        String surname = test.readString();

        student = new Student(name, surname);
        test.out("Dear  " + student.getName() + " " + student.getSurname() + ", please answer the following question: " + "\n");
        //как организовать цикл пока не закончаться все элементы массива?;
        int count  = daoQuiz.getCountList();
        for (int i = 0; i < count; i++) {
            test.out(this.getById(i).getQuestion());
            test.out("....................................\n This is variants of response:");
            String response1 = getById(i).getAnswerFirst().getResponse();
            String response2 = getById(i).getAnswerSecond().getResponse();
            String response3 = getById(i).getAnswerThird().getResponse();
            test.out(" 1) " + response1 + "\n 2) " + response2 + "\n 3) " + response3);
            test.out("Shoose number of response\"");
            int id = test.readIdQuiz();
            getAnswerList(this.getById(i), id);
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
//    private Answer[] getAnswerList(Quiz quiz, int id) {
//        Answer[] answerList = new Answer[3];
//        answerList[0] = quiz.getAnswerFirst();
//        answerList[1] = quiz.getAnswerSecond();
//        answerList[2] = quiz.getAnswerThird();
//        if (answerList[id - 1].getType().equals(TypeResponse.RIGHT)) {
//            System.out.println("this is right");
//            rigtResponse++;
//        } else {
//            System.out.println("it's wrong");
//            wrongResponse++;
//        }
//        return answerList;
//    }

//    }
