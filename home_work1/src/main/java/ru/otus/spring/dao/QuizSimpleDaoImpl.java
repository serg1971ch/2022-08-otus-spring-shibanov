package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizSimpleDaoImpl implements QuizDao {
    final int INDEX_QUESTION = 0;
    final int INDEX_ANSWER_FIRST = 2;
    final int INDEX_ANSWER_SECOND = 5;
    final int INDEX_ANSWER_THIRD = 8;
    private static int wrongResponse = 0;
    private static int rigtResponse = 0;
    Answer answerFirst;
    Answer answerSecond;
    Answer answerThird;
    ArrayList<Quiz> quizzes = new ArrayList<>();

    @Override
    public Quiz findById(int id) {
        quizzes = parseFile();
        return quizzes.get(id);
    }

    private ArrayList<Quiz> parseFile() {
        List<String> lines = null;
        String[] columns;
        String url = "C:\\Users\\ASUS\\Desktop\\quiz_dz\\src\\main\\resources\\quiz.csv";
        try {
            lines = Files.readAllLines(Paths.get(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 6; i++) {
            columns = lines.get(i).split(";", 10);
            answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
            answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
            answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
        }
        return quizzes;
    }

    public static void printDao(String name, String surname, Quiz quiz) {
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

    public static void printResult(String name) {
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
