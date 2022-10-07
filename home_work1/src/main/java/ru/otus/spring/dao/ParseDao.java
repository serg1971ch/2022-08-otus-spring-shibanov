package ru.otus.spring.dao;

import org.xml.sax.SAXException;
import ru.otus.spring.domain.Quiz;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface ParseDao {
    ArrayList<Quiz> parseFile() throws IOException, SAXException, ParserConfigurationException;
}
