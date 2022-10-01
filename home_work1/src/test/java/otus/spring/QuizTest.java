package otus.spring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.otus.spring.dao.QuizSimpleDaoImpl;
import ru.otus.spring.domain.Answer;
import ru.otus.spring.domain.Quiz;
import ru.otus.spring.domain.TypeResponse;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuizTest {

    @Test
    @DisplayName("Тест метода QuizSimpleDaoImpl")
    void  findByIdTest(int id) {
        Quiz quiz = new Quiz(1,"What is the place of the Russian Federation in terms of oil reserves in the world and in terms of gas in the world?", new Answer("in terms of oil reserves, 10th place in the world, and in terms of gas, 3rd place", TypeResponse.WRONG),new Answer("in terms of oil reserves, 7th place in the world, and in terms of gas, 1st place", TypeResponse.RIGHT),new Answer("3rd place in the world in terms of oil reserves, and 2nd place in terms of gas", TypeResponse.WRONG));
        QuizSimpleDaoImpl dao = new QuizSimpleDaoImpl();
        assertEquals(quiz,dao.findById(1));
    }


//    @Test
//    @DisplayName("Тест метода ArrayList<Quiz> parseFile()")
//    void testParseFile() {
//        assertEquals();
//    }
}
