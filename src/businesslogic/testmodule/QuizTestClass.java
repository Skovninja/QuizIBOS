package businesslogic.testmodule;

import businesslogic.surveymodule.Question;
import businesslogic.surveymodule.Quiz;
import datalayer.DBQuestion;

/**
 * Created by Ulrik on 20-05-2017.
 */
public class QuizTestClass {

    public static String testStringStatic = "This is a static String test from QuizTestClass..java";
    private StringBuilder gFXTest = new StringBuilder("Muføl");



    public Question questionTest() {
        return new Question(3);
    }

    public Quiz quizTest() {
        return new Quiz(1);
    }


}//End of Class
