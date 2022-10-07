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
import java.util.List;

public class ParseFileServiceImpl implements ParseFileService {
    final static int INDEX_ANSWER_FIRST = 2;
    final static int INDEX_ANSWER_SECOND = 5;
    final static int INDEX_ANSWER_THIRD = 8;
    private static final ArrayList<String[]> quizzes = new ArrayList<>();

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();;
    Document doc = db.parse(new File("exsampleCSV/src/resource/resource.xml"));

    NodeList nameFile = doc.getElementsByTagName("name");
    Node node = nameFile.item(0);
    String filename = node.getTextContent();
    String csvName = "G:\\java\\exsamples\\exsampleCSV\\src\\resource\\quiz.csv";
    List<String> lines = new ArrayList<>();

    public ParseFileServiceImpl() throws ParserConfigurationException, IOException, SAXException {
    }

    public void getLines() throws IOException {
        try (BufferedReader br = Files.newBufferedReader(Paths.get("exsampleCSV/src/resource/" + filename))) {
            String DELIMITER = ";";
            String line;
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(DELIMITER);
                System.out.println("quiz[" + String.join(", ", columns) + "]");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

//    private ArrayList<Quiz> getListQuiz() {
//        for (int i = 1; i < 6; i++) {
//            columns = lines.get(i).split(";", 10);
//            answerFirst = new Answer(columns[INDEX_ANSWER_FIRST], TypeResponse.WRONG);
//            answerSecond = new Answer(columns[INDEX_ANSWER_SECOND], TypeResponse.RIGHT);
//            answerThird = new Answer(columns[INDEX_ANSWER_THIRD], TypeResponse.WRONG);
//            quizzes.add(new Quiz(i, columns[INDEX_QUESTION], answerFirst, answerSecond, answerThird));
//        }
//        return quizzes;
//    }

    @Override
    public ArrayList<Quiz> parseFile() throws IOException, SAXException, ParserConfigurationException {
        return null;
    }
}
