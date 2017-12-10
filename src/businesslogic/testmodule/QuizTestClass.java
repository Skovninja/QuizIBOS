package businesslogic.testmodule;

import businesslogic.surveymodule.Question;
import businesslogic.surveymodule.Quiz;
import datalayer.DBOption;

/**
 * Created by Ulrik on 20-05-2017.
 */
public class QuizTestClass {

    public static String testStringStatic = "This is a static String test from QuizTestClass..java";
    private StringBuilder gFXTest = new StringBuilder("Muføl");


    //Test of DBOption
    public String testDBOption() {
        DBOption dBO = new DBOption();
        return dBO.getArrayListFrom(1).toString();
    }

    //Test of DBCore2 and its return of a result set.
//    public String  testDBCore2() {
//        DBCore2 dbc2 = new DBCore2();
//        ResultSet rs;
//        rs = dbc2.getArrayListFrom(1);
//
//        String rsName = "FAIL!!!";
//        try {
//            rs.next();
//            int rsID = rs.getInt("answer_id");
//            rsName = rs.getString("answer_text");
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return "BOOM!!!";
//        }
//        return rsName;
//    }

    //Test of Question object creation
    public Question questionTest() {
        return new Question(3);
    }

    //Test of Quiz object creation
    public Quiz quizTest() {
        return new Quiz(1);
    }


}//End of Class
