package ru.otus.spring.dao;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class QuizSimpleDaoImpl implements QuizDao {
    String refSourseFile;
    final static int INDEX_QUESTION = 0;
    final static int INDEX_ANSWER_FIRST = 2;
    final static int INDEX_ANSWER_SECOND = 5;
    final static int INDEX_ANSWER_THIRD = 8;
    ArrayList<Quiz> quizzes = new ArrayList<>();

    public QuizSimpleDaoImpl(String refSourseFile) {
        this.refSourseFile = refSourseFile;
    }

    @Override
    public Quiz findById(int id) {
        quizzes = parseFile();
        return quizzes.get(id);
    }

    private ArrayList<Quiz> parseFile() {
        List<String> lines = null;
        String[] columns;
        String url = "home_work1/src/main/resources/";
        try {
            lines = Files.readAllLines(Paths.get(url + refSourseFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 1; i < 6; i++) {
            columns = lines.get(i).split(";", 10);
            Answer answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
            Answer answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
            Answer answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
        }
        return quizzes;
    }
//    @Override
//    public Quiz findById(int id) {
//        ArrayList<Quiz> quizzes = null;
//        try (BufferedReader br = Files.newBufferedReader(Paths.get("home_work1/src/resource/" + filename))) {
//        try( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(refSourseFile), StandardCharsets.UTF_8))){
//            String DELIMITER = ";";
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] columns = line.split(DELIMITER);
//                System.out.println("quiz[" + String.join(", ", columns) + "]");
//                getListQuizes(quizzes, columns);
//                this.getListQuiz(columns, quizzes);
//            }
//        } catch (IOException ex) {
//            ex.printStackTrace();
//        }
//        return quizzes.get(id);
//    }

//    private void getListQuizes(ArrayList<Quiz> quizzes, String[] columns) {
//        answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
//        answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
//        answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
//        quizzes.add(new Quiz(1, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
//    }
}
