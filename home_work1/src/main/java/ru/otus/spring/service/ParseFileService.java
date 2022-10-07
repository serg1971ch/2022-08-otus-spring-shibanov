package ru.otus.spring.service;

import org.xml.sax.SAXException;
import ru.otus.spring.domain.Quiz;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

public interface ParseFileService {
    ArrayList<Quiz> parseFile() throws IOException, SAXException, ParserConfigurationException;
}
