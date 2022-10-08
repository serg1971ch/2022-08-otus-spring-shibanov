package ru.otus.spring.service;

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

public class ParseCSVFileServiceimp implements ParseCSVFilieServise {
    final static int INDEX_QUESTION = 0;
    final static int INDEX_ANSWER_FIRST = 2;
    final static int INDEX_ANSWER_SECOND = 5;
    final static int INDEX_ANSWER_THIRD = 8;
    private static ArrayList<Quiz> quizzes = new ArrayList<>();

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.parse(new File("exsampleCSV/src/resource/resource.xml"));

    NodeList nameFile = doc.getElementsByTagName("name");
    Node node = nameFile.item(0);
    String filename = node.getTextContent();
//    String csvName = "G:\\java\\exsamples\\exsampleCSV\\src\\resource\\quiz.csv";

    public ParseCSVFileServiceimp() throws ParserConfigurationException, IOException, SAXException {
    }

    public Quiz getById(int id)  {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("home_work1/src/resource/" + filename))) {
            String DELIMITER = ";";
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                System.out.println("quiz[" + String.join(", ", columns) + "]");
                quizzes = this.getListQuiz(columns, quizzes);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return quizzes.get(id);
    }

    private ArrayList<Quiz> getListQuiz(String[] columns, ArrayList<Quiz> quizzes ) {
        for (int i = 1; i < 6; i++) {
//            columns = lines.get(i).split(";", 10);
            Answer answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
            Answer answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
            Answer answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
        }
        return quizzes;
    }
}
