package otus.spring;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.ParseQuizDaoImpl;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.otus.spring.domain.TypeResponse.RIGHT;
import static ru.otus.spring.domain.TypeResponse.WRONG;

public class QuizParseDaoImplTest {
    private static Quiz quiz1;
    private static Quiz quiz2;
    private static Quiz quiz3;
    private static Quiz quiz4;
    private static Quiz quiz5;
    private static ArrayList<Quiz> quizzesTest = new ArrayList<>();
    private static Answer[] listAnswersTest;
    private static QuizSimpleDaoImpl quizSimpleDao;
    private static ParseQuizDaoImpl parseQuizDao;

    @BeforeAll
    static void setup() {
        quiz1 = new Quiz(1,"What is the place of the Russian Federation in terms of oil reserves in the world and in terms of gas in the world?",
                new Answer("in terms of oil reserves, 10th place in the world, and in terms of gas, 3rd place;WRONG",WRONG),
                new Answer("in terms of oil reserves, 7th place in the world, and in terms of gas, 1st place",RIGHT),
                new Answer("3rd place in the world in terms of oil reserves, and 2nd place in terms of gas", WRONG));
        quiz2 = new Quiz(2,"From which republic of the USSR did the history of oil and gas production and processing begin?",
                new Answer("Russia",WRONG),
                new Answer("Azerbaijan",RIGHT),
                new Answer("Uzbekistan", WRONG));
        quiz3 = new Quiz(2,"Which country ranks first in natural gas production?",
                new Answer("Russia",WRONG),
                new Answer("USA",RIGHT),
                new Answer("Australia", WRONG));
        quiz4 = new Quiz(2,"Who in 1973 founded Novy Urengoy, the gas capital of modern Russia, with a pistol shot?",
                new Answer("V.D. Shashin",WRONG),
                new Answer("S.A. Orudzhev",RIGHT),
                new Answer("A.N. Kosygin", WRONG));
        quiz5 = new Quiz(2,"Where were oil supplies organized in 1942 during the Battle of Stalingrad, when Soviet troops were cut off from Baku and Grozny?",
                new Answer("Tashkent",WRONG),
                new Answer("Bashkir ASSR, Ishimbay",RIGHT),
                new Answer("USA, UK", WRONG));

        parseQuizDao = new ParseQuizDaoImpl();

    }

    @Test
    @DisplayName("Тест метода QuizSimpleDaoImpl.parseFile")
    void  testParseFile() {
        assertEquals(quizzesTest,parseQuizDao.parseFile());
    }

}
