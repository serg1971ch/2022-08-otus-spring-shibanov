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
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Objects;

public class QuizSimpleDaoImpl implements QuizDao {
    String refSourseFile = "src/main/resources/nameFileCsv.xml";
    static int i = 1;
    final static int INDEX_QUESTION = 0;
    final static int INDEX_ANSWER_FIRST = 2;
    final static int INDEX_ANSWER_SECOND = 5;
    final static int INDEX_ANSWER_THIRD = 8;
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File(refSourseFile));

    NodeList nameFile = doc.getElementsByTagName("name");
    Node node = nameFile.item(0);
    String filename = node.getTextContent();

    public QuizSimpleDaoImpl() throws ParserConfigurationException, IOException, SAXException {
    }

    private void getListQuiz(String[] columns, ArrayList<Quiz> quizzes) {
        for (int i = 1; i < 6; i++) {
//            columns = lines.get(i).split(";", 10)
            Answer answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
            Answer answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
            Answer answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
        }
    }

    @Override
    public Quiz findById(int id) {
        ArrayList<Quiz> quizzes = null;
        try (BufferedReader br = Files.newBufferedReader(Paths.get("home_work1/src/resource/" + filename))) {
            String DELIMITER = ";";
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                System.out.println("quiz[" + String.join(", ", columns) + "]");
                this.getListQuiz(columns, quizzes);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return Objects.requireNonNull(quizzes).get(id);
    }
}
