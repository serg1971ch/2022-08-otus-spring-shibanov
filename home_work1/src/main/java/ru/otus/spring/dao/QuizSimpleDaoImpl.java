package ru.otus.spring.dao;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class QuizSimpleDaoImpl implements QuizDao {
    String refSourseFile;
    Answer answerFirst;
    Answer answerSecond;
    Answer answerThird;
    final static int INDEX_QUESTION = 0;
    final static int INDEX_ANSWER_FIRST = 2;
    final static int INDEX_ANSWER_SECOND = 5;
    final static int INDEX_ANSWER_THIRD = 8;
//    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//    DocumentBuilder db;
//
//    {
//        try {
//            db = dbf.newDocumentBuilder();
//        } catch (ParserConfigurationException e) {
//            e.printStackTrace();
//        }
//    }
//
//    Document doc;
//
//    {
//        try {
//            doc = db.parse(new File(refSourseFile));
//        } catch (SAXException | IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    NodeList nameFile = doc.getElementsByTagName("name");
//    Node node = nameFile.item(0);
//    String filename = node.getTextContent();

    private void getListQuiz(String[] columns, ArrayList<Quiz> quizzes) {
//        for (int i = 1; i < 6; i++) {
//            columns = lines.get(i).split(";", 10)
        getListQuizes(quizzes, columns);
//        }
    }

    public QuizSimpleDaoImpl (String refSourseFile) {
        this.refSourseFile = refSourseFile;
    }

    @Override
    public Quiz findById(int id) {
        ArrayList<Quiz> quizzes = null;
//        try (BufferedReader br = Files.newBufferedReader(Paths.get("home_work1/src/resource/" + filename))) {
        try( BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(refSourseFile), StandardCharsets.UTF_8))){
            String DELIMITER = ";";
            String line;
            while ((line = reader.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                System.out.println("quiz[" + String.join(", ", columns) + "]");
                getListQuizes(quizzes, columns);
                this.getListQuiz(columns, quizzes);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return quizzes.get(id);
    }

    private void getListQuizes(ArrayList<Quiz> quizzes, String[] columns) {
        answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
        answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
        answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
        quizzes.add(new Quiz(1, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
    }
}
